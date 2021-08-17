package com.yuexin.repository;

import com.yuexin.domain.SysUser;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the SysUser entity.
 */
@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    @Query(value = "select distinct sysUser from SysUser sysUser left join fetch sysUser.sysPosts",
        countQuery = "select count(distinct sysUser) from SysUser sysUser")
    Page<SysUser> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct sysUser from SysUser sysUser left join fetch sysUser.sysPosts")
    List<SysUser> findAllWithEagerRelationships();

    @Query("select sysUser from SysUser sysUser left join fetch sysUser.sysPosts where sysUser.id =:id")
    Optional<SysUser> findOneWithEagerRelationships(@Param("id") Long id);
}
