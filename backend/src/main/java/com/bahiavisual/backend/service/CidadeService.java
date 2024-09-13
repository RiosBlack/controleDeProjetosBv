package com.bahiavisual.backend.service;

import com.bahiavisual.backend.entity.Cidade;
import com.bahiavisual.backend.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {
    @Autowired
    CidadeRepository cidadeRepository;

    public List<Cidade> buscarTodos() {
        List<Cidade> cidadeList = cidadeRepository.findAll();
        return cidadeList;
    }

    public ResponseEntity criar(Cidade cidade) {
        if (cidade.getNome().isEmpty() & cidade.getEstado().getNome().isEmpty()){
            return new ResponseEntity("CIDADE E ESTADO TEM DE SER PREENCHIDOS", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(cidadeRepository.save(cidade));
    }

    public ResponseEntity deletar(Cidade cidade) {
        Optional<Cidade> byId = cidadeRepository.findById(cidade.getId());
        if (byId.isEmpty()){
            return new ResponseEntity("CIDADE NÃO CADASTRADA", HttpStatus.BAD_REQUEST);
        }
        cidadeRepository.delete(cidade);
        return ResponseEntity.ok("CIDADE EXCLUIDA COM SUCESSO");
    }
}
