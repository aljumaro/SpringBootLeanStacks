package com.aljumaro.techtest.infrastructure;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Date 12/11/2016
 * @Time 18:12
 * @Author Juanma
 */
@Component
public class ProfilePropertiesService {

    @Value("${profileName}")
    private String profileName;

    public String getProfileName() {
        return profileName;
    }
}
