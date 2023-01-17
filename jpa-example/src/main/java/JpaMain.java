import domain.Member;
import domain.MemberProduct;
import domain.Product;
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
        em.persist(member);

        Product product = new Product();
        product.setName("product1");
        em.persist(product);

        MemberProduct memberProduct = new MemberProduct();
        memberProduct.setMember(member);
        memberProduct.setProduct(product);
        memberProduct.setOrderAmount(2);
        em.persist(memberProduct);

        tx.commit();

        em.close();
        emf.close();
    }
}
