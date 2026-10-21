
package tn.esprit.tpfoyer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("TP Foyer API")
                        .version("1.0")
                        .description("API de gestion du foyer"));
    }

    @Bean
    public GroupedOpenApi agencesGroup() {
        return GroupedOpenApi.builder()
                .group("Agences")
                .pathsToMatch("/api/agences/**")
                .build();
    }

    @Bean
    public GroupedOpenApi clientsGroup() {
        return GroupedOpenApi.builder()
                .group("Clients")
                .pathsToMatch("/api/clients/**")
                .build();
    }

    @Bean
    public GroupedOpenApi contratsGroup() {
        return GroupedOpenApi.builder()
                .group("Contrats")
                .pathsToMatch("/api/contrats/**")
                .build();
    }

    @Bean
    public GroupedOpenApi paiementsGroup() {
        return GroupedOpenApi.builder()
                .group("Paiements")
                .pathsToMatch("/api/paiements/**")
                .build();
    }

    @Bean
    public GroupedOpenApi employesGroup() {
        return GroupedOpenApi.builder()
                .group("Employes")
                .pathsToMatch("/api/employes/**")
                .build();
    }

    @Bean
    public GroupedOpenApi vehiculesGroup() {
        return GroupedOpenApi.builder()
                .group("Vehicules")
                .pathsToMatch("/api/vehicules/**")
                .build();
    }

    @Bean
    public GroupedOpenApi equipementsGroup() {
        return GroupedOpenApi.builder()
                .group("Equipements")
                .pathsToMatch("/api/equipements/**")
                .build();
    }

    @Bean
    public GroupedOpenApi reservationsGroup() {
        return GroupedOpenApi.builder()
                .group("Reservations")
                .pathsToMatch("/api/reservations/**")
                .build();
    }

    @Bean
    public GroupedOpenApi maintenancesGroup() {
        return GroupedOpenApi.builder()
                .group("Maintenances")
                .pathsToMatch("/api/maintenances/**")
                .build();
    }
}
