package com.bahiavisual.backend.service;


import com.bahiavisual.backend.entity.Itens;
import com.bahiavisual.backend.repository.ItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItensService {
    @Autowired
    ItensRepository itensRepository;

    public List<Itens> buscarTodos() {
        List<Itens> list = itensRepository.findAll();
        return list;
    }


    public ResponseEntity criar(Itens itens) {
        if (itens.getNome().isEmpty()){
            return new ResponseEntity("O NOME DO ITEM TEM DE ESTAR PREENCHIDO", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(itensRepository.save(itens));
    }


    public ResponseEntity deletar(Itens itens) {
        Optional<Itens> byId = itensRepository.findById(itens.getId());
        if (byId.isEmpty()){
            return new ResponseEntity("ITENS NÃO CADASTRADO.", HttpStatus.BAD_REQUEST);
        }
        itensRepository.delete(itens);
        return ResponseEntity.ok("ITENS EXCLUIDO COM SUCESSO");
    }
}
