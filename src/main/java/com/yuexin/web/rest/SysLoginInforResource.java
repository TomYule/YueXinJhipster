package com.yuexin.web.rest;

import com.yuexin.domain.SysLoginInfor;
import com.yuexin.repository.SysLoginInforRepository;
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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.yuexin.domain.SysLoginInfor}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SysLoginInforResource {

    private final Logger log = LoggerFactory.getLogger(SysLoginInforResource.class);

    private static final String ENTITY_NAME = "sysLoginInfor";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SysLoginInforRepository sysLoginInforRepository;

    public SysLoginInforResource(SysLoginInforRepository sysLoginInforRepository) {
        this.sysLoginInforRepository = sysLoginInforRepository;
    }

    /**
     * {@code POST  /sys-login-infors} : Create a new sysLoginInfor.
     *
     * @param sysLoginInfor the sysLoginInfor to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sysLoginInfor, or with status {@code 400 (Bad Request)} if the sysLoginInfor has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sys-login-infors")
    public ResponseEntity<SysLoginInfor> createSysLoginInfor(@RequestBody SysLoginInfor sysLoginInfor) throws URISyntaxException {
        log.debug("REST request to save SysLoginInfor : {}", sysLoginInfor);
        if (sysLoginInfor.getId() != null) {
            throw new BadRequestAlertException("A new sysLoginInfor cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SysLoginInfor result = sysLoginInforRepository.save(sysLoginInfor);
        return ResponseEntity.created(new URI("/api/sys-login-infors/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /sys-login-infors} : Updates an existing sysLoginInfor.
     *
     * @param sysLoginInfor the sysLoginInfor to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sysLoginInfor,
     * or with status {@code 400 (Bad Request)} if the sysLoginInfor is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sysLoginInfor couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sys-login-infors")
    public ResponseEntity<SysLoginInfor> updateSysLoginInfor(@RequestBody SysLoginInfor sysLoginInfor) throws URISyntaxException {
        log.debug("REST request to update SysLoginInfor : {}", sysLoginInfor);
        if (sysLoginInfor.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SysLoginInfor result = sysLoginInforRepository.save(sysLoginInfor);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sysLoginInfor.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /sys-login-infors} : get all the sysLoginInfors.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sysLoginInfors in body.
     */
    @GetMapping("/sys-login-infors")
    public ResponseEntity<List<SysLoginInfor>> getAllSysLoginInfors(Pageable pageable) {
        log.debug("REST request to get a page of SysLoginInfors");
        Page<SysLoginInfor> page = sysLoginInforRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /sys-login-infors/:id} : get the "id" sysLoginInfor.
     *
     * @param id the id of the sysLoginInfor to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sysLoginInfor, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sys-login-infors/{id}")
    public ResponseEntity<SysLoginInfor> getSysLoginInfor(@PathVariable Long id) {
        log.debug("REST request to get SysLoginInfor : {}", id);
        Optional<SysLoginInfor> sysLoginInfor = sysLoginInforRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(sysLoginInfor);
    }

    /**
     * {@code DELETE  /sys-login-infors/:id} : delete the "id" sysLoginInfor.
     *
     * @param id the id of the sysLoginInfor to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sys-login-infors/{id}")
    public ResponseEntity<Void> deleteSysLoginInfor(@PathVariable Long id) {
        log.debug("REST request to delete SysLoginInfor : {}", id);
        sysLoginInforRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
