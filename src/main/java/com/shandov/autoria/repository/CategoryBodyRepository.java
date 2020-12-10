package com.shandov.autoria.repository;

import com.shandov.autoria.domain.CategoryBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryBodyRepository extends JpaRepository<CategoryBody, Long> {
}
