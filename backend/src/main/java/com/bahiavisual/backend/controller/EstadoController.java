package com.bahiavisual.backend.controller;

import com.bahiavisual.backend.entity.Estado;
import com.bahiavisual.backend.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/Estado")
public class EstadoController {

    @Autowired
    EstadoService estadoService;

    @GetMapping()
    public List<Estado> buscarTodos(){
        return estadoService.buscarTodos();
    }

    @PostMapping()
    public ResponseEntity criarEstado(@RequestBody @Valid Estado estado){
        return estadoService.criarEstado(estado);
    }

    @DeleteMapping()
    public ResponseEntity deletarEstado(@RequestBody Estado estado){
        return estadoService.deletarEstado(estado);
    }
}
