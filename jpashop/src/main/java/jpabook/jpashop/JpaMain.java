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
            parent.setId1("id1");
            parent.setId2("id2");
            em.persist(parent);
            tx.commit();

            tx.begin();
            ParentId ids = new ParentId("id1", "id2");
            Parent p = em.find(Parent.class, ids);
            System.out.println(p.getId1());
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
