package com.crio.order_management_app.service;

import com.crio.order_management_app.model.Order;
import com.crio.order_management_app.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    public OrderServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateOrder() {
        Order order = new Order();
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        Order created = orderService.createOrder(order);
        assertNotNull(created);
    }

    @Test
    void testGetOrderById() {
        Order order = new Order();
        order.setId(1L);
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        Optional<Order> found = orderService.getOrderById(1L);
        assertTrue(found.isPresent());
        assertEquals(1L, found.get().getId());
    }
}
