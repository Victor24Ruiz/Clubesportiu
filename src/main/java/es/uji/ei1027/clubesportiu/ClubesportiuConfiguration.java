package es.uji.ei1027.clubesportiu;

import es.uji.ei1027.clubesportiu.Categoria.Categoria;
import es.uji.ei1027.clubesportiu.Categoria.CategoriaFederacio;
import es.uji.ei1027.clubesportiu.Categoria.CategoriaWorldCup;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class ClubesportiuConfiguration {

    // Configura l'accés a la base de dades (DataSource)
    // a partir de les propietats a src/main/resources/applications.properties
    // que comencen pel prefix spring.datasource
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public Categoria categoria() {
        return new CategoriaFederacio();
    }
}

