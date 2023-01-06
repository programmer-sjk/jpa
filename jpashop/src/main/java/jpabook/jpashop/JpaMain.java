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
            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            child1.setParent(parent);
            child2.setParent(parent);
            parent.getChilds().add(child1);
            parent.getChilds().add(child2);
            em.persist(parent);
            tx.commit();

            tx.begin();
            Parent findParent = em.find(Parent.class, 1L);
            Child findChild1 = em.find(Child.class, 1L);
            Child findChild2 = em.find(Child.class, 2L);

            em.remove(findParent);
            em.remove(findChild1);
            em.remove(findChild2);
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
