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
        member.changeTeam(team);
        entityManager.persist(member);

        Team findTeam = entityManager.find(Team.class, team.getId());
        List<Member> members = findTeam.getMembers();

        System.out.println("=========");
        for(Member m : members) {
            System.out.println("m = " + m.getUsername());
        }
        System.out.println("=========");

        tx.commit();
        entityManager.close();
        emf.close();
    }
}
