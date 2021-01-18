package com.ryuto.demo

import org.springframework.data.repository.CrudRepository

interface UserRepo: CrudRepository<User,Long>{}
