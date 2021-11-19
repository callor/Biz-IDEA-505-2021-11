package com.callor.jc.config.beans;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EncConfig {

    private EnvironmentStringPBEConfig envConfig() {
        EnvironmentStringPBEConfig config
                = new EnvironmentStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPasswordEnvName("callor.com");
        log.debug("callor.com {}", config.getPassword());
        return config;
    }

    @Bean("encryptor")
    public StandardPBEStringEncryptor encryptor() {
        StandardPBEStringEncryptor encryptor
                = new StandardPBEStringEncryptor();
        encryptor.setConfig(this.envConfig());
        return encryptor;
    }

}
