package com.echo.user.adapter.inbound.web

import com.echo.user.application.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    data class UserCreateRequest(val name: String, val email: String)

    @PostMapping
    fun register(@RequestBody request: UserCreateRequest) =
        userService.registerUser(request.name, request.email)

    @GetMapping
    fun list() = userService.getAllUsers()
}