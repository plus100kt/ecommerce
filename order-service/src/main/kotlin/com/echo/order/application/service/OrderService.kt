package com.echo.order.application.service

import com.echo.order.adapter.outbound.user.UserClient
import com.echo.order.domain.model.Order
import com.echo.order.domain.model.OrderRepository
import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val userClient: UserClient
) {

    fun createOrder(userId: Long, productId: Long, amount: Int): Order {
        // 🔁 유저 존재 확인
        val user = userClient.getUserById(userId)

        println("주문자: ${user.name}")

        return orderRepository.save(Order(userId, productId, amount))
    }

    fun getAllOrders(): List<Order> {
        return orderRepository.findAll()
    }
}