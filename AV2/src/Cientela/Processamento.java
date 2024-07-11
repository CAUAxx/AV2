package Cientela;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Processamento {

    private ClienteDAO clienteDAO;

    public Processamento() throws SQLException, ClassNotFoundException {
        this.clienteDAO = new ClienteDAO();
    }

    public void menu() throws SQLException, ClassNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Incluir Cliente");
            System.out.println("2. Alterar Cliente");
            System.out.println("3. Excluir Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Carregar Clientes de Arquivo");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    incluirCliente(scanner);
                    break;
                case 2:
                    alterarCliente(scanner);
                    break;
                case 3:
                    excluirCliente(scanner);
                    break;
                case 4:
                    listarClientes();
                    break;
                case 5:
                    System.out.print("Caminho do arquivo: ");
                    String caminhoArquivo = scanner.nextLine();
                    carregarClientesDeArquivo(caminhoArquivo);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void incluirCliente(Scanner scanner) throws SQLException, ClassNotFoundException {
        Cliente cliente = new Cliente();
        System.out.print("Nome: ");
        cliente.setNome(scanner.nextLine());
        System.out.print("CPF: ");
        cliente.setCpf(scanner.nextLine());
        System.out.print("Email: ");
        cliente.setEmail(scanner.nextLine());
        System.out.print("Endereço: ");
        cliente.setEndereco(scanner.nextLine());
        System.out.print("CEP: ");
        cliente.setCep(scanner.nextLine());
        clienteDAO.incluirCliente(cliente);
    }

    private void alterarCliente(Scanner scanner) throws SQLException, ClassNotFoundException {
        System.out.print("CPF do Cliente a ser alterado: ");
        String cpfAlterar = scanner.nextLine();
        Cliente clienteAlterar = new Cliente();
        clienteAlterar.setCpf(cpfAlterar);
        System.out.print("Nome: ");
        clienteAlterar.setNome(scanner.nextLine());
        System.out.print("Email: ");
        clienteAlterar.setEmail(scanner.nextLine());
        System.out.print("Endereço: ");
        clienteAlterar.setEndereco(scanner.nextLine());
        System.out.print("CEP: ");
        clienteAlterar.setCep(scanner.nextLine());
        clienteDAO.alterarCliente(clienteAlterar);
    }

    private void excluirCliente(Scanner scanner) throws SQLException, ClassNotFoundException {
        System.out.print("CPF do Cliente a ser excluído: ");
        String cpfExcluir = scanner.nextLine();
        clienteDAO.excluirCliente(cpfExcluir);
    }

    private void listarClientes() throws SQLException, ClassNotFoundException {
        List<Cliente> clientes = clienteDAO.listarClientes();
        for (Cliente c : clientes) {
            System.out.println(c.imprimeCliente());
        }
    }

    private void carregarClientesDeArquivo(String caminhoArquivo) throws IOException, SQLException, ClassNotFoundException {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha = br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");
                Cliente cliente = new Cliente();
                cliente.setNome(campos[0]);
                cliente.setCpf(campos[1]);
                cliente.setEmail(campos[2]);
                cliente.setEndereco(campos[3]);
                cliente.setCep(campos[4]);
                clienteDAO.incluirCliente(cliente);
            }
        }
    }
}
