package com.yuexin.web.rest;

import com.yuexin.domain.GenTableColumn;
import com.yuexin.repository.GenTableColumnRepository;
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
 * REST controller for managing {@link com.yuexin.domain.GenTableColumn}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class GenTableColumnResource {

    private final Logger log = LoggerFactory.getLogger(GenTableColumnResource.class);

    private static final String ENTITY_NAME = "genTableColumn";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final GenTableColumnRepository genTableColumnRepository;

    public GenTableColumnResource(GenTableColumnRepository genTableColumnRepository) {
        this.genTableColumnRepository = genTableColumnRepository;
    }

    /**
     * {@code POST  /gen-table-columns} : Create a new genTableColumn.
     *
     * @param genTableColumn the genTableColumn to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new genTableColumn, or with status {@code 400 (Bad Request)} if the genTableColumn has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/gen-table-columns")
    public ResponseEntity<GenTableColumn> createGenTableColumn(@Valid @RequestBody GenTableColumn genTableColumn) throws URISyntaxException {
        log.debug("REST request to save GenTableColumn : {}", genTableColumn);
        if (genTableColumn.getId() != null) {
            throw new BadRequestAlertException("A new genTableColumn cannot already have an ID", ENTITY_NAME, "idexists");
        }
        GenTableColumn result = genTableColumnRepository.save(genTableColumn);
        return ResponseEntity.created(new URI("/api/gen-table-columns/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /gen-table-columns} : Updates an existing genTableColumn.
     *
     * @param genTableColumn the genTableColumn to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated genTableColumn,
     * or with status {@code 400 (Bad Request)} if the genTableColumn is not valid,
     * or with status {@code 500 (Internal Server Error)} if the genTableColumn couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/gen-table-columns")
    public ResponseEntity<GenTableColumn> updateGenTableColumn(@Valid @RequestBody GenTableColumn genTableColumn) throws URISyntaxException {
        log.debug("REST request to update GenTableColumn : {}", genTableColumn);
        if (genTableColumn.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        GenTableColumn result = genTableColumnRepository.save(genTableColumn);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, genTableColumn.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /gen-table-columns} : get all the genTableColumns.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of genTableColumns in body.
     */
    @GetMapping("/gen-table-columns")
    public ResponseEntity<List<GenTableColumn>> getAllGenTableColumns(Pageable pageable) {
        log.debug("REST request to get a page of GenTableColumns");
        Page<GenTableColumn> page = genTableColumnRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /gen-table-columns/:id} : get the "id" genTableColumn.
     *
     * @param id the id of the genTableColumn to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the genTableColumn, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/gen-table-columns/{id}")
    public ResponseEntity<GenTableColumn> getGenTableColumn(@PathVariable Long id) {
        log.debug("REST request to get GenTableColumn : {}", id);
        Optional<GenTableColumn> genTableColumn = genTableColumnRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(genTableColumn);
    }

    /**
     * {@code DELETE  /gen-table-columns/:id} : delete the "id" genTableColumn.
     *
     * @param id the id of the genTableColumn to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/gen-table-columns/{id}")
    public ResponseEntity<Void> deleteGenTableColumn(@PathVariable Long id) {
        log.debug("REST request to delete GenTableColumn : {}", id);
        genTableColumnRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
