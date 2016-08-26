/**
 * Project Name: pet_family_service
 * Package Name: com.adoptapet.family..api.controller
 * Class Name: PetUtilitiesController.java
 * Description:
 *
 *
 * Created Date:Aug 24, 2016
 * Modified Date:Aug 24, 2016
 *
 * Copyright to Treselle
 */
package com.adoptapet.family.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adoptapet.family.service.IPetFamilyService;

@RestController
public class PetFamilyController {

    /**
     * LOGGER
     */
    public static final Logger LOG = Logger.getLogger(PetFamilyController.class);

    @Autowired
    private IPetFamilyService  petFamilyService;

    @RequestMapping(value = "/pets/families/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public Object getFamilies(@PathVariable("id") List<Integer> ids) {
        PetFamilyController.LOG.info("/pets/colors/ service initialized for " + ids);
        long start = System.currentTimeMillis();

        Map<String, Object> response = new HashMap<String, Object>();
        try {
            response.put("response", this.petFamilyService.getFamilies(ids));
        } catch (Exception e) {
            response.put("error", e.getMessage());
            PetFamilyController.LOG.error("Exception occured at /pets/colors/ " + e.getMessage());
        }

        long end = System.currentTimeMillis();
        PetFamilyController.LOG.info("/pets/families/ service initialized for " + ids + " executed, time taken: " + (end - start));
        return response;
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public Object getStatus() {
        PetFamilyController.LOG.info("/status service initialized ");
        long start = System.currentTimeMillis();

        Map<String, Object> response = new HashMap<String, Object>();
        try {
            response.put("status", this.petFamilyService.getStatus());
        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("code", 500);
            error.put("msg", e.getMessage());
            error.put("details", e.getMessage());
            response.put("error", error);
            PetFamilyController.LOG.error("Exception occured at /status " + e.getMessage());
        }

        long end = System.currentTimeMillis();
        PetFamilyController.LOG.info("/status service initialized executed, time taken: " + (end - start));
        return response;
    }
}
