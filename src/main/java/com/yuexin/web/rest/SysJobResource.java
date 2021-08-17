package com.yuexin.web.rest;

import com.yuexin.domain.SysJob;
import com.yuexin.repository.SysJobRepository;
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
 * REST controller for managing {@link com.yuexin.domain.SysJob}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SysJobResource {

    private final Logger log = LoggerFactory.getLogger(SysJobResource.class);

    private static final String ENTITY_NAME = "sysJob";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SysJobRepository sysJobRepository;

    public SysJobResource(SysJobRepository sysJobRepository) {
        this.sysJobRepository = sysJobRepository;
    }

    /**
     * {@code POST  /sys-jobs} : Create a new sysJob.
     *
     * @param sysJob the sysJob to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sysJob, or with status {@code 400 (Bad Request)} if the sysJob has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sys-jobs")
    public ResponseEntity<SysJob> createSysJob(@RequestBody SysJob sysJob) throws URISyntaxException {
        log.debug("REST request to save SysJob : {}", sysJob);
        if (sysJob.getId() != null) {
            throw new BadRequestAlertException("A new sysJob cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SysJob result = sysJobRepository.save(sysJob);
        return ResponseEntity.created(new URI("/api/sys-jobs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /sys-jobs} : Updates an existing sysJob.
     *
     * @param sysJob the sysJob to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sysJob,
     * or with status {@code 400 (Bad Request)} if the sysJob is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sysJob couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sys-jobs")
    public ResponseEntity<SysJob> updateSysJob(@RequestBody SysJob sysJob) throws URISyntaxException {
        log.debug("REST request to update SysJob : {}", sysJob);
        if (sysJob.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SysJob result = sysJobRepository.save(sysJob);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sysJob.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /sys-jobs} : get all the sysJobs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sysJobs in body.
     */
    @GetMapping("/sys-jobs")
    public ResponseEntity<List<SysJob>> getAllSysJobs(Pageable pageable) {
        log.debug("REST request to get a page of SysJobs");
        Page<SysJob> page = sysJobRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /sys-jobs/:id} : get the "id" sysJob.
     *
     * @param id the id of the sysJob to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sysJob, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sys-jobs/{id}")
    public ResponseEntity<SysJob> getSysJob(@PathVariable Long id) {
        log.debug("REST request to get SysJob : {}", id);
        Optional<SysJob> sysJob = sysJobRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(sysJob);
    }

    /**
     * {@code DELETE  /sys-jobs/:id} : delete the "id" sysJob.
     *
     * @param id the id of the sysJob to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sys-jobs/{id}")
    public ResponseEntity<Void> deleteSysJob(@PathVariable Long id) {
        log.debug("REST request to delete SysJob : {}", id);
        sysJobRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
