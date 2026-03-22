package com.crio.order_management_app.service;

import com.crio.order_management_app.model.GroceryItem;
import com.crio.order_management_app.repository.GroceryItemRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GroceryItemServiceTest {
    @Mock
    private GroceryItemRepository groceryItemRepository;

    @InjectMocks
    private GroceryItemService groceryItemService;

    public GroceryItemServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateItem() {
        GroceryItem item = new GroceryItem();
        item.setName("Apple");
        when(groceryItemRepository.save(any(GroceryItem.class))).thenReturn(item);
        GroceryItem created = groceryItemService.createItem(item);
        assertEquals("Apple", created.getName());
    }

    @Test
    void testGetItemById() {
        GroceryItem item = new GroceryItem();
        item.setId(1L);
        when(groceryItemRepository.findById(1L)).thenReturn(Optional.of(item));
        Optional<GroceryItem> found = groceryItemService.getItemById(1L);
        assertTrue(found.isPresent());
        assertEquals(1L, found.get().getId());
    }
}
