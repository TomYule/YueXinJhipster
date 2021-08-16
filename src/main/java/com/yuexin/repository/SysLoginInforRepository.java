package com.yuexin.repository;

import com.yuexin.domain.SysLoginInfor;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SysLoginInfor entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SysLoginInforRepository extends JpaRepository<SysLoginInfor, Long> {
}
