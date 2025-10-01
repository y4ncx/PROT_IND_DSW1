// src/main/java/com/y4ncx/analizador/domain/services/AnalizadorEstadisticoService.java
package com.y4ncx.analizador.domain.services;

import com.y4ncx.analizador.domain.valueobjects.NumeroVO;
import com.y4ncx.analizador.application.dto.ResultadoEstadistico;
import java.util.List;
import java.util.stream.Collectors;

public class AnalizadorEstadisticoService {

    public ResultadoEstadistico analizar(List<NumeroVO> numerosVO) {
        if (numerosVO == null || numerosVO.isEmpty()) {
            return new ResultadoEstadistico(0,0,0,0);
        }

        List<Double> valores = numerosVO.stream().map(NumeroVO::getValor).collect(Collectors.toList());

        double min = valores.stream().mapToDouble(Double::doubleValue).min().orElse(0);
        double max = valores.stream().mapToDouble(Double::doubleValue).max().orElse(0);
        double avg = valores.stream().mapToDouble(Double::doubleValue).average().orElse(0);

        // Mediana: ordenar copia
        List<Double> sorted = valores.stream().sorted().collect(Collectors.toList());
        double mediana;
        int n = sorted.size();
        if (n % 2 == 1) {
            mediana = sorted.get(n/2);
        } else {
            mediana = (sorted.get(n/2 - 1) + sorted.get(n/2)) / 2.0;
        }

        return new ResultadoEstadistico(min, max, avg, mediana);
    }
}
