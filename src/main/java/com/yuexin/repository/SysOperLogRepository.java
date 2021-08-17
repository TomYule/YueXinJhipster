package com.yuexin.repository;

import com.yuexin.domain.SysOperLog;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SysOperLog entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SysOperLogRepository extends JpaRepository<SysOperLog, Long> {
}
