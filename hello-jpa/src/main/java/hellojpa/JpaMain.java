package hellojpa;

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

        List<Member> members = entityManager.createQuery(
                "select m from Member m where m.username like '%kim%'",
                Member.class
        ).getResultList();

        tx.commit();
        entityManager.close();
        emf.close();
    }
}