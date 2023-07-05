package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name="ORDER_ITEM")
public class OrderItem {

    @Id
    @GeneratedValue()
    @Column(name="ORDER_ITEM_ID")
    private Long id;

    @Column(name="ORDER_ID")
    private Long orderId; //주문자 정보(FK)
    @Column(name="ITEM_ID")
    private Long itemId; //상품 정보(FK)
    private int orderPrice;
    private int count;


}
