// src/main/java/com/y4ncx/analizador/application/ports/in/AnalizarArchivoUseCase.java
package com.y4ncx.analizador.application.ports.in;

import com.y4ncx.analizador.application.dto.ResultadoEstadistico;

public interface AnalizarArchivoUseCase {
    ResultadoEstadistico analizarArchivo(String rutaArchivo);
}
