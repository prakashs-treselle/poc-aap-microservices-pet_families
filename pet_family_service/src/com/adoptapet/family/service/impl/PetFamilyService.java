/**
 * Project Name: pet_family_service
 * Package Name: com.adoptapet.family..api.service.impl
 * Class Name: PetUtilitiesService.java
 * Description:
 *
 *
 * Created Date:Aug 24, 2016
 * Modified Date:Aug 24, 2016
 *
 * Copyright to Treselle
 */
package com.adoptapet.family.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.adoptapet.family.service.IPetFamilyService;
import com.adoptapet.utilities.dao.IPetUtilitiesDao;
import com.adoptapet.utilities.dao.impl.PetUtilitiesDao;
import com.adoptapet.utilities.utils.PropertyUtil;

@Service
public class PetFamilyService implements IPetFamilyService {

    private IPetUtilitiesDao petUtilitiesDao;

    public PetFamilyService() {
        String hostName = PropertyUtil.getValue("es.hostname", "localhost");
        int port = Integer.parseInt(PropertyUtil.getValue("es.port", "9300"));
        String clusterName = PropertyUtil.getValue("es.cluster.name", "elasticsearch");
        try {
            this.petUtilitiesDao = new PetUtilitiesDao(hostName, port, clusterName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.adoptapet.family..api.service.IPetUtilitiesService#getColors(java
     * .util.List)
     * 
     * Aug 24, 2016
     */
    @Override
    public Object getFamilies(List<Integer> ids) {
        return this.petUtilitiesDao.getFamilies(ids);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.adoptapet.family..api.service.IPetUtilitiesService#getStatus()
     * 
     * Aug 24, 2016
     */
    @Override
    public Object getStatus() {
        Map<String, Object> response = new HashMap<>();
        response.put("initialized", true);
        response.put("db_healthy", this.petUtilitiesDao.getStatus());
        return response;
    }

}
