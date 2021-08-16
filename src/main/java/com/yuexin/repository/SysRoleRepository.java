package com.yuexin.repository;

import com.yuexin.domain.SysRole;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the SysRole entity.
 */
@Repository
public interface SysRoleRepository extends JpaRepository<SysRole, Long> {

    @Query(value = "select distinct sysRole from SysRole sysRole left join fetch sysRole.sysMenus left join fetch sysRole.sysUsers",
        countQuery = "select count(distinct sysRole) from SysRole sysRole")
    Page<SysRole> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct sysRole from SysRole sysRole left join fetch sysRole.sysMenus left join fetch sysRole.sysUsers")
    List<SysRole> findAllWithEagerRelationships();

    @Query("select sysRole from SysRole sysRole left join fetch sysRole.sysMenus left join fetch sysRole.sysUsers where sysRole.id =:id")
    Optional<SysRole> findOneWithEagerRelationships(@Param("id") Long id);
}
