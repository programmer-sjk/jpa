import domain.Member;
import domain.Orders;
import domain.Product;

import javax.persistence.*;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Member member = new Member();
        member.setId("member1");
        member.setName("서정국");
        em.persist(member);
        tx.commit();

        tx.begin();
        em.clear();
        Member findMember = em.getReference(Member.class, "member1");
        tx.commit();

        em.close();
        findMember.getName();

        emf.close();
    }
}
