package com.yuexin.web.rest;

import com.yuexin.domain.SysDictData;
import com.yuexin.repository.SysDictDataRepository;
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
 * REST controller for managing {@link com.yuexin.domain.SysDictData}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SysDictDataResource {

    private final Logger log = LoggerFactory.getLogger(SysDictDataResource.class);

    private static final String ENTITY_NAME = "sysDictData";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SysDictDataRepository sysDictDataRepository;

    public SysDictDataResource(SysDictDataRepository sysDictDataRepository) {
        this.sysDictDataRepository = sysDictDataRepository;
    }

    /**
     * {@code POST  /sys-dict-data} : Create a new sysDictData.
     *
     * @param sysDictData the sysDictData to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sysDictData, or with status {@code 400 (Bad Request)} if the sysDictData has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sys-dict-data")
    public ResponseEntity<SysDictData> createSysDictData(@RequestBody SysDictData sysDictData) throws URISyntaxException {
        log.debug("REST request to save SysDictData : {}", sysDictData);
        if (sysDictData.getId() != null) {
            throw new BadRequestAlertException("A new sysDictData cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SysDictData result = sysDictDataRepository.save(sysDictData);
        return ResponseEntity.created(new URI("/api/sys-dict-data/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /sys-dict-data} : Updates an existing sysDictData.
     *
     * @param sysDictData the sysDictData to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sysDictData,
     * or with status {@code 400 (Bad Request)} if the sysDictData is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sysDictData couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sys-dict-data")
    public ResponseEntity<SysDictData> updateSysDictData(@RequestBody SysDictData sysDictData) throws URISyntaxException {
        log.debug("REST request to update SysDictData : {}", sysDictData);
        if (sysDictData.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SysDictData result = sysDictDataRepository.save(sysDictData);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sysDictData.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /sys-dict-data} : get all the sysDictData.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sysDictData in body.
     */
    @GetMapping("/sys-dict-data")
    public ResponseEntity<List<SysDictData>> getAllSysDictData(Pageable pageable) {
        log.debug("REST request to get a page of SysDictData");
        Page<SysDictData> page = sysDictDataRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /sys-dict-data/:id} : get the "id" sysDictData.
     *
     * @param id the id of the sysDictData to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sysDictData, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sys-dict-data/{id}")
    public ResponseEntity<SysDictData> getSysDictData(@PathVariable Long id) {
        log.debug("REST request to get SysDictData : {}", id);
        Optional<SysDictData> sysDictData = sysDictDataRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(sysDictData);
    }

    /**
     * {@code DELETE  /sys-dict-data/:id} : delete the "id" sysDictData.
     *
     * @param id the id of the sysDictData to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sys-dict-data/{id}")
    public ResponseEntity<Void> deleteSysDictData(@PathVariable Long id) {
        log.debug("REST request to delete SysDictData : {}", id);
        sysDictDataRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
