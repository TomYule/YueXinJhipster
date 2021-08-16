package com.yuexin.web.rest;

import com.yuexin.domain.SysNotice;
import com.yuexin.repository.SysNoticeRepository;
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
 * REST controller for managing {@link com.yuexin.domain.SysNotice}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SysNoticeResource {

    private final Logger log = LoggerFactory.getLogger(SysNoticeResource.class);

    private static final String ENTITY_NAME = "sysNotice";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SysNoticeRepository sysNoticeRepository;

    public SysNoticeResource(SysNoticeRepository sysNoticeRepository) {
        this.sysNoticeRepository = sysNoticeRepository;
    }

    /**
     * {@code POST  /sys-notices} : Create a new sysNotice.
     *
     * @param sysNotice the sysNotice to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sysNotice, or with status {@code 400 (Bad Request)} if the sysNotice has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sys-notices")
    public ResponseEntity<SysNotice> createSysNotice(@Valid @RequestBody SysNotice sysNotice) throws URISyntaxException {
        log.debug("REST request to save SysNotice : {}", sysNotice);
        if (sysNotice.getId() != null) {
            throw new BadRequestAlertException("A new sysNotice cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SysNotice result = sysNoticeRepository.save(sysNotice);
        return ResponseEntity.created(new URI("/api/sys-notices/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /sys-notices} : Updates an existing sysNotice.
     *
     * @param sysNotice the sysNotice to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sysNotice,
     * or with status {@code 400 (Bad Request)} if the sysNotice is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sysNotice couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sys-notices")
    public ResponseEntity<SysNotice> updateSysNotice(@Valid @RequestBody SysNotice sysNotice) throws URISyntaxException {
        log.debug("REST request to update SysNotice : {}", sysNotice);
        if (sysNotice.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SysNotice result = sysNoticeRepository.save(sysNotice);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sysNotice.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /sys-notices} : get all the sysNotices.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sysNotices in body.
     */
    @GetMapping("/sys-notices")
    public ResponseEntity<List<SysNotice>> getAllSysNotices(Pageable pageable) {
        log.debug("REST request to get a page of SysNotices");
        Page<SysNotice> page = sysNoticeRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /sys-notices/:id} : get the "id" sysNotice.
     *
     * @param id the id of the sysNotice to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sysNotice, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sys-notices/{id}")
    public ResponseEntity<SysNotice> getSysNotice(@PathVariable Long id) {
        log.debug("REST request to get SysNotice : {}", id);
        Optional<SysNotice> sysNotice = sysNoticeRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(sysNotice);
    }

    /**
     * {@code DELETE  /sys-notices/:id} : delete the "id" sysNotice.
     *
     * @param id the id of the sysNotice to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sys-notices/{id}")
    public ResponseEntity<Void> deleteSysNotice(@PathVariable Long id) {
        log.debug("REST request to delete SysNotice : {}", id);
        sysNoticeRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
