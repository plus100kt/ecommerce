package com.echo.user.application.service

import com.echo.user.domain.model.User
import com.echo.user.domain.model.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun registerUser(name: String, email: String): User {
        val existing = userRepository.findByEmail(email)
        require(existing == null) { "이미 등록된 이메일입니다." }

        return userRepository.save(User(name, email))
    }

    fun findById(id: Long): User {
        return userRepository.findById(id).orElseThrow()
    }

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }
}