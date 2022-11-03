package com.br.contact.service;

import com.br.contact.entity.Contact;
import com.br.contact.http.v1.domain.ContactResponse;
import com.br.contact.repository.ContactRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    private ContactRepository repository;

    public void salvar(Contact contact) {
        repository.save(contact);
    }

    public List<ContactResponse> findAll() {
        List<Contact> entity = repository.findAll();
        List<ContactResponse> response = new ArrayList<>();

        for (Contact e : entity) {
            ContactResponse contact = new ContactResponse();
            contact.setName(e.getName());
            contact.setEmail(e.getEmail());
            contact.setPhone(e.getPhone());
        }
        return response;
    }

    public void deletebyId(Long id) {
        repository.deleteById(id);
    }

    public ContactResponse findByid(Long id) throws ContactNaoEncontradoException {
        Optional<Contact> entity = repository.findById(id);
        if (entity.isPresent()) {
            Contact e = entity.get();
            ContactResponse contact = new ContactResponse();
            contact.setName(e.getName());
            contact.setEmail(e.getEmail());
            contact.setPhone(e.getPhone());
            return contact;
        } else {
            throw new ContactNaoEncontradoException();
        }
    }

    @SneakyThrows
    public void atualizar(Long id, Contact contact) {
        Optional<Contact> res = repository.findById(id);
        if (res.isPresent()) {
            Contact contact1 = res.get();
            contact1.setName(contact1.getName());
            contact1.setEmail(contact.getEmail());
            contact1.setPhone(contact.getPhone());
            repository.save(contact1);
        } else {
            throw new ContactNaoEncontradoException();
        }
    }
}
