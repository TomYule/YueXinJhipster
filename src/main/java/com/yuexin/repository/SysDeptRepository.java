package com.yuexin.repository;

import com.yuexin.domain.SysDept;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SysDept entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SysDeptRepository extends JpaRepository<SysDept, Long> {
}
