package com.shinesolutions.swagger.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Setter
@Getter
@ToString
@ConfigurationProperties(prefix="app")
@Validated
public class SwaggerClientProperties {

    private int readTimeout;
    private int connectTimeout;
    private String serviceUrl;
    private String httpProxyHost;
    private String httpProxyPort;
}
