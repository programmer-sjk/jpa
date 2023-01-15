import domain.Member;
import domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Member member = new Member();
        member.setName("member1");

        Team team = new Team("team");
        team.addMember(member);
        em.persist(team);
        em.persist(member);

        tx.commit();

        tx.begin();
        List<Member> members = team.getMembers();
        System.out.println(members.size());
        tx.commit();

        em.close();
        emf.close();
    }
}
