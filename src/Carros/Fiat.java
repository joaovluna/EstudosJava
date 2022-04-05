package Carros;


public class Fiat extends Carro {

    public Fiat(){
        setMarca("Fiat");
    }

    @Override
    public double getPrecoAVista() {
        return getValor()*0.5;
    }


}
