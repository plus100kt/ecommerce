package com.echo.order.adapter.outbound.user

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "user-service") // Eureka에 등록된 서비스 이름
interface UserClient {

    @GetMapping("/internal/users/{userId}")
    fun getUserById(@PathVariable userId: Long): UserResponse
}

data class UserResponse(
    val id: Long,
    val name: String,
    val email: String
)