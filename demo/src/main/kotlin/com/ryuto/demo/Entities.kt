package com.ryuto.demo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class User(
    @Id @GeneratedValue var id: Long,
    var username: String,
    var password: String)