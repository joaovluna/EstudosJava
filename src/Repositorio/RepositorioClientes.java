package Repositorio;

import Carros.Carro;
import Clientes.Cliente;
import Observer.Observador;
import Observer.Sujeito;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;

public class RepositorioClientes implements Observador {
    Collection<Cliente> clientes;

    public RepositorioClientes() {
        clientes = new ArrayList<>();
        /*
        * Verificar porque só esses que são criados aqui que recebem a notificacao e os que são criados
        * dps em tempo de execucao não
       */
        Cliente c1 = new Cliente();
        c1.setNome("Joao");
        c1.setId("mtc0001");
        c1.setIdade(23);
        c1.setEmail("joao@email.com");

        Cliente c2 = new Cliente();
        c2.setNome("Maria");
        c2.setId("mtc0002");
        c2.setIdade(20);
        c2.setEmail("maria@email.com");

        Cliente c3 = new Cliente();
        c3.setNome("Jose");
        c3.setId("mtc0003");
        c3.setIdade(35);
        c3.setEmail("jose@email.com");

        create(c1);
        create(c2);
        create(c3);
    }

    public void create(Cliente T) {
        clientes.add(T);

    }

    public void read(String id) {

        boolean flag = false;

        for (Cliente cliente : clientes) {
            if (cliente.getId().toLowerCase(Locale.ROOT).equals(id.toLowerCase(Locale.ROOT))) {
                flag = true;
                System.out.printf("%1s%10s%15s%20s\n",
                        cliente.getNome(),
                        cliente.getId(),
                        cliente.getIdade(),
                        cliente.getEmail());
            }
        }
        if (!flag) {
            System.out.printf("%1s%10s%15s%20s\n", "X", "X", "X", "X");
            System.out.println("Cliente não existe");
        }
    }

    public void update(Cliente antigo, Cliente novo) {
        if (clientes.contains(antigo) && antigo != null) {
            antigo.setNome(novo.getNome());
            antigo.setId(novo.getId());
            antigo.setIdade(novo.getIdade());
            antigo.setEmail(novo.getEmail());
            System.out.println("Cliente atualizado");


        } else {
            System.out.println("Cliente não existe, impossível atualizar");
        }

    }

    public void delete(String id) {
        Cliente c = null;
        boolean flag = false;
        if (clientes.isEmpty()) {
            System.out.println("Não há carros para remover");
        } else {
            for (Cliente cliente : clientes) {
                if (cliente.getId().toLowerCase(Locale.ROOT).equals(id.toLowerCase(Locale.ROOT))) {
                    c = cliente;
                    flag = true;
                }
            }
        }
        if (flag && !clientes.isEmpty()) {
            clientes.remove(c);
            System.out.println("----------------------------DELETADO------------------------------------");
            System.out.printf("%1s%10s%15s%20s\n", "Nome", "ID", "Idade", "Email");
            System.out.printf("%1s%10s%15s%20s\n",
                    c.getNome(),
                    c.getId(),
                    c.getIdade(),
                    c.getEmail());
        } else {
            System.out.println("Impossível deletar: Cliente não existe");
        }
    }

    public void seeAll() {

        System.out.println("-------------------------------TODOS--------------------------------------");
        System.out.printf("%1s%10s%15s%20s\n", "Nome", "ID", "Idade", "Email");
        for (Cliente cliente : clientes) {
            System.out.printf("%1s%10s%15s%20s\n",
                    cliente.getNome(),
                    cliente.getId(),
                    cliente.getIdade(),
                    cliente.getEmail());

        }
        System.out.println("TOTAL CLIENTES: " + clientes.size());
    }

    public Cliente searchCliente(String id) {
        Cliente c = null;
        boolean flag = false;

        for (Cliente cliente : clientes) {
            if (cliente.getId().toLowerCase(Locale.ROOT).equals(id.toLowerCase(Locale.ROOT))) {
                flag = true;

                c = cliente;
            }
        }
        return c;
    }


    @Override
    public void atualizar(Sujeito s) { //informa aos clientes a chegada de novo carro
        Carro acao = (Carro) s;

        notificarClientes(acao);

    }

    private void notificarClientes(Carro acao) {

        System.out.println("-------------------------------NOTIFICA--------------------------------------");

        clientes.forEach(cliente -> { // pq nao vem os clientes que sao cadastrados na linha de comando? so os que estao no construtor que vem
            System.out.println("Enviando para: "+ cliente.getEmail() +
                    " ->> Olá, venha conferir o novo " + acao.getModelo().toUpperCase(Locale.ROOT) +
                    " da " + acao.getMarca().toUpperCase(Locale.ROOT) + " que acabou de chegar");
        });
        System.out.println("\n\n");

//        System.out.println(" Olá, venha conferir o novo "+acao.getModelo().toUpperCase(Locale.ROOT)+" da "+ acao.getMarca().toUpperCase(Locale.ROOT)+" que chegou ");

    }
}
