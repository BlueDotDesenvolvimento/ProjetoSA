package projetoSA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetoSA.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByLogin(String login);

}