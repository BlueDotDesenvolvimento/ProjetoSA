package projetoSA.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import projetoSA.security.ProjetoDetailsService;

@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ProjetoDetailsService projetoDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http

				// Habilitar ou desabilitar paginas

				.authorizeRequests().antMatchers("/").hasRole("padrao").antMatchers("/cadastro").permitAll()
				.antMatchers("/funcionarios/**").hasRole("padrao")

				// Habilitar statics

				.antMatchers("/bootstrap-4.5.3-dist/**").permitAll().antMatchers("/css/**").permitAll()
				.antMatchers("/fontawesome-free-5.15.1-web/**").permitAll().antMatchers("/jquery-3.5.1/**").permitAll()
				.antMatchers("/js/**").permitAll().antMatchers("/images/**").permitAll()

				// Outras autenticações

				.anyRequest().authenticated().and()

				// Definir página de login

				.formLogin().loginPage("/login").defaultSuccessUrl("/", true).permitAll().and()

				// Relembrar usuário logado

				.rememberMe();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(projetoDetailsService).passwordEncoder(new BCryptPasswordEncoder());

	}

	public static void main(String[] args) {

		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}

}