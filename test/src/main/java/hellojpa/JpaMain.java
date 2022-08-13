package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Member member = new Member();
        member.setCreateBy("kim");
        member.setUsername("user");
        member.setCreateDate(LocalDateTime.now());

        entityManager.persist(member);

        tx.commit();
        entityManager.close();
        emf.close();
    }
}
