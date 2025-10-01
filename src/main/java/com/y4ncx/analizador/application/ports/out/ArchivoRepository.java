// src/main/java/com/y4ncx/analizador/application/ports/out/ArchivoRepository.java
package com.y4ncx.analizador.application.ports.out;

import com.y4ncx.analizador.domain.entities.Archivo;

public interface ArchivoRepository {
    void guardar(Archivo archivo);
    Archivo cargar(String rutaArchivo);
}
