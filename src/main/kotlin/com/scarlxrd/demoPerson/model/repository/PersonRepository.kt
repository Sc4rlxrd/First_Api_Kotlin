package com.scarlxrd.demoPerson.model.repository

import com.scarlxrd.demoPerson.model.entity.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository:JpaRepository<Person,Long> {
}