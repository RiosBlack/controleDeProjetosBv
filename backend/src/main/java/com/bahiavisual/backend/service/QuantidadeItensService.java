package com.bahiavisual.backend.service;



import com.bahiavisual.backend.entity.QuantidadeItens;
import com.bahiavisual.backend.repository.QuantidadeItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuantidadeItensService {
    @Autowired
    QuantidadeItensRepository quantidadeItensRepository;

    public List<QuantidadeItens> buscarTodos() {
        List<QuantidadeItens> list = quantidadeItensRepository.findAll();
        return list;
    }


    public ResponseEntity criar(QuantidadeItens quantidadeItens) {
        if (quantidadeItens.getQuantidade() >= 1){
            return new ResponseEntity("A QUANTIDADE TEM DE SER MAIOR QUE 0", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(quantidadeItensRepository.save(quantidadeItens));
    }


    public ResponseEntity deletar(QuantidadeItens quantidadeItens) {
        Optional<QuantidadeItens> byId = quantidadeItensRepository.findById(quantidadeItens.getId());
        if (byId.isEmpty()){
            return new ResponseEntity("QUANTIDADE NÃO CADASTRADA.", HttpStatus.BAD_REQUEST);
        }
        quantidadeItensRepository.delete(quantidadeItens);
        return ResponseEntity.ok("QUANTIDADE EXCLUIDA COM SUCESSO");
    }
}
