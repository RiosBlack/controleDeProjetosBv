package com.bahiavisual.backend.controller;



import com.bahiavisual.backend.entity.LocalCidade;
import com.bahiavisual.backend.service.LocalCidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/LocalCidade")
public class LocalCidadeController {
    @Autowired
    LocalCidadeService localCidadeService;

    @GetMapping()
    public List<LocalCidade> buscarTodos(){
        return localCidadeService.buscarTodos();
    }

    @PostMapping()
    public ResponseEntity criarEstado(@RequestBody @Valid LocalCidade localCidade){
        return localCidadeService.criarEstado(localCidade);
    }

    @DeleteMapping()
    public ResponseEntity deletarEstado(@RequestBody LocalCidade localCidade){
        return localCidadeService.deletarEstado(localCidade);
    }
}
