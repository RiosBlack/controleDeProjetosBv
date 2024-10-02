package com.bahiavisual.backend.repository;

import com.bahiavisual.backend.entity.Itens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItensRepository extends JpaRepository<Itens, UUID> {
}
