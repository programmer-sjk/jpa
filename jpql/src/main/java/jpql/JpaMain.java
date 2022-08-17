package jpql;

import jpql.dto.MemberDto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Member member = new Member();
        member.setUsername("꾸기");
        member.setAge(33);
        entityManager.persist(member);

        entityManager.flush();
        entityManager.clear();

        List<MemberDto> result = entityManager.createQuery("select new jpql.dto.MemberDto(m.username, m.age) from Member m", MemberDto.class).getResultList();
        MemberDto findMember = result.get(0);

        System.out.println("memberDto = " + findMember.getUsername());

        tx.commit();
        entityManager.close();
        emf.close();
    }
}
