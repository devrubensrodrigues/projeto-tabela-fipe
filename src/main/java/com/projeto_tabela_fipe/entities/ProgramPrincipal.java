package com.projeto_tabela_fipe.entities;

import com.projeto_tabela_fipe.service.API;

import java.util.Scanner;

public class ProgramPrincipal {

    private Scanner sc = new Scanner(System.in);
    private API consumoAPI = new API();
    private String endereco = "https://parallelum.com.br/fipe/api/v1/";
    public void principal() {

        System.out.print("Digite para pesquisar por carros, motos ou caminhoes: ");
        String tipoVeiculo = sc.nextLine();
        consumoAPI.consultaAPI(endereco + tipoVeiculo + "/marcas");
    }
}
