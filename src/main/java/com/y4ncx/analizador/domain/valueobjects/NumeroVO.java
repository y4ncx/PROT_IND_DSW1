// src/main/java/com/y4ncx/analizador/domain/valueobjects/NumeroVO.java
package com.y4ncx.analizador.domain.valueobjects;

import com.y4ncx.analizador.domain.exceptions.NumeroInvalidoException;

import java.util.Objects;

public final class NumeroVO {
    private final double valor;

    public NumeroVO(double valor) {
        if (Double.isNaN(valor)) {
            throw new NumeroInvalidoException("El número no puede ser NaN");
        }
        if (valor < 0) {
            throw new NumeroInvalidoException("El número no puede ser negativo");
        }
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public NumeroVO sumar(NumeroVO otro) {
        return new NumeroVO(this.valor + otro.valor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumeroVO)) return false;
        NumeroVO numeroVO = (NumeroVO) o;
        return Double.compare(numeroVO.valor, valor) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    @Override
    public String toString() {
        return Double.toString(valor);
    }
}
