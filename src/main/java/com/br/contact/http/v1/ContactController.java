package com.br.contact.http.v1;

import com.br.contact.entity.Contact;
import com.br.contact.http.v1.domain.ContactResponse;
import com.br.contact.service.ContactService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/api/v1/contacts")
@CrossOrigin
public class ContactController {
    @Autowired
    private ContactService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void salvar(@RequestBody Contact contact) {
        service.salvar(contact);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ContactResponse> findAll() {
        return service.findAll();
    }

    @SneakyThrows
    @GetMapping("/por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContactResponse findByid(@RequestParam("id") Long id) {
        return service.findByid(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(Long id) {
        service.deletebyId(id);
    }

    @PutMapping("/update-por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizar(@RequestParam("id") Long id, @RequestBody Contact contact) {
        service.atualizar(id, contact);
    }
}
