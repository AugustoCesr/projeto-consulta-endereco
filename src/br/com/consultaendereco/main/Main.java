package br.com.consultaendereco.main;

import br.com.consultaendereco.service.ConsultaCep;
import br.com.consultaendereco.model.GeradorDeArquivo;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaCep consultaCep = new ConsultaCep();
        GeradorDeArquivo gerador = new GeradorDeArquivo();

        while (true) {
            System.out.println("\nDigite o seu CEP (ou digite 'Sair' para encerrar): ");
            String cep = scanner.nextLine();

            if (cep.equalsIgnoreCase("sair")) {
                break;
            }

            consultaCep.buscarEndereco(cep).ifPresentOrElse(
                    endereco -> {
                        System.out.println(endereco);

                        try {
                            gerador.salvaJson(endereco);
                            System.out.println("\n*Arquivo JSON com o endereço foi salvo*");
                        } catch (IOException e) {
                            System.out.println(String.format("\n*Erro ao salvar o arquivo JSON: %s*", e.getMessage()));
                        }
                    },
                    () -> System.out.println(String.format("Não consegui obter o endereço a partir desse CEP: %s", cep)));
        }

        System.out.println("\nEncerrando...");
        scanner.close();
    }
}
