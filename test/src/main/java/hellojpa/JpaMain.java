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

        Member member = new Member();
        member.setUsername("hello");
        entityManager.persist(member);

        entityManager.flush();
        entityManager.clear();

//        Member findMember = entityManager.find(Member.class, member.getId());
        Member findMember = entityManager.getReference(Member.class, member.getId());

        System.out.println("before findMember = " + findMember.getClass());
        System.out.println("findMember name = " + findMember.getUsername());
//        System.out.println("findMember id = " + findMember.getId());
        System.out.println("after findMember = " + findMember.getClass());

        tx.commit();
        entityManager.close();
        emf.close();
    }
}
