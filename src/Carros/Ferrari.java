package Carros;


public class Ferrari extends Carro{


    public Ferrari(){
        setMarca("Ferrari");
    }

    @Override
    public double getPrecoAVista() {
        return getValor()*0.8;
    }


}
