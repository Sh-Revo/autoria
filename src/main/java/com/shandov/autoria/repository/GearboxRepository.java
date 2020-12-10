package com.shandov.autoria.repository;

import com.shandov.autoria.domain.Gearbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GearboxRepository extends JpaRepository<Gearbox, Long> {
}
