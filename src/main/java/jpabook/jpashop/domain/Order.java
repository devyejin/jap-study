package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter //set의경우 주의
@Getter
@Entity
@Table(name="ORDERS") // DB에 ORDER가 예약어인곳이 많음
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //AUTO 기본값
    @Column(name="ORDER_ID")
    private Long id;


    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;


    @ManyToOne // 매핑은 여기에 name 속성이 아님
    @JoinColumn(name="MEMBER_ID") // MEMBER 테이블의 MEMBER_ID 칼럼이랑 조인
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    //편의메서드 - setOrderItem 대신
    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
        //양방향을 위해
        orderItem.setOrder(this);
    }

}
