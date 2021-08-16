package com.yuexin.repository;

import com.yuexin.domain.SysJob;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SysJob entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SysJobRepository extends JpaRepository<SysJob, Long> {
}
