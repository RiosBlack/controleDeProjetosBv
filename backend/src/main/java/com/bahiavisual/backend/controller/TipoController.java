package com.bahiavisual.backend.controller;

import com.bahiavisual.backend.entity.Tipo;
import com.bahiavisual.backend.service.TipoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Tipo")
public class TipoController {
    @Autowired
    TipoService tipoService;

    @GetMapping()
    public List<Tipo> buscarTodos(){
        return tipoService.buscarTodos();
    }

    @PostMapping()
    public ResponseEntity criarTipo(@RequestBody @Valid Tipo tipo){
        return tipoService.criarTipo(tipo);
    }

    @DeleteMapping()
    public ResponseEntity deletarTipo(@RequestBody Tipo tipo){
        return tipoService.deletarTipo(tipo);
    }
}
