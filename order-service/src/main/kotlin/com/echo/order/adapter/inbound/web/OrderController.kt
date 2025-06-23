package com.echo.order.adapter.inbound.web

import com.echo.order.application.service.OrderService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/orders")
class OrderController(
    private val orderService: OrderService
) {

    data class OrderCreateRequest(
        val userId: Long,
        val productId: Long,
        val amount: Int
    )

    @PostMapping
    fun create(@RequestBody request: OrderCreateRequest) =
        orderService.createOrder(request.userId, request.productId, request.amount)

    @GetMapping
    fun getAll() = orderService.getAllOrders()
}