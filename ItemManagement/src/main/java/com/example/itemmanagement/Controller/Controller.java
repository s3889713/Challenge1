package com.example.itemmanagement.Controller;

import com.example.itemmanagement.Dao.ItemDao;
import com.example.itemmanagement.Exceptions.ItemAlreadyExists;
import com.example.itemmanagement.Exceptions.ItemDoesNotExist;
import com.example.itemmanagement.Model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private ItemDao itemDao;

    @PostMapping(value="/item", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> createItem(@RequestBody Item item, String[] params){
        try {
            for (Item temp : itemDao.getAll()) {
                if (temp.getId() == item.getId()) {
                    throw new ItemAlreadyExists("Item exists");
                }
            }
            itemDao.save(item);
            return ResponseEntity.created(URI.create(String.format(item.toString()))).body(item);
        }
        catch (ItemAlreadyExists mes){
            return null;
        }
    }

    @GetMapping("/item/item{id}")
    public Optional<Item> getItem(@PathVariable long id){
        try {
            for (Item temp : itemDao.getAll()) {
                if (temp.getId() == id) {
                    return Optional.of(temp);
                }
            }
            throw new ItemDoesNotExist("item does not exist");
        }
        catch (ItemDoesNotExist mes){
            System.out.println(mes);
            return null;
        }
    }

    @GetMapping("/item/item")
    public List<Item> getItemList(){
        return itemDao.getAll();
    }

    @PutMapping("/item/item")
    public void updateItem(@RequestBody Item item, String[] params){
        try {
            for (Item temp : itemDao.getAll()) {
                if (temp.getId() == item.getId()) {
                    itemDao.update(item, params);
                }
            }
            throw new ItemDoesNotExist("item does not exist");
        }
        catch (ItemDoesNotExist mes){
            System.out.println(mes);
        }
    }

    @DeleteMapping ("/item/item")
    public void deleteItem(@RequestBody Item item){

        try {
            for (Item temp : itemDao.getAll()) {
                if (temp.getId() == item.getId()) {
                    itemDao.delete(item);
                }
            }
            throw new ItemDoesNotExist("item does not exist");
        }
        catch (ItemDoesNotExist mes){
            System.out.println(mes);
        }
    }
}
