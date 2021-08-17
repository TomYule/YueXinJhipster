package com.yuexin.repository;

import com.yuexin.domain.SysJobLog;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SysJobLog entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SysJobLogRepository extends JpaRepository<SysJobLog, Long> {
}
