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

        Member member = new Member();
        member.setUsername("user1");
        member.setHomeAddress(new Address("city", "street", "10000"));

        member.getFavoriteFoods().add("치킨");
        member.getFavoriteFoods().add("족발");
        member.getFavoriteFoods().add("피자");

        member.getAddressHistory().add(new Address("city1", "street1", "10000"));
        member.getAddressHistory().add(new Address("city2", "street1", "10000"));

        entityManager.persist(member);

        entityManager.flush();
        entityManager.clear();

        System.out.println("========================");
        Member findMember = entityManager.find(Member.class, member.getId());

        List<Address> addressHistory = findMember.getAddressHistory();
        for(Address address : addressHistory) {
            System.out.println("address = " + address.getCity());
        }

        // 치킨 -> 한식
        findMember.getFavoriteFoods().remove("치킨");
        findMember.getFavoriteFoods().add("한식");

        tx.commit();
        entityManager.close();
        emf.close();
    }
}
