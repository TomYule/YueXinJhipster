package com.yuexin.repository;

import com.yuexin.domain.GenTableColumn;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the GenTableColumn entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GenTableColumnRepository extends JpaRepository<GenTableColumn, Long> {
}
