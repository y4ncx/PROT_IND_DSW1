// src/main/java/com/y4ncx/analizador/application/ports/out/NotificadorEvento.java
package com.y4ncx.analizador.application.ports.out;

import com.y4ncx.analizador.domain.events.NumeroAgregado;
import com.y4ncx.analizador.domain.events.ArchivoAnalizado;

public interface NotificadorEvento {
    void publicarNumeroAgregado(NumeroAgregado evento);
    void publicarArchivoAnalizado(ArchivoAnalizado evento);
}
