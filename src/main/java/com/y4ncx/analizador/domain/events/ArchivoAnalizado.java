// src/main/java/com/y4ncx/analizador/domain/events/ArchivoAnalizado.java
package com.y4ncx.analizador.domain.events;

import java.time.Instant;
import com.y4ncx.analizador.application.dto.ResultadoEstadistico;

public class ArchivoAnalizado {
    private final String rutaArchivo;
    private final ResultadoEstadistico resultado;
    private final Instant timestamp;

    public ArchivoAnalizado(String rutaArchivo, ResultadoEstadistico resultado) {
        this.rutaArchivo = rutaArchivo;
        this.resultado = resultado;
        this.timestamp = Instant.now();
    }

    public String getRutaArchivo() { return rutaArchivo; }
    public ResultadoEstadistico getResultado() { return resultado; }
    public Instant getTimestamp() { return timestamp; }
}
