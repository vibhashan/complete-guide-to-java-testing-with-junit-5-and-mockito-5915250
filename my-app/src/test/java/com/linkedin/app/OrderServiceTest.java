package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
    private static final String CUSTOMER_NAME = "Billy";
    private Order existingOrder;
    private Order nonExistingOrder;

    @Mock
    private static OrderRepository orderRepositoryMock;

    @InjectMocks
    private OrderService orderService;

    @Captor
    ArgumentCaptor<Order> orderArg;

    @Test
    void createOrder() {
        orderService.createOrder(CUSTOMER_NAME);
        verify(orderRepositoryMock).save(orderArg.capture());

        Order order = orderArg.getValue();

        assertNotNull(order);
        assertAll(
                () -> assertEquals(CUSTOMER_NAME, order.getCustomerName()),
                () -> assertEquals(0, order.getItems().size()));

    }

    @Nested
    class NestedTest {
        @BeforeEach
        void setUp() {
            existingOrder = new Order(CUSTOMER_NAME);
            nonExistingOrder = new Order("Bob");

            when(orderRepositoryMock.findById(existingOrder.getOrderId())).thenReturn(existingOrder);
            when(orderRepositoryMock.findById(nonExistingOrder.getOrderId())).thenReturn(null);
        }

        @Test
        void updateOrder() {
            Item item = new Item("Apples", 100);
            existingOrder.addItem(item);

            // Happy path
            orderService.updateOrder(existingOrder);
            verify(orderRepositoryMock).save(existingOrder);

            IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                    () -> orderService.updateOrder(nonExistingOrder));
            assertEquals(e.getMessage(), "Order not found");
        }

        @Test
        void getOrder() {
            // Happy path
            Order order = orderService.getOrder(existingOrder.getOrderId());
            assertNotNull(order);
            assertAll(
                    () -> assertEquals(CUSTOMER_NAME, order.getCustomerName()),
                    () -> assertEquals(0, order.getItems().size()));

            // Unhappy path
            IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                    () -> orderService.getOrder(nonExistingOrder.getOrderId()));
            assertEquals(e.getMessage(), "Order not found");
        }
    }

}
