package com.yuexin.web.rest;

import com.yuexin.domain.SysOperLog;
import com.yuexin.repository.SysOperLogRepository;
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
 * REST controller for managing {@link com.yuexin.domain.SysOperLog}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SysOperLogResource {

    private final Logger log = LoggerFactory.getLogger(SysOperLogResource.class);

    private static final String ENTITY_NAME = "sysOperLog";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SysOperLogRepository sysOperLogRepository;

    public SysOperLogResource(SysOperLogRepository sysOperLogRepository) {
        this.sysOperLogRepository = sysOperLogRepository;
    }

    /**
     * {@code POST  /sys-oper-logs} : Create a new sysOperLog.
     *
     * @param sysOperLog the sysOperLog to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sysOperLog, or with status {@code 400 (Bad Request)} if the sysOperLog has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sys-oper-logs")
    public ResponseEntity<SysOperLog> createSysOperLog(@Valid @RequestBody SysOperLog sysOperLog) throws URISyntaxException {
        log.debug("REST request to save SysOperLog : {}", sysOperLog);
        if (sysOperLog.getId() != null) {
            throw new BadRequestAlertException("A new sysOperLog cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SysOperLog result = sysOperLogRepository.save(sysOperLog);
        return ResponseEntity.created(new URI("/api/sys-oper-logs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /sys-oper-logs} : Updates an existing sysOperLog.
     *
     * @param sysOperLog the sysOperLog to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sysOperLog,
     * or with status {@code 400 (Bad Request)} if the sysOperLog is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sysOperLog couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sys-oper-logs")
    public ResponseEntity<SysOperLog> updateSysOperLog(@Valid @RequestBody SysOperLog sysOperLog) throws URISyntaxException {
        log.debug("REST request to update SysOperLog : {}", sysOperLog);
        if (sysOperLog.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SysOperLog result = sysOperLogRepository.save(sysOperLog);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sysOperLog.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /sys-oper-logs} : get all the sysOperLogs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sysOperLogs in body.
     */
    @GetMapping("/sys-oper-logs")
    public ResponseEntity<List<SysOperLog>> getAllSysOperLogs(Pageable pageable) {
        log.debug("REST request to get a page of SysOperLogs");
        Page<SysOperLog> page = sysOperLogRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /sys-oper-logs/:id} : get the "id" sysOperLog.
     *
     * @param id the id of the sysOperLog to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sysOperLog, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sys-oper-logs/{id}")
    public ResponseEntity<SysOperLog> getSysOperLog(@PathVariable Long id) {
        log.debug("REST request to get SysOperLog : {}", id);
        Optional<SysOperLog> sysOperLog = sysOperLogRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(sysOperLog);
    }

    /**
     * {@code DELETE  /sys-oper-logs/:id} : delete the "id" sysOperLog.
     *
     * @param id the id of the sysOperLog to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sys-oper-logs/{id}")
    public ResponseEntity<Void> deleteSysOperLog(@PathVariable Long id) {
        log.debug("REST request to delete SysOperLog : {}", id);
        sysOperLogRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
