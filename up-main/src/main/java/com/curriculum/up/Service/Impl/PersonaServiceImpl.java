package com.curriculum.up.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curriculum.up.Modelo.Entity.Persona;
import com.curriculum.up.Repository.PersonaRepository;
import com.curriculum.up.Service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> listPersonas() {
        return this.personaRepository.findAll();
    }

    @Override
    public Persona findByIdPersona(Integer id) {
        Persona persona = this.personaRepository.findById(id).orElse(null);
        return persona;
    }

    @Override
    public Persona savePersona(Persona persona) {
        return this.personaRepository.save(persona);
    }

    @Override
    public void deleteByIdPersona(Integer id) {
        this.personaRepository.deleteById(id);
    }

}
