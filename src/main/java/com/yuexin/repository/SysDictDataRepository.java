package com.yuexin.repository;

import com.yuexin.domain.SysDictData;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SysDictData entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SysDictDataRepository extends JpaRepository<SysDictData, Long> {
}
