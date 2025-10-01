package com.y4ncx.analizador.infrastructure.mappers;

import com.y4ncx.analizador.domain.entities.Archivo;
import com.y4ncx.analizador.domain.valueobjects.NumeroVO;

import java.util.List;
import java.util.stream.Collectors;

public class ArchivoMapper {

    public Archivo toDomain(String ruta, List<Double> valores) {
        List<NumeroVO> numeros = valores.stream().map(NumeroVO::new).collect(Collectors.toList());
        return new Archivo(ruta, numeros);
    }

    public List<Double> toValores(Archivo archivo) {
        return archivo.getNumeros().stream().map(NumeroVO::getValor).collect(Collectors.toList());
    }
}
