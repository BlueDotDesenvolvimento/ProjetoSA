package projetoSA.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UsuarioSistema extends User {

	private static final long serialVersionUID = 3227630979354608042L;
	private String nome;

	public UsuarioSistema(String nome, String login, String senha,
			Collection<? extends GrantedAuthority> autorizacoes) {
		super(login, senha, autorizacoes);
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
}