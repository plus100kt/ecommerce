package com.echo.order.application.service

import com.echo.order.domain.model.Order
import com.echo.order.domain.model.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRepository: OrderRepository
) {

    fun createOrder(userId: Long, productId: Long, amount: Int): Order {
        return orderRepository.save(Order(userId, productId, amount))
    }

    fun getAllOrders(): List<Order> {
        return orderRepository.findAll()
    }
}