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


        Member member = entityManager.find(Member.class, 150L);
        member.setName("AAAAA");
        entityManager.detach(member);

        System.out.println("=========================");
        tx.commit();

        entityManager.close();
        emf.close();
    }
}
