// src/main/java/com/y4ncx/analizador/infrastructure/adapters/out/InMemoryArchivoRepository.java
package com.y4ncx.analizador.infrastructure.adapters.out;

import com.y4ncx.analizador.application.ports.out.ArchivoRepository;
import com.y4ncx.analizador.domain.entities.Archivo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryArchivoRepository implements ArchivoRepository {

    private final Map<String, Archivo> store = new ConcurrentHashMap<>();

    @Override
    public void guardar(Archivo archivo) {
        store.put(archivo.getRuta(), archivo);
    }

    @Override
    public Archivo cargar(String rutaArchivo) {
        Archivo a = store.get(rutaArchivo);
        // devolver copia o el mismo? devolvemos el mismo para simplicidad en este adaptador
        return a;
    }
}
