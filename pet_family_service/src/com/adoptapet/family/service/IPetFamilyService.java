/**
 * Project Name: pet_family_service
 * Package Name: com.adoptapet.family..api.service
 * Class Name: IPetUtilitiesService.java
 * Description:
 *
 *
 * Created Date:Aug 24, 2016
 * Modified Date:Aug 24, 2016
 *
 * Copyright to Treselle
 */
package com.adoptapet.family.service;

import java.util.List;

public interface IPetFamilyService {

    Object getFamilies(List<Integer> ids);

    /**
     * @return object Aug 24, 2016
     */
    Object getStatus();
}
