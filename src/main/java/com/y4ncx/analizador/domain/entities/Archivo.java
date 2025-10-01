// src/main/java/com/y4ncx/analizador/domain/entities/Archivo.java
package com.y4ncx.analizador.domain.entities;

import com.y4ncx.analizador.domain.valueobjects.NumeroVO;
import com.y4ncx.analizador.domain.exceptions.ArchivoInvalidoException;
import com.y4ncx.analizador.domain.exceptions.NumeroInvalidoException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Archivo {
    private final String ruta;
    private final List<NumeroVO> numeros;

    public Archivo(String ruta) {
        if (ruta == null || ruta.trim().isEmpty()) {
            throw new ArchivoInvalidoException("La ruta del archivo es requerida");
        }
        this.ruta = ruta;
        this.numeros = new ArrayList<>();
    }

    // Constructor de apoyo con lista inicial (validada)
    public Archivo(String ruta, List<NumeroVO> numerosIniciales) {
        if (ruta == null || ruta.trim().isEmpty()) {
            throw new ArchivoInvalidoException("La ruta del archivo es requerida");
        }
        this.ruta = ruta;
        this.numeros = new ArrayList<>();
        if (numerosIniciales != null) {
            for (NumeroVO n : numerosIniciales) {
                if (n == null) throw new NumeroInvalidoException("Numero nulo no permitido");
                this.numeros.add(n);
            }
        }
    }

    public String getRuta() { return ruta; }

    // Invariante: no exponer lista modificable
    public List<NumeroVO> getNumeros() {
        return Collections.unmodifiableList(numeros);
    }

    // Raíz controla la consistencia: validar antes de agregar
    public void agregarNumero(NumeroVO numero) {
        if (numero == null) {
            throw new NumeroInvalidoException("Numero nulo no permitido");
        }
        // NumeroVO ya valida negatividad en su constructor, pero chequeo extra por seguridad
        if (Double.isNaN(numero.getValor()) || numero.getValor() < 0) {
            throw new NumeroInvalidoException("Numero invalido");
        }
        this.numeros.add(numero);
        // Nota: aquí podríamos publicar evento, pero el agregado se mantiene simple
    }

    public int cantidad() { return numeros.size(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Archivo)) return false;
        Archivo archivo = (Archivo) o;
        return Objects.equals(ruta, archivo.ruta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ruta);
    }
}
