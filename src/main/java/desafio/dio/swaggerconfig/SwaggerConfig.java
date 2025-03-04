package desafio.dio.swaggerconfig;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gerenciamento de Filmes 🎬")
                        .version("1.0.0")
                        .description("Esta API permite gerenciar filmes, incluindo cadastro, listagem, atualização e exclusão.")
                );
    }
}