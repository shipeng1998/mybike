package com.yc.project.mybike.config;

import io.undertow.Undertow;
import io.undertow.UndertowOptions;
import io.undertow.servlet.api.SecurityConstraint;
import io.undertow.servlet.api.SecurityInfo;
import io.undertow.servlet.api.TransportGuaranteeType;
import io.undertow.servlet.api.WebResourceCollection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
//import org.springframework.boot.context.embedded.undertow.UndertowBuilderCustomizer;
//import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UndertowHttpsConfig {
	
//	    @Bean
//	    public UndertowServletWebServerFactory servletContainer() {
//
//	    	UndertowServletWebServerFactory undertowFactory = new UndertowServletWebServerFactory();
//	        undertowFactory.addBuilderCustomizers(new UndertowBuilderCustomizer() {
//
//	            @Override
//	            public void customize(Undertow.Builder builder) {
//	                builder.addHttpListener(80, "0.0.0.0");
//	            }
//
//	        });
//	        return undertowFactory;
//	    }

	}



