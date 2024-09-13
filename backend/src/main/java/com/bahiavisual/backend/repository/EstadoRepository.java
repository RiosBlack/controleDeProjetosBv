package com.bahiavisual.backend.repository;

import com.bahiavisual.backend.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, UUID> {
}
