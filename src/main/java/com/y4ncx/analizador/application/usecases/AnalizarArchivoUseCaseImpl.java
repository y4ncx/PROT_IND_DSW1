// src/main/java/com/y4ncx/analizador/application/usecases/AnalizarArchivoUseCaseImpl.java
package com.y4ncx.analizador.application.usecases;

import com.y4ncx.analizador.application.ports.in.AnalizarArchivoUseCase;
import com.y4ncx.analizador.application.ports.out.ArchivoRepository;
import com.y4ncx.analizador.application.ports.out.NotificadorEvento;
import com.y4ncx.analizador.domain.services.AnalizadorEstadisticoService;
import com.y4ncx.analizador.application.dto.ResultadoEstadistico;
import com.y4ncx.analizador.domain.entities.Archivo;
import com.y4ncx.analizador.domain.events.ArchivoAnalizado;

public class AnalizarArchivoUseCaseImpl implements AnalizarArchivoUseCase {

    private final ArchivoRepository archivoRepo;
    private final NotificadorEvento notificador;
    private final AnalizadorEstadisticoService analizador;

    public AnalizarArchivoUseCaseImpl(ArchivoRepository archivoRepo,
                                      NotificadorEvento notificador,
                                      AnalizadorEstadisticoService analizador) {
        this.archivoRepo = archivoRepo;
        this.notificador = notificador;
        this.analizador = analizador;
    }

    @Override
    public ResultadoEstadistico analizarArchivo(String rutaArchivo) {
        Archivo archivo = archivoRepo.cargar(rutaArchivo);
        if (archivo == null) {
            // devolver resultado vacío o lanzar, según decisión de dominio
            return new ResultadoEstadistico(0,0,0,0);
        }
        ResultadoEstadistico resultado = analizador.analizar(archivo.getNumeros());
        ArchivoAnalizado evento = new ArchivoAnalizado(rutaArchivo, resultado);
        notificador.publicarArchivoAnalizado(evento);
        return resultado;
    }
}
