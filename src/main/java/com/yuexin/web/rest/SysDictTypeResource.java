package com.yuexin.web.rest;

import com.yuexin.domain.SysDictType;
import com.yuexin.repository.SysDictTypeRepository;
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
 * REST controller for managing {@link com.yuexin.domain.SysDictType}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SysDictTypeResource {

    private final Logger log = LoggerFactory.getLogger(SysDictTypeResource.class);

    private static final String ENTITY_NAME = "sysDictType";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SysDictTypeRepository sysDictTypeRepository;

    public SysDictTypeResource(SysDictTypeRepository sysDictTypeRepository) {
        this.sysDictTypeRepository = sysDictTypeRepository;
    }

    /**
     * {@code POST  /sys-dict-types} : Create a new sysDictType.
     *
     * @param sysDictType the sysDictType to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sysDictType, or with status {@code 400 (Bad Request)} if the sysDictType has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sys-dict-types")
    public ResponseEntity<SysDictType> createSysDictType(@RequestBody SysDictType sysDictType) throws URISyntaxException {
        log.debug("REST request to save SysDictType : {}", sysDictType);
        if (sysDictType.getId() != null) {
            throw new BadRequestAlertException("A new sysDictType cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SysDictType result = sysDictTypeRepository.save(sysDictType);
        return ResponseEntity.created(new URI("/api/sys-dict-types/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /sys-dict-types} : Updates an existing sysDictType.
     *
     * @param sysDictType the sysDictType to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sysDictType,
     * or with status {@code 400 (Bad Request)} if the sysDictType is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sysDictType couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sys-dict-types")
    public ResponseEntity<SysDictType> updateSysDictType(@RequestBody SysDictType sysDictType) throws URISyntaxException {
        log.debug("REST request to update SysDictType : {}", sysDictType);
        if (sysDictType.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SysDictType result = sysDictTypeRepository.save(sysDictType);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sysDictType.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /sys-dict-types} : get all the sysDictTypes.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sysDictTypes in body.
     */
    @GetMapping("/sys-dict-types")
    public ResponseEntity<List<SysDictType>> getAllSysDictTypes(Pageable pageable) {
        log.debug("REST request to get a page of SysDictTypes");
        Page<SysDictType> page = sysDictTypeRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /sys-dict-types/:id} : get the "id" sysDictType.
     *
     * @param id the id of the sysDictType to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sysDictType, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sys-dict-types/{id}")
    public ResponseEntity<SysDictType> getSysDictType(@PathVariable Long id) {
        log.debug("REST request to get SysDictType : {}", id);
        Optional<SysDictType> sysDictType = sysDictTypeRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(sysDictType);
    }

    /**
     * {@code DELETE  /sys-dict-types/:id} : delete the "id" sysDictType.
     *
     * @param id the id of the sysDictType to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sys-dict-types/{id}")
    public ResponseEntity<Void> deleteSysDictType(@PathVariable Long id) {
        log.debug("REST request to delete SysDictType : {}", id);
        sysDictTypeRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
