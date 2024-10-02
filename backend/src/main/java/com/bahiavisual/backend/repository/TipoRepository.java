package com.bahiavisual.backend.repository;

import com.bahiavisual.backend.entity.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, UUID> {
}
