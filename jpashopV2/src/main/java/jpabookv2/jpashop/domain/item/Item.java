package jpabookv2.jpashop.domain.item;

import jpabookv2.jpashop.domain.Category;
import jpabookv2.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;


    @ManyToMany(mappedBy = "items")
    private List<Category> categoryList = new ArrayList<>();


    // 비즈니스 로직
    public void addStock(int stockQuantity){
        this.stockQuantity += stockQuantity;
    }

    public void removeStock(int stockQuantity){
        int restStock = this.stockQuantity - stockQuantity;
        if(restStock < 0){
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
