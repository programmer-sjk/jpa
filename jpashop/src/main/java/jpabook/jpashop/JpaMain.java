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
            Member member1 = new Member();
            em.persist(member1);

            Member member2 = new Member();
            em.persist(member2);

            Member member3 = new Member();
            em.persist(member3);


            Order order = new Order();
            order.setMember(member1);
            em.persist(order);

            Order order2 = new Order();
            order2.setMember(member2);
            em.persist(order2);

            Order order3 = new Order();
            order3.setMember(member3);
            em.persist(order3);
            tx.commit();

            tx.begin();
            em.clear();
//            em.find(Member.class, 1L);
            List<Member> members = em.createQuery("select m from Member m", Member.class)
                            .getResultList();
            for (Member member : members) {
                System.out.println(member.getOrders().size());
            }
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
