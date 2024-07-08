package com.food.Osahaneat.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String desc;

    @Column(name = "price")
    private double price;

    @Column(name = "instruction") // Tên file hình ảnh của menu lưu trên ổ cứng
    private String intruction;

    @ManyToOne
    @JoinColumn(name = "cate_res_id")
    private CategoryRestaurant categoryRestaurant;

    @OneToMany(mappedBy = "food")
    private Set<OrderItem> listOrderItem;

    @OneToMany(mappedBy = "food")
    private Set<RatingFood> listratingFood;

    public Set<RatingFood> getListratingFood() {
        return listratingFood;
    }

    public void setListratingFood(Set<RatingFood> listratingFood) {
        this.listratingFood = listratingFood;
    }

    public Set<OrderItem> getListOrderItem() {
        return listOrderItem;
    }

    public void setListOrderItem(Set<OrderItem> listOrderItem) {
        this.listOrderItem = listOrderItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIntruction() {
        return intruction;
    }

    public void setIntruction(String intruction) {
        this.intruction = intruction;
    }

    public CategoryRestaurant getCategoryRestaurant() {
        return categoryRestaurant;
    }

    public void setCategoryRestaurant(CategoryRestaurant categoryRestaurant) {
        this.categoryRestaurant = categoryRestaurant;
    }
}
