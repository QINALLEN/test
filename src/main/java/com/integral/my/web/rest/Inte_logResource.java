package com.integral.my.web.rest;

import com.integral.my.domain.Inte_log;
import com.integral.my.service.Inte_logService;
import com.integral.my.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.integral.my.domain.Inte_log}.
 */
@RestController
@RequestMapping("/api")
public class Inte_logResource {

    private final Logger log = LoggerFactory.getLogger(Inte_logResource.class);

    private static final String ENTITY_NAME = "integralInteLog";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final Inte_logService inte_logService;

    public Inte_logResource(Inte_logService inte_logService) {
        this.inte_logService = inte_logService;
    }

    /**
     * {@code POST  /inte-logs} : Create a new inte_log.
     *
     * @param inte_log the inte_log to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new inte_log, or with status {@code 400 (Bad Request)} if the inte_log has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/inte-logs")
    public ResponseEntity<Inte_log> createInte_log(@RequestBody Inte_log inte_log) throws URISyntaxException {
        log.debug("REST request to save Inte_log : {}", inte_log);
        if (inte_log.getId() != null) {
            throw new BadRequestAlertException("A new inte_log cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Inte_log result = inte_logService.save(inte_log);
        return ResponseEntity.created(new URI("/api/inte-logs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /inte-logs} : Updates an existing inte_log.
     *
     * @param inte_log the inte_log to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated inte_log,
     * or with status {@code 400 (Bad Request)} if the inte_log is not valid,
     * or with status {@code 500 (Internal Server Error)} if the inte_log couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/inte-logs")
    public ResponseEntity<Inte_log> updateInte_log(@RequestBody Inte_log inte_log) throws URISyntaxException {
        log.debug("REST request to update Inte_log : {}", inte_log);
        if (inte_log.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Inte_log result = inte_logService.save(inte_log);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, inte_log.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /inte-logs} : get all the inte_logs.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of inte_logs in body.
     */
    @GetMapping("/inte-logs")
    public List<Inte_log> getAllInte_logs() {
        log.debug("REST request to get all Inte_logs");
        return inte_logService.findAll();
    }

    /**
     * {@code GET  /inte-logs/:id} : get the "id" inte_log.
     *
     * @param id the id of the inte_log to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the inte_log, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/inte-logs/{id}")
    public ResponseEntity<Inte_log> getInte_log(@PathVariable Long id) {
        log.debug("REST request to get Inte_log : {}", id);
        Optional<Inte_log> inte_log = inte_logService.findOne(id);
        return ResponseUtil.wrapOrNotFound(inte_log);
    }

    /**
     * {@code DELETE  /inte-logs/:id} : delete the "id" inte_log.
     *
     * @param id the id of the inte_log to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/inte-logs/{id}")
    public ResponseEntity<Void> deleteInte_log(@PathVariable Long id) {
        log.debug("REST request to delete Inte_log : {}", id);
        inte_logService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
