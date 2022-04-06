package Teste;

import Carros.Carro;
import Carros.Fiat;

public class Teste {
    public static void main(String[] args) {

        /**
         * Testes iniciais para verificação **/
        Carro c1 = new Fiat();
        c1.setModelo("Uno");
        c1.setAnoLancamento(2005);
        c1.setValor(25000.00);
        Carro c2 = new Fiat();
        c2.setModelo("Palio");
        c2.setAnoLancamento(2010);
        c2.setValor(35000.00);
//        Fiat f = new Fiat(); factory determinando qual o carro


//        f.create(c2); atribuir a responsabilidade de criação, em fiat fica muito baguncado, criar uma classe repositorio
//        f.create(c1);
//        System.out.println();
//
//        f.read("Fiat","Uno");
//        System.out.println();
//        f.read("Fiat", "Palio");
//        System.out.println();
//        f.seeAll();
//        System.out.println();
//
//        f.delete("Fiat", "palio");
//        System.out.println();
//        f.seeAll();
//        System.out.println();
//
//        Carro c3 = new Fiat();
//        c3.setModelo("Uno");
//        c3.setAnoLancamento(2022);
//        c3.setValor(225000.00);
//
//        f.update(c2,c3);
//        System.out.println();
//        f.seeAll();



    }
}
