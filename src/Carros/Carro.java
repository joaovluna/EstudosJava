package Carros;
import Agencia.CRUDCarros;

import java.util.List;
import java.util.Locale;

public abstract class Carro {

    protected String marca;
    private String modelo;
    private int anoLancamento;
    private double valor;

    public abstract double getPrecoAVista();


    protected void setMarca(String marca){ this.marca = marca;}
    public void setValor(double valor){
        this.valor = valor;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
    public double getValor(){
        return valor;
    }

}
