package com.bahiavisual.backend.repository;

import com.bahiavisual.backend.entity.LocalCidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocalCidadeRepository extends JpaRepository<LocalCidade, UUID> {
}
