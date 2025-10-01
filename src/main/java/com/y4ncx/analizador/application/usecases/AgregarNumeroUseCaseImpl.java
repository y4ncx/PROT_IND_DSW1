// src/main/java/com/y4ncx/analizador/application/usecases/AgregarNumeroUseCaseImpl.java
package com.y4ncx.analizador.application.usecases;

import com.y4ncx.analizador.application.ports.in.AgregarNumeroUseCase;
import com.y4ncx.analizador.application.ports.out.ArchivoRepository;
import com.y4ncx.analizador.application.ports.out.NotificadorEvento;
import com.y4ncx.analizador.domain.entities.Archivo;
import com.y4ncx.analizador.domain.valueobjects.NumeroVO;
import com.y4ncx.analizador.domain.events.NumeroAgregado;

public class AgregarNumeroUseCaseImpl implements AgregarNumeroUseCase {

    private final ArchivoRepository archivoRepo;
    private final NotificadorEvento notificador;

    public AgregarNumeroUseCaseImpl(ArchivoRepository archivoRepo, NotificadorEvento notificador) {
        this.archivoRepo = archivoRepo;
        this.notificador = notificador;
    }

    @Override
    public void agregarNumero(String rutaArchivo, double valor) {
        Archivo archivo = archivoRepo.cargar(rutaArchivo);
        if (archivo == null) {
            archivo = new Archivo(rutaArchivo);
        }
        NumeroVO numero = new NumeroVO(valor);
        archivo.agregarNumero(numero); // valida invariantes
        archivoRepo.guardar(archivo);
        NumeroAgregado evento = new NumeroAgregado(rutaArchivo, numero);
        notificador.publicarNumeroAgregado(evento);
    }
}
