/**
 * 
 */
package com.codetest.services.userinputserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * @author jagdish
 *
 */
@Configuration
public class UserInputServerConfig {
	@Value("${http.client.pool.max.total}")
	private int poolMaxTotal;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
    public ClientHttpRequestFactory httpRequestFactory()
    {
        return new HttpComponentsClientHttpRequestFactory(httpClient());
    }
	
	@Bean
    public HttpClient httpClient()
    {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(poolMaxTotal);
        return HttpClientBuilder
                .create()
                .setConnectionManager(connectionManager)
                .build();
    }
}
