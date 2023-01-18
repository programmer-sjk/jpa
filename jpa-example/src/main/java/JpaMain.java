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

        em.flush();
        em.clear();
        Member findMember = em.find(Member.class, "member1");
        tx.commit();

        em.close();
        emf.close();
    }
}
