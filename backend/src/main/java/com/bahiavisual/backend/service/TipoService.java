package com.bahiavisual.backend.service;

import com.bahiavisual.backend.entity.Tipo;
import com.bahiavisual.backend.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoService {
    @Autowired
    TipoRepository tipoRepository;

    public List<Tipo> buscarTodos() {
        List<Tipo> localCidadeList = tipoRepository.findAll();
        return localCidadeList;
    }


    public ResponseEntity criarTipo(Tipo tipo) {
        if (tipo.getNome().isEmpty()){
            return new ResponseEntity("O NOME DO TIPO TEM DE ESTAR PREENCHIDO", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(tipoRepository.save(tipo));
    }


    public ResponseEntity deletarTipo(Tipo tipo) {
        Optional<Tipo> byId = tipoRepository.findById(tipo.getId());
        if (byId.isEmpty()){
            return new ResponseEntity("TIPO NÃO CADASTRADO.", HttpStatus.BAD_REQUEST);
        }
        tipoRepository.delete(tipo);
        return ResponseEntity.ok("TIPO EXCLUIDO COM SUCESSO");
    }
}
