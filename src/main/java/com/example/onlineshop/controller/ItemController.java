package com.example.onlineshop.controller;

import com.example.onlineshop.model.Item;
import com.example.onlineshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/items")
public class ItemController {
    private static final Logger logger = Logger.getLogger(ItemController.class.getName());

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        logger.info("Items successfully retrieved");
        return ResponseEntity.ok(items);
    }

    @PostMapping
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        Item savedItem = itemService.addItem(item);
        logger.info("Item successfully added: " + savedItem.getName());
        return ResponseEntity.ok(savedItem);
    }
}
