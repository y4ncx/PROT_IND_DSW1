// src/main/java/com/y4ncx/analizador/infrastructure/adapters/out/ConsoleNotificador.java
package com.y4ncx.analizador.infrastructure.adapters.out;

import com.y4ncx.analizador.application.ports.out.NotificadorEvento;
import com.y4ncx.analizador.domain.events.NumeroAgregado;
import com.y4ncx.analizador.domain.events.ArchivoAnalizado;

public class ConsoleNotificador implements NotificadorEvento {

    @Override
    public void publicarNumeroAgregado(NumeroAgregado evento) {
        System.out.println("[EVENT] NumeroAgregado -> archivo: " + evento.getRutaArchivo()
                + " numero=" + evento.getNumero() + " ts=" + evento.getTimestamp());
    }

    @Override
    public void publicarArchivoAnalizado(ArchivoAnalizado evento) {
        System.out.println("[EVENT] ArchivoAnalizado -> archivo: " + evento.getRutaArchivo()
                + " resultado=" + evento.getResultado() + " ts=" + evento.getTimestamp());
    }
}
