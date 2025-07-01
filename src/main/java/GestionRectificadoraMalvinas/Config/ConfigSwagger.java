package GestionRectificadoraMalvinas.Config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSwagger {

@Bean
public OpenAPI customOpenAPI(){
    return new OpenAPI()
            .info(new Info()
                    .title("API gestion Rectificadora Malvinas")
                    .version("1.0.0")
                    .description("API elaborada para la gestion de la Rectificadora Malvinas, la cual toma pedidos, en base a presupuestos con distintos items y clientes")
                    .contact(new Contact()
                            .name("Santiago Ude")
                            .email("santiagoude8@gmail.com")
                            .url("https://github.com/santiago-ude")));
}


}
