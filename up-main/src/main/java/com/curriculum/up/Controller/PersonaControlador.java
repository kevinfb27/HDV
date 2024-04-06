package com.curriculum.up.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.curriculum.up.Modelo.Entity.Persona;
import com.curriculum.up.Service.PersonaService;
import com.curriculum.up.excepcion.RecursoNoEncontradoExcepcion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("hdv")
public class PersonaControlador {

    private static final Logger logger =
            LoggerFactory.getLogger(PersonaControlador.class);

    @Autowired
    private PersonaService personaService;

    //http://locahost:8080/hdv/personas
    @GetMapping("/personas")
    public List<Persona> obtenerPersonas(){
        List<Persona> personas = this.personaService.listPersonas();
        logger.info("Personas obtenidos:");
        personas.forEach((Persona -> logger.info(Persona.toString())));
        return personas;
    }

    @PostMapping("/personas")
    public Persona agregarPersona(@RequestBody Persona Persona){
        logger.info("Persona a agregar: " + Persona);
        return this.personaService.savePersona(Persona);
    }

    @GetMapping("/personas/{id}")
    public ResponseEntity<Persona> obtenerPersonaPorId(
            @PathVariable int id){
        Persona Persona =
                this.personaService.findByIdPersona(id);
        if(Persona != null)
            return ResponseEntity.ok(Persona);
        else
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: " + id);
    }

    @PutMapping("/personas/{id}")
    public ResponseEntity<Persona> actualizarPersona(
            @PathVariable int id,
            @RequestBody Persona personaRecibido){
        Persona Persona = this.personaService.findByIdPersona(id);
        if (Persona == null)
            throw new RecursoNoEncontradoExcepcion("No se encontro" + id);
        Persona.setNombre(personaRecibido.getNombre());
        Persona.setCorreo(personaRecibido.getCorreo());
        this.personaService.savePersona(Persona);
        return ResponseEntity.ok(Persona);
    }

    @DeleteMapping("/personas/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarPersona(@PathVariable int id){
        Persona persona = this.personaService.findByIdPersona(id);
        if (persona == null)
            throw new RecursoNoEncontradoExcepcion("No se encontro" + id);
        this.personaService.deleteByIdPersona(persona.getId());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado", true);
        return ResponseEntity.ok(respuesta);
    }


}
