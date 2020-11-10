package projetoSA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projetoSA.model.Permissao;
import projetoSA.model.Usuario;

public interface PermissaoRepository extends JpaRepository<Permissao, Long>{

	public List<Permissao> findByUsuariosIn(Usuario ... usuario);
	
}