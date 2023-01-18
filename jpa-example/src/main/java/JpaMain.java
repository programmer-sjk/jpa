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
        Member findMember = em.find(Member.class, "member1");
        System.out.println("====");
        System.out.println(em.getEntityManagerFactory().getPersistenceUnitUtil().isLoaded(findMember.getTeam()));
        tx.commit();

        em.close();
        emf.close();
    }
}
