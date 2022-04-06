package Factory;

import Carros.Carro;
import Carros.Ferrari;
import Carros.Fiat;

public class FactoryCarros {
    private FactoryCarros(){}
    private static FactoryCarros instance = null;
    public static synchronized FactoryCarros getInstance(){ //singleton
        if(instance == null){
            instance = new FactoryCarros();
        }
        return instance;
    }
    public Carro getClass(int escolha){
        Carro fabrica = null;
        if(escolha == 1){
            fabrica = new Fiat();
        }else{
            fabrica = new Ferrari();
        }
        return fabrica;
    }
}
