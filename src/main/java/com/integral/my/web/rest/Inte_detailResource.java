package com.integral.my.web.rest;

import com.integral.my.domain.Inte_detail;
import com.integral.my.service.Inte_detailService;
import com.integral.my.web.rest.errors.BadRequestAlertException;

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
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.integral.my.domain.Inte_detail}.
 */
@RestController
@RequestMapping("/api")
public class Inte_detailResource {

    private final Logger log = LoggerFactory.getLogger(Inte_detailResource.class);

    private static final String ENTITY_NAME = "integralInteDetail";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final Inte_detailService inte_detailService;

    public Inte_detailResource(Inte_detailService inte_detailService) {
        this.inte_detailService = inte_detailService;
    }

    /**
     * {@code POST  /inte-details} : Create a new inte_detail.
     *
     * @param inte_detail the inte_detail to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new inte_detail, or with status {@code 400 (Bad Request)} if the inte_detail has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/inte-details")
    public ResponseEntity<Inte_detail> createInte_detail(@RequestBody Inte_detail inte_detail) throws URISyntaxException {
        log.debug("REST request to save Inte_detail : {}", inte_detail);
        if (inte_detail.getId() != null) {
            throw new BadRequestAlertException("A new inte_detail cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Inte_detail result = inte_detailService.save(inte_detail);
        return ResponseEntity.created(new URI("/api/inte-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /inte-details} : Updates an existing inte_detail.
     *
     * @param inte_detail the inte_detail to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated inte_detail,
     * or with status {@code 400 (Bad Request)} if the inte_detail is not valid,
     * or with status {@code 500 (Internal Server Error)} if the inte_detail couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/inte-details")
    public ResponseEntity<Inte_detail> updateInte_detail(@RequestBody Inte_detail inte_detail) throws URISyntaxException {
        log.debug("REST request to update Inte_detail : {}", inte_detail);
        if (inte_detail.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Inte_detail result = inte_detailService.save(inte_detail);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, inte_detail.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /inte-details} : get all the inte_details.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of inte_details in body.
     */
    @GetMapping("/inte-details")
    public ResponseEntity<List<Inte_detail>> getAllInte_details(Pageable pageable) {
        log.debug("REST request to get a page of Inte_details");
        Page<Inte_detail> page = inte_detailService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /inte-details/:id} : get the "id" inte_detail.
     *
     * @param id the id of the inte_detail to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the inte_detail, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/inte-details/{id}")
    public ResponseEntity<Inte_detail> getInte_detail(@PathVariable Long id) {
        log.debug("REST request to get Inte_detail : {}", id);
        Optional<Inte_detail> inte_detail = inte_detailService.findOne(id);
        return ResponseUtil.wrapOrNotFound(inte_detail);
    }

    /**
     * {@code DELETE  /inte-details/:id} : delete the "id" inte_detail.
     *
     * @param id the id of the inte_detail to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/inte-details/{id}")
    public ResponseEntity<Void> deleteInte_detail(@PathVariable Long id) {
        log.debug("REST request to delete Inte_detail : {}", id);
        inte_detailService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
