package com.yuexin.repository;

import com.yuexin.domain.SysMenu;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SysMenu entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SysMenuRepository extends JpaRepository<SysMenu, Long> {
}
