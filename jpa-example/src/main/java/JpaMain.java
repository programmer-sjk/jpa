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
        em.persist(member);
        em.flush();
        em.clear();

        String jpql = "select m from Member m where m.name = '서정국'";
        em.createQuery(jpql, Member.class).getResultList();
        em.createQuery(jpql, Member.class).getResultList();
        tx.commit();

        em.close();
        emf.close();
    }
}
