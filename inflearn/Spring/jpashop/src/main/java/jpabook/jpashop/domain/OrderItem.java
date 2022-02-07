package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class OrderItem extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    private int oederPrice;
    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOederPrice() {
        return oederPrice;
    }

    public void setOederPrice(int oederPrice) {
        this.oederPrice = oederPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
