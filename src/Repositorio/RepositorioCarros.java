package Repositorio;
import Agencia.CRUDCarros;

import Carros.Carro;
import Factory.FactoryCarros;
import Observer.Sujeito;

import java.util.*;
import java.util.Locale;

public class RepositorioCarros /*implements CRUDCarros*/ extends Sujeito {

    protected Collection<Carro> carros;

    public RepositorioCarros(){
        carros = new ArrayList<>();
    }

    public void create(Carro T){
        carros.add(T);
        System.out.println("Carro cadastrado com sucesso");
    }

    public void read(String marca, String modelo){

        boolean flag = false;

        for (Carro carro : carros) {
            if (carro.getMarca().toLowerCase(Locale.ROOT).equals(marca.toLowerCase(Locale.ROOT)) &&
                    carro.getModelo().toLowerCase(Locale.ROOT).equals(modelo.toLowerCase(Locale.ROOT))) {
                flag = true;
                System.out.printf("%1s%10s%15s%20s%25s\n",
                        carro.getMarca(),
                        carro.getModelo(),
                        carro.getValor(),
                        carro.getAnoLancamento(),
                        carro.getPrecoAVista());
            }
        }
        if(!flag){
            System.out.printf("%1s%10s%15s%20s%25s\n","X","X","X","X","X");
            System.out.println("Carro não existe");
        }
    }

    public void update(Carro antigo, Carro novo){
        if(carros.contains(antigo) && antigo != null){
            antigo.setModelo(novo.getModelo());
            antigo.setAnoLancamento(novo.getAnoLancamento());
            antigo.setValor(novo.getValor());
            System.out.println("Carro atualizado");

            notificar(); // vai notificar os sujeitos

        }else{
            System.out.println("Carro não existe, impossível atualizar");
        }

    }
    public void delete(String marca, String modelo){
        FactoryCarros factory = FactoryCarros.getInstance();

        int id = 1; //Fiat
        if(marca.equals("Ferrari")){
            id = 2;
        }

        Carro c = factory.getClass(id);
        boolean flag = false;
        if(carros.isEmpty()){
            System.out.println("Não há carros para remover");
        }else{
            for (Carro carro : carros) {
                if (carro.getMarca().toLowerCase(Locale.ROOT).equals(marca.toLowerCase(Locale.ROOT)) &&
                        carro.getModelo().toLowerCase(Locale.ROOT).equals(modelo.toLowerCase(Locale.ROOT))) {
                    c = carro;
                    flag = true;
                }
            }
        }
        if(flag && !carros.isEmpty()){
            carros.remove(c);
            System.out.println("----------------------------DELETADO------------------------------------");
            System.out.printf("%1s%10s%15s%20s\n","Marca","Modelo","Valor","Ano Lançamento");
            System.out.printf("%1s%10s%15s%20s\n",
                    c.getMarca(),
                    c.getModelo(),
                    c.getValor(),
                    c.getAnoLancamento());
        }else{
            System.out.println("Impossível deletar: Carro não existe");
        }
    }

    public void seeAll(){

        System.out.println("-------------------------------TODOS--------------------------------------");
        System.out.printf("%1s%10s%15s%20s%25s\n","Marca","Modelo","Valor","Ano Lançamento","Preco a Vista");
        for (Carro carro : carros) {
            System.out.printf("%1s%10s%15s%20s%25s\n",
                    carro.getMarca(),
                    carro.getModelo(),
                    carro.getValor(),
                    carro.getAnoLancamento(),
                    carro.getPrecoAVista());

        }
    }

    public Carro searchCarro(String marca, String modelo){
        Carro c = null;
        boolean flag = false;

        for (Carro carro : carros) {
            if (carro.getMarca().toLowerCase(Locale.ROOT).equals(marca.toLowerCase(Locale.ROOT)) &&
                    carro.getModelo().toLowerCase(Locale.ROOT).equals(modelo.toLowerCase(Locale.ROOT))) {
                flag = true;

                c = carro;
            }
        }
        return c;
    }



}
