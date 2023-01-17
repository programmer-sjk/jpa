import domain.Member;
import domain.Orders;
import domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Member member = new Member();
        member.setName("member1");
        em.persist(member);

        Product product = new Product();
        product.setName("product1");
        em.persist(product);

        Orders order = new Orders();
        order.setMember(member);
        order.setProduct(product);
        order.setOrderAmount(2);
        em.persist(order);

        tx.commit();

        em.close();
        emf.close();
    }
}
