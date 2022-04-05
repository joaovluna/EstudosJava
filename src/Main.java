import Carros.Carro;
import Carros.Ferrari;
import Carros.Fiat;
import Factory.FactoryCarros;
import Repositorio.RepositorioCarros;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        RepositorioCarros fiat = new RepositorioCarros(); // fazer um singleton de agencia ?
        RepositorioCarros ferrari = new RepositorioCarros();

        preenchendoRepositorio(fiat, ferrari);

        int comando = 0;
        String marca;
        Scanner scan = new Scanner(System.in);
        String modelo;
        boolean hibrido;
        int anoLancamento;
        double valor;

        while(comando != 3) {
            System.out.println("-----------------------------------");
            System.out.println("--------------INICIO---------------");
            System.out.println("-----------------------------------");
            System.out.println(" 1 - Fiat \n 2 - Ferrari \n 3 - Sair");
            comando = scan.nextInt();
            FactoryCarros factory = new FactoryCarros(); //factory de carros
            switch(comando) {
                case 1 -> {

                    Carro carro = factory.getClass(comando);

                    System.out.println("---------------------------------");
                    System.out.println("--------------FIAT---------------");
                    System.out.println("---------------------------------");
                    System.out.println("1 - Cadastrar");
                    System.out.println("2 - Pesquisar");
                    System.out.println("3 - Atualizar");
                    System.out.println("4 - Deletar");
                    System.out.println("5 - Voltar");

                    int codFiat = scan.nextInt();

                    System.out.println("\n");
                    fiatCRUD(fiat, scan, carro, codFiat);

                }
                case 2 -> {
                    Carro carro = factory.getClass(comando);
                    System.out.println(carro.getMarca());
                    System.out.println("------------------------------------");
                    System.out.println("--------------FERRARI---------------");
                    System.out.println("------------------------------------");
                    System.out.println("1 - Cadastrar");
                    System.out.println("2 - Pesquisar");
                    System.out.println("3 - Atualizar");
                    System.out.println("4 - Deletar");
                    System.out.println("5 - Voltar");

                    int codFerrari = scan.nextInt();
                    System.out.println("\n");
                    ferrariCRUD(ferrari,scan,carro,codFerrari);
                }
                case 3 -> System.out.println("Saindo...");

                default -> System.out.println("Digito incorreto, tente novamente");
            }
//            System.out.flush();
        }
    }

    private static void preenchendoRepositorio(RepositorioCarros fiat, RepositorioCarros ferrari) {
        Carro c1 = new Fiat();
        c1.setModelo("Doblo98");
        c1.setAnoLancamento(1998);
        c1.setValor(5000.0);
        fiat.create(c1);

        Carro c2 = new Fiat();
        c2.setModelo("Doblo05");
        c2.setAnoLancamento(2005);
        c2.setValor(25000.0);
        fiat.create(c2);

        Carro c3 = new Ferrari();
        c3.setModelo("Fe90");
        c3.setAnoLancamento(1990);
        c3.setValor(250000.0);
        ferrari.create(c3);


        Carro c4 = new Ferrari();
        c4.setModelo("Fe10z");
        c4.setAnoLancamento(2010);
        c4.setValor(850000.0);
        ferrari.create(c4);
    }

    private static void fiatCRUD(RepositorioCarros fiat, Scanner scan, Carro carro, int codFiat) {
        String modelo;
        double valor;
        int anoLancamento;
        switch(codFiat) {
            case 1 -> {
                System.out.println(carro.getMarca());
                System.out.println("1 ----------- ADICIONAR FIAT");
                System.out.print("Modelo: ");
                modelo = scan.next();
                System.out.print("Ano Lançamento: ");
                anoLancamento = scan.nextInt();
                System.out.print("Preço: ");
                valor = scan.nextDouble();

                carro.setModelo(modelo);
                carro.setAnoLancamento(anoLancamento);
                carro.setValor(valor);
                fiat.create(carro);

            }
            case 2 -> {

                System.out.println("2 ----------- PESQUISAR FIAT");
                System.out.println("     1 - Listar todos");
                System.out.println("     2 - Pesquisar modelo");
                int ver = scan.nextInt();
                if(ver == 1){
                    fiat.seeAll();
                }else if(ver == 2){
                    System.out.print("Modelo: ");
                    modelo = scan.next();

                    System.out.printf("%1s%10s%15s%20s%25s\n","Marca","Modelo","Valor","Ano Lançamento","Preco a Vista");
                    fiat.read("Fiat",modelo);
                }else{
                    System.out.println("Digitou errado");
                }

            }
            case 3 -> {
                System.out.println("3  ----------- ATUALIZAR FIAT");
                System.out.println("Informe o modelo que deseja atualizar: ");
                String antigo = scan.next();

                System.out.printf("%1s%10s%15s%20s\n","Marca","Modelo","Valor","Ano Lançamento");
                fiat.read("Fiat",antigo);
                System.out.println();

                System.out.println("Informe as novas informações atualizadas");
                System.out.print("Modelo: ");
                modelo = scan.next();
                System.out.print("Ano Lançamento: ");
                anoLancamento = scan.nextInt();
                System.out.print("Preço: ");
                valor = scan.nextDouble();

                carro.setModelo(modelo);
                carro.setAnoLancamento(anoLancamento);
                carro.setValor(valor);

                fiat.update(fiat.searchCarro("Fiat",antigo), carro);

            }
            case 4 -> {
                System.out.println("4  ----------- DELETAR FIAT");
                System.out.println("Informe o modelo que deseja deletar: ");
                modelo = scan.next();
                fiat.delete("Fiat", modelo);

            }
            default -> System.out.println("\n\n");

        }
    }

    private static void ferrariCRUD(RepositorioCarros ferrari, Scanner scan, Carro carro, int codFerrari) {
        String modelo;
        double valor;
        int anoLancamento;
        switch(codFerrari) {
            case 1 -> {
                System.out.println(carro.getMarca());
                System.out.println("1 ----------- ADICIONAR FERRARI");
                System.out.print("Modelo: ");
                modelo = scan.next();
                System.out.print("Ano Lançamento: ");
                anoLancamento = scan.nextInt();
                System.out.print("Preço: ");
                valor = scan.nextDouble();

                carro.setModelo(modelo);
                carro.setAnoLancamento(anoLancamento);
                carro.setValor(valor);
                ferrari.create(carro);

            }
            case 2 -> {

                System.out.println("2 ----------- PESQUISAR FERRARI");
                System.out.println("     1 - Listar todos");
                System.out.println("     2 - Pesquisar modelo");
                int ver = scan.nextInt();
                if(ver == 1){
                    ferrari.seeAll();
                }else if(ver == 2){
                    System.out.print("Modelo: ");
                    modelo = scan.next();

                    System.out.printf("%1s%10s%15s%20s%25s\n","Marca","Modelo","Valor","Ano Lançamento","Preco a Vista");
                    ferrari.read("Ferrari",modelo);
                }else{
                    System.out.println("Digitou errado");
                }

            }
            case 3 -> {
                System.out.println("3  ----------- ATUALIZAR FERRARI");
                System.out.println("Informe o modelo que deseja atualizar: ");
                String antigo = scan.next();

                System.out.printf("%1s%10s%15s%20s\n","Marca","Modelo","Valor","Ano Lançamento");
                ferrari.read("Ferrari",antigo);
                System.out.println();

                System.out.println("Informe as novas informações atualizadas");
                System.out.print("Modelo: ");
                modelo = scan.next();
                System.out.print("Ano Lançamento: ");
                anoLancamento = scan.nextInt();
                System.out.print("Preço: ");
                valor = scan.nextDouble();

                carro.setModelo(modelo);
                carro.setAnoLancamento(anoLancamento);
                carro.setValor(valor);

                ferrari.update(ferrari.searchCarro("Ferrari",antigo), carro);

            }
            case 4 -> {
                System.out.println("4  ----------- DELETAR FERRARI");
                System.out.println("Informe o modelo que deseja deletar: ");
                modelo = scan.next();
                ferrari.delete("Ferrari", modelo);

            }
            default -> System.out.println("\n\n");

        }
    }

}
