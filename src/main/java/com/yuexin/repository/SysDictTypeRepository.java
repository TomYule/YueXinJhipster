package com.yuexin.repository;

import com.yuexin.domain.SysDictType;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SysDictType entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SysDictTypeRepository extends JpaRepository<SysDictType, Long> {
}
