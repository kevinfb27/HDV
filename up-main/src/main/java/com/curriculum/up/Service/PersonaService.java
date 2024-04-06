package com.curriculum.up.Service;

import java.util.List;

import com.curriculum.up.Modelo.Entity.Persona;

public interface PersonaService {

    public List<Persona> listPersonas();

    public Persona findByIdPersona(Integer id);

	public Persona savePersona(Persona persona);

	public void deleteByIdPersona(Integer id);
    
}
