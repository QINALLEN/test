package com.integral.my.web.rest;

import com.integral.my.service.IntegralDetailsService;
import com.integral.my.service.dto.ResultView;
import com.integral.my.service.dto.ReturnDetails;
import com.integral.my.web.rest.errors.BadRequestAlertException;
import com.integral.my.service.dto.IntegralDetailsDTO;

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
 * REST controller for managing {@link com.integral.my.domain.IntegralDetails}.
 */
@RestController
@RequestMapping("/api")
public class IntegralDetailsResource {

    private final Logger log = LoggerFactory.getLogger(IntegralDetailsResource.class);

    private static final String ENTITY_NAME = "integralIntegralDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final IntegralDetailsService integralDetailsService;

    public IntegralDetailsResource(IntegralDetailsService integralDetailsService) {
        this.integralDetailsService = integralDetailsService;
    }

    /**
     * {@code POST  /integral-details} : Create a new integralDetails.
     *
     * @param integralDetailsDTO the integralDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new integralDetailsDTO, or with status {@code 400 (Bad Request)} if the integralDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/integral-details")
    public ResultView<String> createIntegralDetails(@RequestBody IntegralDetailsDTO integralDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save IntegralDetails : {}", integralDetailsDTO);
        if (integralDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new integralDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        try {
            return integralDetailsService.save(integralDetailsDTO);
        }catch (Exception e){
            return new ResultView<String>("1",e.getMessage(),"提交失败");
        }
    }

    /**
     * {@code PUT  /integral-details} : Updates an existing integralDetails.
     *
     * @param integralDetailsDTO the integralDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated integralDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the integralDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the integralDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/integral-details")
    public ResultView<String> updateIntegralDetails(@RequestBody IntegralDetailsDTO integralDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update IntegralDetails : {}", integralDetailsDTO);
        if (integralDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        return integralDetailsService.save(integralDetailsDTO);
    }

    /**
     * {@code GET  /integral-details} : get all the integralDetails.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of integralDetails in body.
     */
    @GetMapping("/integral-details")
    public ResultView getAllIntegralDetails(String viewerId, Integer type, Pageable pageable) {
        log.debug("REST request to get a page of IntegralDetails");
        try {
            return integralDetailsService.findAll(viewerId, type, pageable);
        }catch (Exception e){
            return new ResultView("1","ero",null);
        }
    }

    /**
     * {@code GET  /integral-details/:id} : get the "id" integralDetails.
     *
     * @param id the id of the integralDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the integralDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/integral-details/{id}")
    public ResponseEntity<IntegralDetailsDTO> getIntegralDetails(@PathVariable Long id) {
        log.debug("REST request to get IntegralDetails : {}", id);
        Optional<IntegralDetailsDTO> integralDetailsDTO = integralDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(integralDetailsDTO);
    }

    /**
     * {@code DELETE  /integral-details/:id} : delete the "id" integralDetails.
     *
     * @param id the id of the integralDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/integral-details/{id}")
    public ResponseEntity<Void> deleteIntegralDetails(@PathVariable Long id) {
        log.debug("REST request to delete IntegralDetails : {}", id);
        integralDetailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
