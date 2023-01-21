import domain.*;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Member member = new Member();
        member.setId("member1");
        member.setName("서정국");
        member.setVip(true);
        em.persist(member);
        em.flush();
        em.clear();

        Member refMember = em.getReference(Member.class, "member1");
        Member findMember = em.find(Member.class, "member1");
        System.out.println(refMember.getClass());
        System.out.println(findMember.getClass());
        System.out.println(refMember == findMember);
        tx.commit();

        em.close();
        emf.close();
    }
}
