import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Configuração para permitir o acesso à API /api/monitoradores
        registry.addResourceHandler("/api/monitoradores/**")
                .addResourceLocations("classpath:/static/"); // Altere conforme necessário
    }
}


