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

        Address address = new Address("city", "street", "zipcode");
        Member member = new Member();
        member.setUsername("member1");
        member.setAddress(address);
        entityManager.persist(member);

        Address address2 = new Address("city2", "street", "zipcode");
        Member member2 = new Member();
        member.setUsername("member2");
        member.setAddress(address2);
        entityManager.persist(member2);


        tx.commit();
        entityManager.close();
        emf.close();
    }
}
