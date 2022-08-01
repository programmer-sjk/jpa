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

        Team team = new Team();
        team.setName("teamA");
        entityManager.persist(team);

        Member member = new Member();
        member.setUsername("member1");
        member.setTeam(team);
        entityManager.persist(member);

        entityManager.flush();
        entityManager.clear();

        Member findMember = entityManager.find(Member.class, member.getId());
        List<Member> members = findMember.getTeam().getMembers();

        for(Member m : members) {
            System.out.println("m = " + m.getUsername());
        }

        tx.commit();
        entityManager.close();
        emf.close();
    }
}
