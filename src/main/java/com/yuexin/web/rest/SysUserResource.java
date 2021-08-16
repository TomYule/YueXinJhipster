package com.yuexin.web.rest;

import com.yuexin.domain.SysUser;
import com.yuexin.repository.SysUserRepository;
import com.yuexin.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.yuexin.domain.SysUser}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SysUserResource {

    private final Logger log = LoggerFactory.getLogger(SysUserResource.class);

    private static final String ENTITY_NAME = "sysUser";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SysUserRepository sysUserRepository;

    public SysUserResource(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

    /**
     * {@code POST  /sys-users} : Create a new sysUser.
     *
     * @param sysUser the sysUser to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sysUser, or with status {@code 400 (Bad Request)} if the sysUser has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sys-users")
    public ResponseEntity<SysUser> createSysUser(@Valid @RequestBody SysUser sysUser) throws URISyntaxException {
        log.debug("REST request to save SysUser : {}", sysUser);
        if (sysUser.getId() != null) {
            throw new BadRequestAlertException("A new sysUser cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SysUser result = sysUserRepository.save(sysUser);
        return ResponseEntity.created(new URI("/api/sys-users/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /sys-users} : Updates an existing sysUser.
     *
     * @param sysUser the sysUser to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sysUser,
     * or with status {@code 400 (Bad Request)} if the sysUser is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sysUser couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sys-users")
    public ResponseEntity<SysUser> updateSysUser(@Valid @RequestBody SysUser sysUser) throws URISyntaxException {
        log.debug("REST request to update SysUser : {}", sysUser);
        if (sysUser.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SysUser result = sysUserRepository.save(sysUser);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sysUser.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /sys-users} : get all the sysUsers.
     *
     * @param pageable the pagination information.
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many).
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sysUsers in body.
     */
    @GetMapping("/sys-users")
    public ResponseEntity<List<SysUser>> getAllSysUsers(Pageable pageable, @RequestParam(required = false, defaultValue = "false") boolean eagerload) {
        log.debug("REST request to get a page of SysUsers");
        Page<SysUser> page;
        if (eagerload) {
            page = sysUserRepository.findAllWithEagerRelationships(pageable);
        } else {
            page = sysUserRepository.findAll(pageable);
        }
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /sys-users/:id} : get the "id" sysUser.
     *
     * @param id the id of the sysUser to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sysUser, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sys-users/{id}")
    public ResponseEntity<SysUser> getSysUser(@PathVariable Long id) {
        log.debug("REST request to get SysUser : {}", id);
        Optional<SysUser> sysUser = sysUserRepository.findOneWithEagerRelationships(id);
        return ResponseUtil.wrapOrNotFound(sysUser);
    }

    /**
     * {@code DELETE  /sys-users/:id} : delete the "id" sysUser.
     *
     * @param id the id of the sysUser to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sys-users/{id}")
    public ResponseEntity<Void> deleteSysUser(@PathVariable Long id) {
        log.debug("REST request to delete SysUser : {}", id);
        sysUserRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
