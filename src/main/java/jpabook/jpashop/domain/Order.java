package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Setter //set의경우 주의
@Getter
@Entity
@Table(name="ORDERS") // DB에 ORDER가 예약어인곳이 많음
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //AUTO 기본값
    @Column(name="ORDER_ID")
    private Long id;
    @Column(name="MEMBER_ID")
    private String memberId; //주문자 정보(FK)

    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
