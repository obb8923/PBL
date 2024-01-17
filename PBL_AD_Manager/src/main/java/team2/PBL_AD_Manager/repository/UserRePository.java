package team2.PBL_AD_Manager.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import team2.PBL_AD_Manager.domain.Gender;
import team2.PBL_AD_Manager.domain.User;

import java.lang.reflect.Member;

@Repository
@RequiredArgsConstructor
public class UserRePository {
    private final EntityManager em;

    public void save(User user){
        em.persist(user);
    }

    public User fincOne(Long id){
        return em.find(User.class, id);
    }

}
