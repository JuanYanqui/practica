package com.alexis.prueba.controller;

import com.alexis.prueba.entity.Depto;
import com.alexis.prueba.service.IDeptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/depto")
public class DeptoController {

    @Autowired
    IDeptoService deptoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Depto>> listarDepto() {
        return new ResponseEntity<>(deptoService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Depto> crearDepto(@RequestBody Depto d) {
        return new ResponseEntity<>(deptoService.save(d), HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Depto> actualizarDepto(@PathVariable Long id, @RequestBody Depto d) {
        Depto depEncontrado = deptoService.findById(id);
        if (depEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                depEncontrado.setNombre(d.getNombre());
                depEncontrado.setDescripcion(d.getDescripcion());
                depEncontrado.setDirector(d.getDirector());
                return new ResponseEntity<>(deptoService.save(d), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Depto> eliminarDepto(@PathVariable Long id) {
        deptoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
