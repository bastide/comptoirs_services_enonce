package comptoirs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
public class WebApp {

    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    /*
     * @Bean
     * public WebMvcConfigurer corsConfigurer() {
     * return new WebMvcConfigurer() {
     * 
     * @Override
     * public void addCorsMappings(CorsRegistry registry) {
     * // registry.addMapping("/api/**").allowedOrigins("http://localhost:5173");
     * registry.addMapping("/comptoirs/**").allowedOrigins("http://localhost:5173");
     * //registry.addMapping("/**").getCo
     * }
     * };
     * }
     */
}
