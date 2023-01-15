import domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member = new Member();
        member.setId(1L);
        em.persist(member);
        System.out.println("after 1L");

        Member member2 = new Member();
        member2.setId(2L);
        em.persist(member2);
        System.out.println("after 2L");

        Member member3 = new Member();
        member3.setId(3L);
        em.persist(member3);
        System.out.println("after 3L");

        tx.commit();

        em.close();
        emf.close();
    }
}
