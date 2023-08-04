package jpabookv2.jpashop.service;

import jpabookv2.jpashop.domain.Address;
import jpabookv2.jpashop.domain.Member;
import jpabookv2.jpashop.domain.Order;
import jpabookv2.jpashop.domain.OrderStatus;
import jpabookv2.jpashop.domain.item.Book;
import jpabookv2.jpashop.domain.item.Item;
import jpabookv2.jpashop.exception.NotEnoughStockException;
import jpabookv2.jpashop.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void 상품주문() throws Exception {

        Member member = createMember("회원1");

        Book book = createBook("시골 JPA", 10000, 10);

        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), book.getId(), orderCount);

        Order getOrder = orderRepository.findOne(orderId);

        assertEquals("상품 주문시 상태는 ORDER", OrderStatus.ORDER, getOrder.getStatus());
        assertEquals("주문 상품종류수가 정확해야 한다.", 1, getOrder.getOrderItemList().size());
        assertEquals("주문 가격은 가격 * 수량이다.", 10000 * orderCount, getOrder.getTotalPrice());
        assertEquals("주문 수량만큼 재고가 줄어야 한다.", 8, book.getStockQuantity());
    }



    @Test
    public void 주문취소() throws Exception {
        Member member = createMember("Jeong");
        Book item = createBook("시골 JPA", 10000, 10);

        int orderCount = 2;

        Long orderId = orderService.order(member.getId(), item.getId(), orderCount);

        orderService.cancelOrder(orderId);

        Order getOrder = orderRepository.findOne(orderId);

        assertEquals("주문 취소시 상태는 CANCEL 이다.",OrderStatus.CANCEL,getOrder.getStatus());
        assertEquals("주문이 취소된 그 만큼 재고가 증가해야 한다.",10,item.getStockQuantity());
    }

    @Test(expected = NotEnoughStockException.class)
    public void 상품주문_재고수량초과() throws Exception {
        Member member = createMember("회원1");
        Item book = createBook("시골 JPA", 10000, 10);

        int orderCount = 11;

        orderService.order(member.getId(),book.getId(),orderCount);

        fail("재고 수량 부족 예외가 발생해야 한다.");
    }




    private Book createBook(String name, int price, int stockQuantity) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(price);
        book.setStockQuantity(stockQuantity);
        em.persist(book);
        return book;
    }

    private Member createMember(String name) {
        Member member = new Member();
        member.setName(name);
        member.setAddress(new Address("서울", "강가", "123-123"));
        em.persist(member);
        return member;
    }
}