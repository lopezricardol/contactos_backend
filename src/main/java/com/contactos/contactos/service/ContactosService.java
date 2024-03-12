package com.contactos.contactos.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.contactos.contactos.entity.Contacto;
import com.contactos.contactos.repository.ContactoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContactosService {

    private final ContactoRepository contactoRepository;

    public Iterable<Contacto> findAll(){
        return contactoRepository.findAll();
    }

    public Contacto findById ( Integer id){
        return contactoRepository.findById(id)
        .orElse(null);
    }

    public Contacto create(Contacto contacto){
        contacto.setFechaRegistro(LocalDateTime.now());
        return contactoRepository.save(contacto);
    }

    public Contacto update(Integer id,
                           Contacto contactoForm){        
        Contacto contactoAct = findById(id);  
        contactoForm.setId(contactoAct.getId());;
        return contactoRepository.save(contactoForm);
    }

    public void delete( Integer id){        
        Contacto contactoAct = findById(id);
         contactoRepository.delete(contactoAct);
    }


}
