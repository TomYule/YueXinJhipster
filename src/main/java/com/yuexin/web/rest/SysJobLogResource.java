package com.yuexin.web.rest;

import com.yuexin.domain.SysJobLog;
import com.yuexin.repository.SysJobLogRepository;
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
 * REST controller for managing {@link com.yuexin.domain.SysJobLog}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SysJobLogResource {

    private final Logger log = LoggerFactory.getLogger(SysJobLogResource.class);

    private static final String ENTITY_NAME = "sysJobLog";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SysJobLogRepository sysJobLogRepository;

    public SysJobLogResource(SysJobLogRepository sysJobLogRepository) {
        this.sysJobLogRepository = sysJobLogRepository;
    }

    /**
     * {@code POST  /sys-job-logs} : Create a new sysJobLog.
     *
     * @param sysJobLog the sysJobLog to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sysJobLog, or with status {@code 400 (Bad Request)} if the sysJobLog has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sys-job-logs")
    public ResponseEntity<SysJobLog> createSysJobLog(@RequestBody SysJobLog sysJobLog) throws URISyntaxException {
        log.debug("REST request to save SysJobLog : {}", sysJobLog);
        if (sysJobLog.getId() != null) {
            throw new BadRequestAlertException("A new sysJobLog cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SysJobLog result = sysJobLogRepository.save(sysJobLog);
        return ResponseEntity.created(new URI("/api/sys-job-logs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /sys-job-logs} : Updates an existing sysJobLog.
     *
     * @param sysJobLog the sysJobLog to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sysJobLog,
     * or with status {@code 400 (Bad Request)} if the sysJobLog is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sysJobLog couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sys-job-logs")
    public ResponseEntity<SysJobLog> updateSysJobLog(@RequestBody SysJobLog sysJobLog) throws URISyntaxException {
        log.debug("REST request to update SysJobLog : {}", sysJobLog);
        if (sysJobLog.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SysJobLog result = sysJobLogRepository.save(sysJobLog);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sysJobLog.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /sys-job-logs} : get all the sysJobLogs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sysJobLogs in body.
     */
    @GetMapping("/sys-job-logs")
    public ResponseEntity<List<SysJobLog>> getAllSysJobLogs(Pageable pageable) {
        log.debug("REST request to get a page of SysJobLogs");
        Page<SysJobLog> page = sysJobLogRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /sys-job-logs/:id} : get the "id" sysJobLog.
     *
     * @param id the id of the sysJobLog to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sysJobLog, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sys-job-logs/{id}")
    public ResponseEntity<SysJobLog> getSysJobLog(@PathVariable Long id) {
        log.debug("REST request to get SysJobLog : {}", id);
        Optional<SysJobLog> sysJobLog = sysJobLogRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(sysJobLog);
    }

    /**
     * {@code DELETE  /sys-job-logs/:id} : delete the "id" sysJobLog.
     *
     * @param id the id of the sysJobLog to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sys-job-logs/{id}")
    public ResponseEntity<Void> deleteSysJobLog(@PathVariable Long id) {
        log.debug("REST request to delete SysJobLog : {}", id);
        sysJobLogRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
