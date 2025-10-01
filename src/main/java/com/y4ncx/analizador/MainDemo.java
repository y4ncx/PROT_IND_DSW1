// src/main/java/com/y4ncx/analizador/MainDemo.java
package com.y4ncx.analizador;

import com.y4ncx.analizador.application.ports.in.AgregarNumeroUseCase;
import com.y4ncx.analizador.application.ports.in.AnalizarArchivoUseCase;
import com.y4ncx.analizador.application.usecases.AgregarNumeroUseCaseImpl;
import com.y4ncx.analizador.application.usecases.AnalizarArchivoUseCaseImpl;
import com.y4ncx.analizador.application.dto.ResultadoEstadistico;
import com.y4ncx.analizador.domain.services.AnalizadorEstadisticoService;
import com.y4ncx.analizador.infrastructure.adapters.out.InMemoryArchivoRepository;
import com.y4ncx.analizador.infrastructure.adapters.out.ConsoleNotificador;

public class MainDemo {
    public static void main(String[] args) {
        InMemoryArchivoRepository repo = new InMemoryArchivoRepository();
        ConsoleNotificador notificador = new ConsoleNotificador();
        AnalizadorEstadisticoService analizador = new AnalizadorEstadisticoService();

        AgregarNumeroUseCase agregarUseCase = new AgregarNumeroUseCaseImpl(repo, notificador);
        AnalizarArchivoUseCase analizarUseCase = new AnalizarArchivoUseCaseImpl(repo, notificador, analizador);

        String ruta = "datos/test1.txt";

        // Agregamos números
        agregarUseCase.agregarNumero(ruta, 10);
        agregarUseCase.agregarNumero(ruta, 5);
        agregarUseCase.agregarNumero(ruta, 20);

        // Analizar
        ResultadoEstadistico res = analizarUseCase.analizarArchivo(ruta);
        System.out.println("Resultado final: " + res);
    }
}
