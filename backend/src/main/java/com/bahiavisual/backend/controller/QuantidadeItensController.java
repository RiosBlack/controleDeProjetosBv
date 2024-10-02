package com.bahiavisual.backend.controller;


import com.bahiavisual.backend.entity.QuantidadeItens;
import com.bahiavisual.backend.service.QuantidadeItensService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/QuantidadeItens")
public class QuantidadeItensController {

    @Autowired
    QuantidadeItensService quantidadeItensService;

    @GetMapping()
    public List<QuantidadeItens> buscarTodos(){
        return quantidadeItensService.buscarTodos();
    }

    @PostMapping()
    public ResponseEntity criar(@RequestBody @Valid QuantidadeItens quantidadeItens){
        return quantidadeItensService.criar(quantidadeItens);
    }

    @DeleteMapping()
    public ResponseEntity deletar(@RequestBody QuantidadeItens quantidadeItens){
        return quantidadeItensService.deletar(quantidadeItens);
    }
}
