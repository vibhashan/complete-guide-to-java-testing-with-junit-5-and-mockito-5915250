package com.linkedin.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

  private static final String CUSTOMER_NAME = "John Doe";

  @Mock
  private OrderRepository orderRepository;

  @InjectMocks
  private OrderService underTest;

  @Captor
  private ArgumentCaptor<Order> orderCaptor;

  @Test
  public void createOrder() {
    Order order = underTest.createOrder(CUSTOMER_NAME);
    verify(orderRepository).save(order);
    assertEquals(CUSTOMER_NAME, order.getCustomerName());
  }

  @Test
  public void updateOrder() {
    Order order = new Order(CUSTOMER_NAME);
    Item item1 = new Item("Item 1", 10.0);
    order.addItem(item1);
    when(orderRepository.findById(order.getOrderId())).thenReturn(order);

    underTest.updateOrder(order);

    verify(orderRepository).findById(order.getOrderId());
    verify(orderRepository).save(orderCaptor.capture());
    Order result = orderCaptor.getValue();

    assertEquals(order.getOrderId(), result.getOrderId());
    assertEquals(order.getCustomerName(), result.getCustomerName());
    assertEquals(order.getItems().size(), result.getItems().size());
    assertEquals(item1, result.getItems().get(0));
  }

  @Test
  public void updateOrder_notFound() {
    Order nonExistingOrder = new Order("not existing");

    when(orderRepository.findById(nonExistingOrder.getOrderId()))
        .thenReturn(null);

    assertThrows(IllegalArgumentException.class, () -> {
      underTest.updateOrder(nonExistingOrder);
    });

    verify(orderRepository).findById(nonExistingOrder.getOrderId());
    verify(orderRepository, never()).save(any(Order.class));
  }

  @Test
  public void getOrder() {
    Order order = new Order(CUSTOMER_NAME);
    when(orderRepository.findById(order.getOrderId())).thenReturn(order);

    Order result = underTest.getOrder(order.getOrderId());
    assertEquals(order, result);
  }

  @Test
  public void getOrder_notFound() {
    int nonExistingOrderId = 999;
    when(orderRepository.findById(nonExistingOrderId)).thenReturn(null);
    assertThrows(IllegalArgumentException.class, () -> {
      underTest.getOrder(nonExistingOrderId);
    });
    verify(orderRepository).findById(nonExistingOrderId);
  }
}
