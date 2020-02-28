package com.integral.my.web.rest;

import com.integral.my.domain.Inte_companys;
import com.integral.my.service.Inte_companysService;
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
 * REST controller for managing {@link com.integral.my.domain.Inte_companys}.
 */
@RestController
@RequestMapping("/api")
public class Inte_companysResource {

    private final Logger log = LoggerFactory.getLogger(Inte_companysResource.class);

    private static final String ENTITY_NAME = "integralInteCompanys";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final Inte_companysService inte_companysService;

    public Inte_companysResource(Inte_companysService inte_companysService) {
        this.inte_companysService = inte_companysService;
    }

    /**
     * {@code POST  /inte-companys} : Create a new inte_companys.
     *
     * @param inte_companys the inte_companys to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new inte_companys, or with status {@code 400 (Bad Request)} if the inte_companys has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/inte-companys")
    public ResponseEntity<Inte_companys> createInte_companys(@RequestBody Inte_companys inte_companys) throws URISyntaxException {
        log.debug("REST request to save Inte_companys : {}", inte_companys);
        if (inte_companys.getId() != null) {
            throw new BadRequestAlertException("A new inte_companys cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Inte_companys result = inte_companysService.save(inte_companys);
        return ResponseEntity.created(new URI("/api/inte-companys/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /inte-companys} : Updates an existing inte_companys.
     *
     * @param inte_companys the inte_companys to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated inte_companys,
     * or with status {@code 400 (Bad Request)} if the inte_companys is not valid,
     * or with status {@code 500 (Internal Server Error)} if the inte_companys couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/inte-companys")
    public ResponseEntity<Inte_companys> updateInte_companys(@RequestBody Inte_companys inte_companys) throws URISyntaxException {
        log.debug("REST request to update Inte_companys : {}", inte_companys);
        if (inte_companys.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Inte_companys result = inte_companysService.save(inte_companys);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, inte_companys.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /inte-companys} : get all the inte_companys.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of inte_companys in body.
     */
    @GetMapping("/inte-companys")
    public ResponseEntity<List<Inte_companys>> getAllInte_companys(Pageable pageable) {
        log.debug("REST request to get a page of Inte_companys");
        Page<Inte_companys> page = inte_companysService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /inte-companys/:id} : get the "id" inte_companys.
     *
     * @param id the id of the inte_companys to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the inte_companys, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/inte-companys/{id}")
    public ResponseEntity<Inte_companys> getInte_companys(@PathVariable Long id) {
        log.debug("REST request to get Inte_companys : {}", id);
        Optional<Inte_companys> inte_companys = inte_companysService.findOne(id);
        return ResponseUtil.wrapOrNotFound(inte_companys);
    }

    /**
     * {@code DELETE  /inte-companys/:id} : delete the "id" inte_companys.
     *
     * @param id the id of the inte_companys to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/inte-companys/{id}")
    public ResponseEntity<Void> deleteInte_companys(@PathVariable Long id) {
        log.debug("REST request to delete Inte_companys : {}", id);
        inte_companysService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
