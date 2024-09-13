package com.bahiavisual.backend.service;

import com.bahiavisual.backend.entity.Estado;
import com.bahiavisual.backend.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {
    @Autowired
    EstadoRepository estadoRepository;

    public List<Estado> buscarTodos() {
        List<Estado> estadoList = estadoRepository.findAll();
        return estadoList;
    }


    public ResponseEntity criarEstado(Estado estado) {
        if (estado.getNome().isEmpty()){
            return new ResponseEntity("O NOME TEM DE ESTAR PREENCHIDO", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(estadoRepository.save(estado));
    }


    public ResponseEntity deletarEstado(Estado estado) {
        Optional<Estado> byId = estadoRepository.findById(estado.getId());
        if (byId.isEmpty()){
            return new ResponseEntity("ESTADO NÃO CADASTRADO.", HttpStatus.BAD_REQUEST);
        }
        estadoRepository.delete(estado);
        return ResponseEntity.ok("ESTADO EXCLUIDO COM SUCESSO");
    }
}
