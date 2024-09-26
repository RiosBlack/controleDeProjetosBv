package com.bahiavisual.backend.service;

import com.bahiavisual.backend.entity.Estado;
import com.bahiavisual.backend.entity.LocalCidade;
import com.bahiavisual.backend.repository.EstadoRepository;
import com.bahiavisual.backend.repository.LocalCidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalCidadeService {
    @Autowired
    LocalCidadeRepository localCidadeRepository;

    public List<LocalCidade> buscarTodos() {
        List<LocalCidade> localCidadeList = localCidadeRepository.findAll();
        return localCidadeList;
    }


    public ResponseEntity criarEstado(LocalCidade localCidade) {
        if (localCidade.getNome().isEmpty()){
            return new ResponseEntity("O NOME DO LOCAL TEM DE ESTAR PREENCHIDO", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(localCidadeRepository.save(localCidade));
    }


    public ResponseEntity deletarEstado(LocalCidade localCidade) {
        Optional<LocalCidade> byId = localCidadeRepository.findById(localCidade.getId());
        if (byId.isEmpty()){
            return new ResponseEntity("LOCAL NÃO CADASTRADO.", HttpStatus.BAD_REQUEST);
        }
        localCidadeRepository.delete(localCidade);
        return ResponseEntity.ok("LOCAL EXCLUIDO COM SUCESSO");
    }
}
