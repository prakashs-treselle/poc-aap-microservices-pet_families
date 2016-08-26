/**
 * Project Name: pet_family_service
 * Package Name: com.adoptapet.family.runner
 * Class Name: ServiceRunner.java
 * Description:
 *
 *
 * Created Date:Aug 24, 2016
 * Modified Date:Aug 24, 2016
 *
 * Copyright to Treselle
 */
package com.adoptapet.family.runner;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.adoptapet.utilities.utils.PropertyUtil;

@SpringBootApplication
@ComponentScan(basePackages = { "com.adoptapet.family.configuration", "com.adoptapet.family.controller", "com.adoptapet.family.service", "com.adoptapet.family.dao", "com.adoptapet.family.helper" })
public class ServiceRunner {

    public static final String PROPERTY_FILE = "/application.properties";

    public ServiceRunner() {
        try {
            PropertyUtil.init(this.getClass().getResourceAsStream(PROPERTY_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceRunner.class, args);
    }

}
