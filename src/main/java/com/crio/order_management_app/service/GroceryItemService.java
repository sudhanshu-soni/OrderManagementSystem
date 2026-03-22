package com.crio.order_management_app.service;

import com.crio.order_management_app.model.GroceryItem;
import com.crio.order_management_app.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryItemService {
    @Autowired
    private GroceryItemRepository groceryItemRepository;

    public List<GroceryItem> getAllItems() {
        return groceryItemRepository.findAll();
    }

    public Optional<GroceryItem> getItemById(Long id) {
        return groceryItemRepository.findById(id);
    }

    public GroceryItem createItem(GroceryItem item) {
        return groceryItemRepository.save(item);
    }

    public GroceryItem updateItem(Long id, GroceryItem itemDetails) {
        return groceryItemRepository.findById(id).map(item -> {
            item.setName(itemDetails.getName());
            item.setCategory(itemDetails.getCategory());
            item.setPrice(itemDetails.getPrice());
            item.setQuantity(itemDetails.getQuantity());
            return groceryItemRepository.save(item);
        }).orElse(null);
    }

    public void deleteItem(Long id) {
        groceryItemRepository.deleteById(id);
    }
}
