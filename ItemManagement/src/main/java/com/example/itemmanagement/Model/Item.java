package com.example.itemmanagement.Model;

import org.springframework.data.annotation.Id;

public class Item {

    @Id
    private long id;
    private String title;
    private String desc;
    private String imagePath;
    private Long price;

    public Item(Item item) {
        this.id = item.getId();
        this.title = item.getTitle();
        this.desc = item.getDesc();
        this.imagePath = item.getImagePath();
        this.price = item.getPrice();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Item(long id, String title, String desc, String imagePath, Long price) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.imagePath = imagePath;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", price=" + price +
                '}';
    }
}
