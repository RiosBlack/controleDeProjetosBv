package com.bahiavisual.backend.controller;

import com.bahiavisual.backend.entity.Cidade;
import com.bahiavisual.backend.service.CidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Cidade")
public class CidadeController {
    @Autowired
    CidadeService cidadeService;

    @GetMapping()
    public List<Cidade> buscarTodos(){
        return cidadeService.buscarTodos();
    }

    @PostMapping()
    public ResponseEntity criar(@RequestBody @Valid Cidade cidade){
        return cidadeService.criar(cidade);
    }

    @DeleteMapping()
    public ResponseEntity deletar(@RequestBody Cidade cidade){
        return cidadeService.deletar(cidade);
    }
}
