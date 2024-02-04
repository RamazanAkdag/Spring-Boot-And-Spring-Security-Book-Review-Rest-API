
package com.ramazanfirat.bookapp.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Tüm origin'lere izin vermek için:
        config.addAllowedOrigin("*");

        // İzin verilen HTTP metodları:
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS"); // CORS önsorgusu için izin vermek önemlidir.

        // İzin verilen başlıklar:
        config.addAllowedHeader("Authorization");
        config.addAllowedHeader("Content-Type");

        // Sorguların credentials içermesine izin vermek (örneğin, cookie kullanımı):
        config.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
