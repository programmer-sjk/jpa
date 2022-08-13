package jpabook.jpashop;


import jpabook.jpashop.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Book book = new Book();
        book.setName("JPA");
        book.setAuthor("서정국");
        entityManager.persist(book);

        tx.commit();
        entityManager.close();
        emf.close();
    }
}
