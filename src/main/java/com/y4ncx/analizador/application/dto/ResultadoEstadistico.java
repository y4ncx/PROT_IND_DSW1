// src/main/java/com/y4ncx/analizador/application/dto/ResultadoEstadistico.java
package com.y4ncx.analizador.application.dto;

public class ResultadoEstadistico {
    private final double minimo;
    private final double maximo;
    private final double promedio;
    private final double mediana;

    public ResultadoEstadistico(double minimo, double maximo, double promedio, double mediana) {
        this.minimo = minimo;
        this.maximo = maximo;
        this.promedio = promedio;
        this.mediana = mediana;
    }

    public double getMinimo() { return minimo; }
    public double getMaximo() { return maximo; }
    public double getPromedio() { return promedio; }
    public double getMediana() { return mediana; }

    @Override
    public String toString() {
        return String.format("Min: %.4f, Max: %.4f, Avg: %.4f, Med: %.4f", minimo, maximo, promedio, mediana);
    }
}
