package com.linkedin.app;

public interface OrderRepository {
  Order findById(int orderId);
  void save(Order order);
}
