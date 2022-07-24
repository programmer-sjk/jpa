package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Member findMember = entityManager.find(Member.class, 1L);
        findMember.setName("Hello JPA");
//        System.out.println("findMember id = " + findMember.getId());
//        System.out.println("findMember name = " + findMember.getName());

//        entityManager.persist(member);
        tx.commit();

        entityManager.close();
        emf.close();
    }
}
