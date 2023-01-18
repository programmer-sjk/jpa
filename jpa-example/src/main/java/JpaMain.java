import domain.*;

import javax.persistence.*;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Parent parent = new Parent();

        Child child1 = new Child();
        child1.setParent(parent);

        Child child2 = new Child();
        child2.setParent(parent);

        parent.addChild(child1);
        parent.addChild(child2);
        em.persist(parent);
        tx.commit();

        tx.begin();
        parent.getChildren().remove(0);
        tx.commit();

        em.close();
        emf.close();
    }
}
