package com.scarlxrd.demoPerson.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "persons")
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    var id:Long?=null,
    val name:String,
    val document:String,
    val phone:String,
    val sex:String
)