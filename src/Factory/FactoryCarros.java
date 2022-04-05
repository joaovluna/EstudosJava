package Factory;

import Carros.Carro;
import Carros.Ferrari;
import Carros.Fiat;

public class FactoryCarros {
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
