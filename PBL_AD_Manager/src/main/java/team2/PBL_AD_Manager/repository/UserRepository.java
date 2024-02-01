package team2.PBL_AD_Manager.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import team2.PBL_AD_Manager.domain.User;

@Repository
@RequiredArgsConstructor
public class UserRepository {
	private final EntityManager em;

	public void save(User user) {
		em.persist(user);
	}

	public User findOne(Long id) {
		return em.find(User.class, id);
	}

	public List<User> findAll(){
		return em.createQuery("select u from User u", User.class).getResultList();
	}
}
