package com.echo.user.adapter.inbound.web

import com.echo.user.application.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
class UserController(
    private val userService: UserService
) {

    data class UserCreateRequest(val name: String, val email: String)

    @PostMapping("/users")
    fun register(@RequestBody request: UserCreateRequest) =
        userService.registerUser(request.name, request.email)

    @GetMapping("/users")
    fun list() = userService.getAllUsers()

    @GetMapping("/internal/users/{id}")
    fun internalFindById(@PathVariable id: Long): UserDetailResponse {
        val user = userService.findById(id)
        return UserDetailResponse(user.id!!, user.name, user.email)
    }

    data class UserDetailResponse(
        val id: Long,
        val name: String,
        val email: String
    )
}