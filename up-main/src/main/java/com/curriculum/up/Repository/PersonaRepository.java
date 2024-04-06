package com.curriculum.up.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curriculum.up.Modelo.Entity.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer>{
    
}
