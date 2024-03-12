package com.contactos.contactos.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.contactos.contactos.entity.Contacto;
import com.contactos.contactos.repository.ContactoRepository;
import com.contactos.contactos.service.ContactosService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequestMapping("/api/contactos")
@RestController
@AllArgsConstructor
public class ContactoController {

    
    private final ContactosService contactoService;

 
    @GetMapping()
    Iterable<Contacto> list(){
        return contactoService.findAll();
    }

    @GetMapping("{id}")
    public Contacto get(@PathVariable Integer id){
        return contactoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Contacto create(@RequestBody Contacto contacto){       
        return contactoService.create(contacto);
    }

    @PutMapping("{id}")
    public Contacto update(@PathVariable Integer id,
                           @RequestBody Contacto contactoForm){
        
       return contactoService.update(id,contactoForm);
    }

    
    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){        
        contactoService.delete(id);
    }
    
}
