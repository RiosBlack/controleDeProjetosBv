package com.bahiavisual.backend.controller;


import com.bahiavisual.backend.entity.Itens;
import com.bahiavisual.backend.service.ItensService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Itens")
public class ItensController {
    @Autowired
    ItensService itensService;

    @GetMapping()
    public List<Itens> buscarTodos(){
        return itensService.buscarTodos();
    }

    @PostMapping()
    public ResponseEntity criar(@RequestBody @Valid Itens itens){
        return itensService.criar(itens);
    }

    @DeleteMapping()
    public ResponseEntity deletar(@RequestBody Itens itens){
        return itensService.deletar(itens);
    }
}
