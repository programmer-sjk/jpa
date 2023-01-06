package jpabook.jpashop;

import jpabook.jpashop.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Parent parent = new Parent();
            em.persist(parent);

            Child child1 = new Child();
            child1.setParent(parent);
            parent.getChilds().add(child1);
            em.persist(child1);

            Child child2 = new Child();
            child2.setParent(parent);
            parent.getChilds().add(child2);
            em.persist(child2);

            tx.commit();

        } catch (Exception e) {
            System.out.println("message: " + e.getMessage());
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
