package com.shandov.autoria.repository;

import com.shandov.autoria.domain.DriveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriveTypeRepository extends JpaRepository<DriveType, Long> {
}
