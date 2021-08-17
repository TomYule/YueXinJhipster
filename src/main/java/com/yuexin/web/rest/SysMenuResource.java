package com.yuexin.web.rest;

import com.yuexin.domain.SysMenu;
import com.yuexin.repository.SysMenuRepository;
import com.yuexin.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.yuexin.domain.SysMenu}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SysMenuResource {

    private final Logger log = LoggerFactory.getLogger(SysMenuResource.class);

    private static final String ENTITY_NAME = "sysMenu";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SysMenuRepository sysMenuRepository;

    public SysMenuResource(SysMenuRepository sysMenuRepository) {
        this.sysMenuRepository = sysMenuRepository;
    }

    /**
     * {@code POST  /sys-menus} : Create a new sysMenu.
     *
     * @param sysMenu the sysMenu to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sysMenu, or with status {@code 400 (Bad Request)} if the sysMenu has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sys-menus")
    public ResponseEntity<SysMenu> createSysMenu(@Valid @RequestBody SysMenu sysMenu) throws URISyntaxException {
        log.debug("REST request to save SysMenu : {}", sysMenu);
        if (sysMenu.getId() != null) {
            throw new BadRequestAlertException("A new sysMenu cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SysMenu result = sysMenuRepository.save(sysMenu);
        return ResponseEntity.created(new URI("/api/sys-menus/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /sys-menus} : Updates an existing sysMenu.
     *
     * @param sysMenu the sysMenu to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sysMenu,
     * or with status {@code 400 (Bad Request)} if the sysMenu is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sysMenu couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sys-menus")
    public ResponseEntity<SysMenu> updateSysMenu(@Valid @RequestBody SysMenu sysMenu) throws URISyntaxException {
        log.debug("REST request to update SysMenu : {}", sysMenu);
        if (sysMenu.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SysMenu result = sysMenuRepository.save(sysMenu);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sysMenu.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /sys-menus} : get all the sysMenus.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sysMenus in body.
     */
    @GetMapping("/sys-menus")
    public List<SysMenu> getAllSysMenus() {
        log.debug("REST request to get all SysMenus");
        return sysMenuRepository.findAll();
    }

    /**
     * {@code GET  /sys-menus/:id} : get the "id" sysMenu.
     *
     * @param id the id of the sysMenu to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sysMenu, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sys-menus/{id}")
    public ResponseEntity<SysMenu> getSysMenu(@PathVariable Long id) {
        log.debug("REST request to get SysMenu : {}", id);
        Optional<SysMenu> sysMenu = sysMenuRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(sysMenu);
    }

    /**
     * {@code DELETE  /sys-menus/:id} : delete the "id" sysMenu.
     *
     * @param id the id of the sysMenu to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sys-menus/{id}")
    public ResponseEntity<Void> deleteSysMenu(@PathVariable Long id) {
        log.debug("REST request to delete SysMenu : {}", id);
        sysMenuRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
