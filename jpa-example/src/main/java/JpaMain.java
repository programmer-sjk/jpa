import domain.Member;
import domain.Orders;
import domain.Product;
import domain.Team;

import javax.persistence.*;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Team team = new Team("team1");
        em.persist(team);

        Member member = new Member();
        member.setId("member1");
        member.setName("서정국");
        member.setTeam(team);
        em.persist(member);

        em.flush();
        em.clear();
        Team findTeam = em.find(Team.class, 1L);
        findTeam.getMembers().get(0);
        tx.commit();

        em.close();
        emf.close();
    }
}
