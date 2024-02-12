package com.scarlxrd.demoPerson.model.service

import com.scarlxrd.demoPerson.model.entity.Person
import com.scarlxrd.demoPerson.model.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonService(private val repository: PersonRepository) {

    fun getALl():List<Person> = repository.findAll();

    fun getById(id: Long): Optional<Person> = repository.findById(id);

    fun create(person: Person):Person = repository.save(person);

    fun update(id:Long ,oldPerson: Person): ResponseEntity<Person> =
    repository.findById(id).map {
        val personToUpdate = it.copy(
            name = oldPerson.name,
            document = oldPerson.document,
            phone = oldPerson.phone,
            sex = oldPerson.sex
        )
        ResponseEntity.ok(repository.save(personToUpdate))
    }.orElse(ResponseEntity.notFound().build());

    fun delete(id: Long): Unit = repository.deleteById(id);


}