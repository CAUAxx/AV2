package Cientela;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Vou acessar banco mysql!");
        try {
            Processamento proc = new Processamento();
            proc.menu();
        } catch (SQLException e) {
            System.out.println("ERRO DE BANCO! " + e.getMessage());
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.out.println("ARQUIVO NAO ENCONTRADO! " + e.getMessage());
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("ERRO! " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
