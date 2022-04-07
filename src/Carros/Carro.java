package Carros;


import Observer.Sujeito;

public abstract class Carro extends Sujeito {

    protected String marca;
    private String modelo;
    private int anoLancamento;
    private double valor;

    public abstract double getPrecoAVista();

    public void setValor(double valor){
        this.valor = valor;

    }

    protected void setMarca(String marca){ this.marca = marca;}

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }


    public void setModelo(String modelo) {
        this.modelo = modelo;
        notificarObservador(); // vai notificar os observadores
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
