package team2.PBL_AD_Manager.service;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import team2.PBL_AD_Manager.domain.Gender;

@Service
@RequiredArgsConstructor
public class TargetService {
	private final EntityManager em;

	public Long findId(int age, Gender gender) {
		return (Long)em.createQuery("SELECT t.id FROM TargetInf t WHERE t.age = :age AND t.gender = :gender")
			.setParameter("age", age).setParameter("gender", gender)
			.getSingleResult();
	}
}
