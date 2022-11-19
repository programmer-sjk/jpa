package jpabook.jpashop;

import jpabook.jpashop.domain.Board;
import jpabook.jpashop.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Member member = new Member();
            member.setId("asdad");
            member.setUsername("서정국");
            em.persist(member);
//            Board board = new Board();
//            em.persist(board);
//            System.out.println(board.getId());
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
