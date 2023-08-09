package jpabookv2.jpashop.repository;

import jpabookv2.jpashop.domain.OrderStatus;
import lombok.Getter;

@Getter
public class OrderSearch {
    private String memberName;
    private OrderStatus orderStatus;    // order cancel
}
