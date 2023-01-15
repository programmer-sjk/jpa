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
        member.setName("꾸");
        em.persist(member);

        tx.commit();

        tx.begin();
        Member findMember = em.find(Member.class, 1L);
        em.clear();
        findMember.setName("꾸기");
        tx.commit();


        em.close();
        emf.close();
    }
}
