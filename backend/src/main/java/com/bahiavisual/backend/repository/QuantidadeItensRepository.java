package com.bahiavisual.backend.repository;

import com.bahiavisual.backend.entity.QuantidadeItens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuantidadeItensRepository extends JpaRepository<QuantidadeItens, UUID> {
}
