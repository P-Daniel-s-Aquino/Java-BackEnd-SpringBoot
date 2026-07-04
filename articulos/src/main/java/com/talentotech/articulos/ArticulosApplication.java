package com.talentotech.articulos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotación principal de Spring Boot que activa el auto-configurado, el escaneo de componentes
// y la configuración predeterminada de la aplicación.
@SpringBootApplication
public class ArticulosApplication {

    // Método principal que arranca la aplicación Spring Boot.
    public static void main(String[] args) {
        SpringApplication.run(ArticulosApplication.class, args);
    }

}
