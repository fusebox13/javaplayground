package com.fuseworks.labs.playground.sandbox;

import com.fuseworks.labs.playground.config.HowDoBeansWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Sandbox {

    @Autowired
    HowDoBeansWork howDoBeansWork;

    public String getStringFromConfigurationBean() {

        return howDoBeansWork.getSomeString();
    }

}
