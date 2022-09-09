package com.example.itemmanagement.Dao;

import com.example.itemmanagement.Model.Item;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Configuration
public class ItemDao implements Dao<Item> {

    private List<Item> items = new ArrayList<>();

    public ItemDao() {
        Item item = new Item(01L, "Item1", "This is Item 1", "//path", (long) 12.0);
        items.add(item);
    }

    @Override
    public Optional<Item> get(long id) {
        return Optional.ofNullable(items.get((int) id));
    }

    @Override
    public List<Item> getAll() {
        return items;
    }

    @Override
    public void save(Item item) {
        items.add(item);
    }

    @Override
    public void update(Item item, String[] params) {

        for(Item temp : items){
            if(temp.getId() == item.getId()){
                temp.setTitle(item.getTitle());
                temp.setDesc(item.getDesc());
                temp.setImagePath(item.getImagePath());
                temp.setPrice(item.getPrice());
            }
        }
    }

    @Override
    public void delete(Item item) {
        for(Item temp : items){
            if(temp.getId() == item.getId()){
                items.remove(temp);
            }
        }
        //items.remove(new Item(item));
    }
}
