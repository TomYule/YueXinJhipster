package com.yuexin.repository;

import com.yuexin.domain.GenTable;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the GenTable entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GenTableRepository extends JpaRepository<GenTable, Long> {
}
