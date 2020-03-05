package com.integral.my.web.rest;

import com.integral.my.service.IntegralLogsService;
import com.integral.my.web.rest.errors.BadRequestAlertException;
import com.integral.my.service.dto.IntegralLogsDTO;

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
 * REST controller for managing {@link com.integral.my.domain.IntegralLogs}.
 */
@RestController
@RequestMapping("/api")
public class IntegralLogsResource {

    private final Logger log = LoggerFactory.getLogger(IntegralLogsResource.class);

    private static final String ENTITY_NAME = "integralIntegralLogs";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final IntegralLogsService integralLogsService;

    public IntegralLogsResource(IntegralLogsService integralLogsService) {
        this.integralLogsService = integralLogsService;
    }

    /**
     * {@code POST  /integral-logs} : Create a new integralLogs.
     *
     * @param integralLogsDTO the integralLogsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new integralLogsDTO, or with status {@code 400 (Bad Request)} if the integralLogs has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/integral-logs")
    public ResponseEntity<IntegralLogsDTO> createIntegralLogs(@RequestBody IntegralLogsDTO integralLogsDTO) throws URISyntaxException {
        log.debug("REST request to save IntegralLogs : {}", integralLogsDTO);
        if (integralLogsDTO.getId() != null) {
            throw new BadRequestAlertException("A new integralLogs cannot already have an ID", ENTITY_NAME, "idexists");
        }
        IntegralLogsDTO result = integralLogsService.save(integralLogsDTO);
        return ResponseEntity.created(new URI("/api/integral-logs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /integral-logs} : Updates an existing integralLogs.
     *
     * @param integralLogsDTO the integralLogsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated integralLogsDTO,
     * or with status {@code 400 (Bad Request)} if the integralLogsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the integralLogsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/integral-logs")
    public ResponseEntity<IntegralLogsDTO> updateIntegralLogs(@RequestBody IntegralLogsDTO integralLogsDTO) throws URISyntaxException {
        log.debug("REST request to update IntegralLogs : {}", integralLogsDTO);
        if (integralLogsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        IntegralLogsDTO result = integralLogsService.save(integralLogsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, integralLogsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /integral-logs} : get all the integralLogs.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of integralLogs in body.
     */
    @GetMapping("/integral-logs")
    public List<IntegralLogsDTO> getAllIntegralLogs() {
        log.debug("REST request to get all IntegralLogs");
        return integralLogsService.findAll();
    }

    /**
     * {@code GET  /integral-logs/:id} : get the "id" integralLogs.
     *
     * @param id the id of the integralLogsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the integralLogsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/integral-logs/{id}")
    public ResponseEntity<IntegralLogsDTO> getIntegralLogs(@PathVariable Long id) {
        log.debug("REST request to get IntegralLogs : {}", id);
        Optional<IntegralLogsDTO> integralLogsDTO = integralLogsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(integralLogsDTO);
    }

    /**
     * {@code DELETE  /integral-logs/:id} : delete the "id" integralLogs.
     *
     * @param id the id of the integralLogsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/integral-logs/{id}")
    public ResponseEntity<Void> deleteIntegralLogs(@PathVariable Long id) {
        log.debug("REST request to delete IntegralLogs : {}", id);
        integralLogsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
