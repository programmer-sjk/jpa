package jpabook.jpashop;


import jpabook.jpashop.domain.Member;

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

            String id = "id1";
            Member member = new Member();
            member.setId(id);
            member.setUsername("서정국");
            member.setAge(33);

            em.persist(member);
            member.setAge(34);
//
//            Member findMember = em.find(Member.class, id);
//            System.out.println("findMember=" + findMember.getUsername() + ", age:" + findMember.getAge());
//
//            List<Member> members = em.createQuery("select m from Member m", Member.class)
//                    .getResultList();
//            System.out.println("member.size = " + members.size());
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
