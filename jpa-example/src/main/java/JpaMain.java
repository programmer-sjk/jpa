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
        tx.commit();

        tx.begin();
        em.clear();
        Member findMember = em.find(Member.class, 1L);
        tx.commit();

        em.close();
        emf.close();
    }
}
