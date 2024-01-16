package team2.PBL_AD_Manager.test;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
public class MemberTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    void 멤버(){
        Member member = new Member();
        member.setName("member1");
        memberRepository.save(member);

        Member member1 = em.find(Member.class, member.getId());
        System.out.println("member1 = " + member1);
    }
}
