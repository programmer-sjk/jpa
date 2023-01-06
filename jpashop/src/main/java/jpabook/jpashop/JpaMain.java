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
            Team team = new Team();
            team.setId("t1");
            team.setName("t1");
            em.persist(team);

            Member member = new Member();
            member.setId("m1");
            member.setName("m1");
            member.setTeam(team);
            em.persist(member);
            tx.commit();


            tx.begin();
            em.clear();
            Member find = em.find(Member.class, "m1");
            System.out.println("step1");
            Team team1 = find.getTeam();
            System.out.println("step2");
            team1.getName();
            System.out.println("step3");
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
