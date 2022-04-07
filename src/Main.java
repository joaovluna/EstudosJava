import Carros.Carro;
import Carros.Ferrari;
import Carros.Fiat;
import Clientes.Cliente;
import Factory.FactoryCarros;
import Repositorio.RepositorioCarros;
import Repositorio.RepositorioClientes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        RepositorioClientes repositorioClientes = new RepositorioClientes(); //ja cria alguns clientes, observador certo

        RepositorioClientes observador = new RepositorioClientes(); //observador errado

        RepositorioCarros fiat = new RepositorioCarros();
        RepositorioCarros ferrari = new RepositorioCarros();

        preenchendoRepositorioCarros(fiat, ferrari); //criando alguns carros

        int inicio = 0;
        while (inicio != 3) {
            System.out.println("-----------------------------------");
            System.out.println("--------------INICIO---------------");
            System.out.println("-----------------------------------");
            System.out.println(" 1 - Carro \n 2 - Cliente \n 3 - Sair");
            inicio = scan.nextInt();

            switch (inicio) {

                case 1 -> cadastroCarro(scan, fiat, ferrari, observador, repositorioClientes);

                case 2 -> cadastroCliente(scan, repositorioClientes);

                case 3 -> System.out.println("Saindo...\n\n");

                default -> System.out.println("Digito inválido, porfavor tente novamente\n\n");
            }
        }
    }


    private static void cadastroCliente(Scanner scan, RepositorioClientes repositorioClientes) {

        int comandoCliente = 0;

        while (comandoCliente != 5) {

            System.out.println("---------------------------------");
            System.out.println("-------------CLIENTE--------------");
            System.out.println("---------------------------------");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Pesquisar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Deletar");
            System.out.println("5 - Voltar");

            comandoCliente = scan.nextInt();

            clienteCRUD(scan, repositorioClientes, comandoCliente);
        }
    }

    private static void clienteCRUD(Scanner scan, RepositorioClientes repositorioClientes, int comandoCliente) {
        int idade;
        String email;
        String id;
        String nome;
        switch (comandoCliente) {
            case 1 -> {
                Cliente cliente = new Cliente();
                System.out.println("1 ----------- ADICIONAR CLIENTE");
                System.out.print("Nome: ");
                nome = scan.next();
                System.out.print("ID: ");
                id = scan.next();
                System.out.print("Idade: ");
                idade = scan.nextInt();
                System.out.print("Email:");
                email = scan.next();

                cliente.setNome(nome);
                cliente.setId(id);
                cliente.setIdade(idade);
                cliente.setEmail(email);

                repositorioClientes.create(cliente);

                System.out.println("Cliente cadastrado com sucesso");
            }

            case 2 -> {
                System.out.println("2 ----------- PESQUISAR CLIENTE");
                System.out.println("     1 - Listar todos");
                System.out.println("     2 - Pesquisar por ID");

                int ver = scan.nextInt();

                if (ver == 1) {
                    repositorioClientes.seeAll();
                } else if (ver == 2) {
                    System.out.print("Cliente ID: ");
                    id = scan.next();

                    System.out.printf("%1s%10s%15s%20s\n", "Nome", "ID", "Idade", "Email");
                    repositorioClientes.read(id);
                } else {
                    System.out.println("Digitou errado");
                }
            }
            case 3 -> {
                Cliente atualizado = new Cliente();
                System.out.println("3  ----------- ATUALIZAR CLIENTE");
                System.out.println("Informe o Cliente que deseja atualizar, informe o ID: ");
                String antigo = scan.next();

                System.out.printf("%1s%10s%15s%20s\n", "Nome", "ID", "Idade", "Email");
                repositorioClientes.read(antigo);
                System.out.println();

                System.out.println("Informe as novas informações atualizadas");
                System.out.print("Nome: ");
                nome = scan.next();
                System.out.print("ID: ");
                id = scan.next();
                System.out.print("Idade: ");
                idade = scan.nextInt();
                System.out.print("Email: ");
                email = scan.next();

                atualizado.setNome(nome);
                atualizado.setId(id);
                atualizado.setIdade(idade);
                atualizado.setEmail(email);

                repositorioClientes.update(repositorioClientes.searchCliente(antigo), atualizado);
            }
            case 4 -> {
                System.out.println("4  ----------- DELETAR CLIENTE");
                System.out.println("Informe o ID do Cliente que deseja deletar: ");
                id = scan.next();
                repositorioClientes.delete(id);
            }
            case 5 -> System.out.println("Saindo de Clientes...\n\n");

            default -> System.out.println("Digito inválido, porfavor tente novamente\n\n");
        }
    }


    private static void cadastroCarro(Scanner scan, RepositorioCarros fiat, RepositorioCarros ferrari, RepositorioClientes observador, RepositorioClientes repositorioCliente) {
        int comandoCarro = 0;

        while (comandoCarro != 3) {
            System.out.println("-----------------------------------");
            System.out.println("--------------CARRO---------------");
            System.out.println("-----------------------------------");
            System.out.println(" 1 - Fiat \n 2 - Ferrari \n 3 - Voltar");

            comandoCarro = scan.nextInt();

            FactoryCarros factory;//factory de carros com singleton

            factory = FactoryCarros.getInstance();

            switch (comandoCarro) {
                case 1 -> {

                    Carro carro = factory.getClass(comandoCarro);
                    carro.addObservador(repositorioCliente); //ADICIONANDO OBSERVADOR
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

                    fiatCRUD(fiat, scan, carro, codFiat, repositorioCliente);

                }
                case 2 -> {
                    Carro carro = factory.getClass(comandoCarro);

                    carro.addObservador(observador);

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

                    ferrariCRUD(ferrari, scan, carro, codFerrari);
                }
                case 3 -> System.out.println("Saindo de Carros...\n\n");

                default -> System.out.println("Digito incorreto, tente novamente\n\n");
            }
//            System.out.flush();
        }
    }

    private static void fiatCRUD(RepositorioCarros fiat, Scanner scan, Carro carro, int codFiat, RepositorioClientes repositorioCliente) {
        String modelo;
        double valor;
        int anoLancamento;
        switch (codFiat) {
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

                System.out.println("Carro cadastrado com sucesso");
                repositorioCliente.seeAll();

            }
            case 2 -> {

                System.out.println("2 ----------- PESQUISAR FIAT");
                System.out.println("     1 - Listar todos");
                System.out.println("     2 - Pesquisar modelo");
                int ver = scan.nextInt();
                if (ver == 1) {
                    fiat.seeAll();
                } else if (ver == 2) {
                    System.out.print("Modelo: ");
                    modelo = scan.next();

                    System.out.printf("%1s%10s%15s%20s%25s\n", "Marca", "Modelo", "Valor", "Ano Lançamento", "Preco a Vista");
                    fiat.read("Fiat", modelo);
                } else {
                    System.out.println("Digitou errado");
                }

            }
            case 3 -> {
                System.out.println("3  ----------- ATUALIZAR FIAT");
                System.out.println("Informe o modelo que deseja atualizar: ");
                String antigo = scan.next();

                System.out.printf("%1s%10s%15s%20s%25s\n", "Marca", "Modelo", "Valor", "Ano Lançamento","Valor a Vista");
                fiat.read("Fiat", antigo);
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

                fiat.update(fiat.searchCarro("Fiat", antigo), carro);

            }
            case 4 -> {
                System.out.println("4  ----------- DELETAR FIAT");
                System.out.println("Informe o modelo que deseja deletar: ");
                modelo = scan.next();
                fiat.delete("Fiat", modelo);

            }
            case 5 -> System.out.println("Saindo de Fiat... \n\n");
            default -> System.out.println("Digito incorreto, gentileza tentar novamente\n\n");

        }
    }

    private static void ferrariCRUD(RepositorioCarros ferrari, Scanner scan, Carro carro, int codFerrari) {
        String modelo;
        double valor;
        int anoLancamento;
        switch (codFerrari) {
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
                System.out.println("Carro cadastrado com sucesso");

            }
            case 2 -> {

                System.out.println("2 ----------- PESQUISAR FERRARI");
                System.out.println("     1 - Listar todos");
                System.out.println("     2 - Pesquisar modelo");
                int ver = scan.nextInt();
                if (ver == 1) {
                    ferrari.seeAll();
                } else if (ver == 2) {
                    System.out.print("Modelo: ");
                    modelo = scan.next();

                    System.out.printf("%1s%10s%15s%20s%25s\n", "Marca", "Modelo", "Valor", "Ano Lançamento", "Preco a Vista");
                    ferrari.read("Ferrari", modelo);
                } else {
                    System.out.println("Digitou errado");
                }

            }
            case 3 -> {
                System.out.println("3  ----------- ATUALIZAR FERRARI");
                System.out.println("Informe o modelo que deseja atualizar: ");
                String antigo = scan.next();

                System.out.printf("%1s%10s%15s%20s%25s\n", "Marca", "Modelo", "Valor", "Ano Lançamento", "Valor a vista");
                ferrari.read("Ferrari", antigo); // retornar se existe ou nao, ferrari.searchCarro("Ferrari",antigo)
                System.out.println();                 // quando digita um carro que nao existe ele da sequencia e so avisa depois, ajeitar isso dps
                //nao dar sequencia se carro nao existir
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

                ferrari.update(ferrari.searchCarro("Ferrari", antigo), carro);

            }
            case 4 -> {
                System.out.println("4  ----------- DELETAR FERRARI");
                System.out.println("Informe o modelo que deseja deletar: ");
                modelo = scan.next();
                ferrari.delete("Ferrari", modelo);

            }
            case 5 -> {
                System.out.println("Saindo de Ferrari...\n\n");
            }
            default -> System.out.println("Digito invalido, tente novamente\n\n");

        }
    }

    private static void preenchendoRepositorioCarros(RepositorioCarros fiat, RepositorioCarros ferrari) {
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


}
