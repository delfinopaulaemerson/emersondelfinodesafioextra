package br.com.appservice.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.appservice.model.User;

@Component("usuarioDaoImpl")
public class UsuarioDaoImpl implements UsuarioDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void inserirUsuario(User user) throws Exception{
		User u = new User();
		u.setNome(user.getNome());
		u.setSobrenome(user.getSobrenome());
		u.setCpf(user.getCpf());
		
		this.entityManager.persist(u);
		this.entityManager.flush();
		this.entityManager.clear();
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public User findById(Long idUser)throws Exception {
		User user = new User();
		user = this.entityManager.find(User.class, idUser);
		return user;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void upadateUsuario(User user) throws Exception {
		User u = new User();
		u = this.entityManager.find(User.class, user.getId());
		u.setNome(user.getNome());
		u.setSobrenome(user.getSobrenome());
		u.setCpf(user.getCpf());
		
		this.entityManager.persist(u);
		this.entityManager.flush();
		this.entityManager.clear();
		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void deleteUsuario(Long idUsuario) throws Exception {
		User u = this.entityManager.find(User.class, idUsuario);
		this.entityManager.remove(u);
		
		this.entityManager.flush();
		this.entityManager.clear();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public User findNomeAndCpf(String nome, String cpf) throws Exception {
		Query query = null;
		User user = null;
		
		query = this.entityManager.createQuery("SELECT u FROM User u WHERE u.nome=:nome and u.cpf=:cpf ");
		query.setParameter("nome", nome);
		query.setParameter("cpf", cpf);
		
		user = (User) query.getSingleResult();
		
		return user;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
