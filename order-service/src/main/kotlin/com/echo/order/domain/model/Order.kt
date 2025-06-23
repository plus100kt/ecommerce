package com.echo.order.domain.model

import jakarta.persistence.*

@Entity
@Table(name = "orders")
class Order(
    @Column(nullable = false)
    var userId: Long,

    @Column(nullable = false)
    var productId: Long,

    @Column(nullable = false)
    var amount: Int,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}