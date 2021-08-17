package com.yuexin.web.rest;

import com.yuexin.domain.SysDept;
import com.yuexin.repository.SysDeptRepository;
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
 * REST controller for managing {@link com.yuexin.domain.SysDept}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SysDeptResource {

    private final Logger log = LoggerFactory.getLogger(SysDeptResource.class);

    private static final String ENTITY_NAME = "sysDept";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SysDeptRepository sysDeptRepository;

    public SysDeptResource(SysDeptRepository sysDeptRepository) {
        this.sysDeptRepository = sysDeptRepository;
    }

    /**
     * {@code POST  /sys-depts} : Create a new sysDept.
     *
     * @param sysDept the sysDept to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sysDept, or with status {@code 400 (Bad Request)} if the sysDept has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sys-depts")
    public ResponseEntity<SysDept> createSysDept(@Valid @RequestBody SysDept sysDept) throws URISyntaxException {
        log.debug("REST request to save SysDept : {}", sysDept);
        if (sysDept.getId() != null) {
            throw new BadRequestAlertException("A new sysDept cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SysDept result = sysDeptRepository.save(sysDept);
        return ResponseEntity.created(new URI("/api/sys-depts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /sys-depts} : Updates an existing sysDept.
     *
     * @param sysDept the sysDept to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sysDept,
     * or with status {@code 400 (Bad Request)} if the sysDept is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sysDept couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sys-depts")
    public ResponseEntity<SysDept> updateSysDept(@Valid @RequestBody SysDept sysDept) throws URISyntaxException {
        log.debug("REST request to update SysDept : {}", sysDept);
        if (sysDept.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SysDept result = sysDeptRepository.save(sysDept);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sysDept.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /sys-depts} : get all the sysDepts.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sysDepts in body.
     */
    @GetMapping("/sys-depts")
    public List<SysDept> getAllSysDepts() {
        log.debug("REST request to get all SysDepts");
        return sysDeptRepository.findAll();
    }

    /**
     * {@code GET  /sys-depts/:id} : get the "id" sysDept.
     *
     * @param id the id of the sysDept to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sysDept, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sys-depts/{id}")
    public ResponseEntity<SysDept> getSysDept(@PathVariable Long id) {
        log.debug("REST request to get SysDept : {}", id);
        Optional<SysDept> sysDept = sysDeptRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(sysDept);
    }

    /**
     * {@code DELETE  /sys-depts/:id} : delete the "id" sysDept.
     *
     * @param id the id of the sysDept to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sys-depts/{id}")
    public ResponseEntity<Void> deleteSysDept(@PathVariable Long id) {
        log.debug("REST request to delete SysDept : {}", id);
        sysDeptRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
