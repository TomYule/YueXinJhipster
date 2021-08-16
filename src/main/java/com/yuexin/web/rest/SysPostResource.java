package com.yuexin.web.rest;

import com.yuexin.domain.SysPost;
import com.yuexin.repository.SysPostRepository;
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
 * REST controller for managing {@link com.yuexin.domain.SysPost}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class SysPostResource {

    private final Logger log = LoggerFactory.getLogger(SysPostResource.class);

    private static final String ENTITY_NAME = "sysPost";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SysPostRepository sysPostRepository;

    public SysPostResource(SysPostRepository sysPostRepository) {
        this.sysPostRepository = sysPostRepository;
    }

    /**
     * {@code POST  /sys-posts} : Create a new sysPost.
     *
     * @param sysPost the sysPost to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new sysPost, or with status {@code 400 (Bad Request)} if the sysPost has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sys-posts")
    public ResponseEntity<SysPost> createSysPost(@RequestBody SysPost sysPost) throws URISyntaxException {
        log.debug("REST request to save SysPost : {}", sysPost);
        if (sysPost.getId() != null) {
            throw new BadRequestAlertException("A new sysPost cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SysPost result = sysPostRepository.save(sysPost);
        return ResponseEntity.created(new URI("/api/sys-posts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /sys-posts} : Updates an existing sysPost.
     *
     * @param sysPost the sysPost to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated sysPost,
     * or with status {@code 400 (Bad Request)} if the sysPost is not valid,
     * or with status {@code 500 (Internal Server Error)} if the sysPost couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sys-posts")
    public ResponseEntity<SysPost> updateSysPost(@RequestBody SysPost sysPost) throws URISyntaxException {
        log.debug("REST request to update SysPost : {}", sysPost);
        if (sysPost.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SysPost result = sysPostRepository.save(sysPost);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, sysPost.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /sys-posts} : get all the sysPosts.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of sysPosts in body.
     */
    @GetMapping("/sys-posts")
    public ResponseEntity<List<SysPost>> getAllSysPosts(Pageable pageable) {
        log.debug("REST request to get a page of SysPosts");
        Page<SysPost> page = sysPostRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /sys-posts/:id} : get the "id" sysPost.
     *
     * @param id the id of the sysPost to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the sysPost, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sys-posts/{id}")
    public ResponseEntity<SysPost> getSysPost(@PathVariable Long id) {
        log.debug("REST request to get SysPost : {}", id);
        Optional<SysPost> sysPost = sysPostRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(sysPost);
    }

    /**
     * {@code DELETE  /sys-posts/:id} : delete the "id" sysPost.
     *
     * @param id the id of the sysPost to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sys-posts/{id}")
    public ResponseEntity<Void> deleteSysPost(@PathVariable Long id) {
        log.debug("REST request to delete SysPost : {}", id);
        sysPostRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
