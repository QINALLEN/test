package com.integral.my.web.rest;

import com.integral.my.service.IntegralCompaysService;
import com.integral.my.web.rest.errors.BadRequestAlertException;
import com.integral.my.service.dto.IntegralCompaysDTO;

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
 * REST controller for managing {@link com.integral.my.domain.IntegralCompays}.
 */
@RestController
@RequestMapping("/api")
public class IntegralCompaysResource {

    private final Logger log = LoggerFactory.getLogger(IntegralCompaysResource.class);

    private static final String ENTITY_NAME = "integralIntegralCompays";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final IntegralCompaysService integralCompaysService;

    public IntegralCompaysResource(IntegralCompaysService integralCompaysService) {
        this.integralCompaysService = integralCompaysService;
    }

    /**
     * {@code POST  /integral-compays} : Create a new integralCompays.
     *
     * @param integralCompaysDTO the integralCompaysDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new integralCompaysDTO, or with status {@code 400 (Bad Request)} if the integralCompays has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/integral-compays")
    public ResponseEntity<IntegralCompaysDTO> createIntegralCompays(@RequestBody IntegralCompaysDTO integralCompaysDTO) throws URISyntaxException {
        log.debug("REST request to save IntegralCompays : {}", integralCompaysDTO);
        if (integralCompaysDTO.getId() != null) {
            throw new BadRequestAlertException("A new integralCompays cannot already have an ID", ENTITY_NAME, "idexists");
        }
        IntegralCompaysDTO result = integralCompaysService.save(integralCompaysDTO);
        return ResponseEntity.created(new URI("/api/integral-compays/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /integral-compays} : Updates an existing integralCompays.
     *
     * @param integralCompaysDTO the integralCompaysDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated integralCompaysDTO,
     * or with status {@code 400 (Bad Request)} if the integralCompaysDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the integralCompaysDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/integral-compays")
    public ResponseEntity<IntegralCompaysDTO> updateIntegralCompays(@RequestBody IntegralCompaysDTO integralCompaysDTO) throws URISyntaxException {
        log.debug("REST request to update IntegralCompays : {}", integralCompaysDTO);
        if (integralCompaysDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        IntegralCompaysDTO result = integralCompaysService.save(integralCompaysDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, integralCompaysDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /integral-compays} : get all the integralCompays.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of integralCompays in body.
     */
    @GetMapping("/integral-compays")
    public ResponseEntity<Page<IntegralCompaysDTO>> getAllIntegralCompays(String key,Pageable pageable) {
        log.debug("REST request to get a page of IntegralCompays");
        Page<IntegralCompaysDTO> page = integralCompaysService.findAll(key,pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page);
    }

    /**
     * {@code GET  /integral-compays/:id} : get the "id" integralCompays.
     *
     * @param id the id of the integralCompaysDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the integralCompaysDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/integral-compays/{id}")
    public ResponseEntity<IntegralCompaysDTO> getIntegralCompays(@PathVariable Long id) {
        log.debug("REST request to get IntegralCompays : {}", id);
        Optional<IntegralCompaysDTO> integralCompaysDTO = integralCompaysService.findOne(id);
        return ResponseUtil.wrapOrNotFound(integralCompaysDTO);
    }

    /**
     * {@code DELETE  /integral-compays/:id} : delete the "id" integralCompays.
     *
     * @param id the id of the integralCompaysDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/integral-compays/{id}")
    public ResponseEntity<Void> deleteIntegralCompays(@PathVariable Long id) {
        log.debug("REST request to delete IntegralCompays : {}", id);
        integralCompaysService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
