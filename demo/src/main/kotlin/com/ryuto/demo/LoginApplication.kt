package com.ryuto.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LoginApplication

fun main(args: Array<String>) {
	runApplication<LoginApplication>(*args)
}
