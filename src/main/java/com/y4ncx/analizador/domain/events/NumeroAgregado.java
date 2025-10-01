// src/main/java/com/y4ncx/analizador/domain/events/NumeroAgregado.java
package com.y4ncx.analizador.domain.events;

import com.y4ncx.analizador.domain.valueobjects.NumeroVO;
import java.time.Instant;

public class NumeroAgregado {
    private final String rutaArchivo;
    private final NumeroVO numero;
    private final Instant timestamp;

    public NumeroAgregado(String rutaArchivo, NumeroVO numero) {
        this.rutaArchivo = rutaArchivo;
        this.numero = numero;
        this.timestamp = Instant.now();
    }

    public String getRutaArchivo() { return rutaArchivo; }
    public NumeroVO getNumero() { return numero; }
    public Instant getTimestamp() { return timestamp; }
}
