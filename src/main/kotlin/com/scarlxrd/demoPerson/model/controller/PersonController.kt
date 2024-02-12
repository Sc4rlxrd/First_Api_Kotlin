package com.scarlxrd.demoPerson.model.controller

import com.scarlxrd.demoPerson.model.entity.Person
import com.scarlxrd.demoPerson.model.service.PersonService
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/person")
class PersonController (private val repository:PersonService){

    @GetMapping
    fun getAll():List<Person> = repository.getALl();
    @GetMapping("/{id}")
    fun getByID(@PathVariable id:Long):Optional<Person> = repository.getById(id);
    @PostMapping
    fun create(@RequestBody @Validated person: Person): Person = repository.create(person)
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody person: Person): ResponseEntity<Person> = repository.update(id,person);
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): Unit = repository.delete(id);

}