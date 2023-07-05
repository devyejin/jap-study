package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //주문을 찾고, 주문에서 주문자 정보를 찾고싶음
            Order order = em.find(Order.class, 1L);
            String memberId = order.getMemberId();

            em.find(Member.class, memberId);



        }catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }


    }
}
