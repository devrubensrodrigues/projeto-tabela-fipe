package com.projeto_tabela_fipe.principal;

import com.projeto_tabela_fipe.entities.record.DadosMarcas;
import com.projeto_tabela_fipe.entities.record.DadosModelos;
import com.projeto_tabela_fipe.service.API;
import com.projeto_tabela_fipe.service.ConverteDados;

import java.util.Comparator;
import java.util.Scanner;

public class ProgramPrincipal {

    private Scanner sc = new Scanner(System.in);
    private API consumoAPI = new API();
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private ConverteDados converteDados = new ConverteDados();
    public void principal() {

        System.out.print("Digite para pesquisar por carros, motos ou caminhoes: ");
        String tipoVeiculo = sc.nextLine();

        if(tipoVeiculo.toLowerCase().contains("car")) {
            tipoVeiculo = "carros";
        }else if(tipoVeiculo.toLowerCase().contains("mot")) {
            tipoVeiculo = "motos";
        }else {
            tipoVeiculo = "caminhoes";
        }

        var json = consumoAPI.consultaAPI(URL_BASE + tipoVeiculo + "/marcas");

        var marcas = converteDados.obterLista(json, DadosMarcas.class);
        marcas.stream()
                .sorted(Comparator.comparing(DadosMarcas::codigo))
                .forEach(System.out::println);

        System.out.println("Informe o código da marca que você quer pesquisar");
        var codigo = sc.nextLine();

        json = consumoAPI.consultaAPI(URL_BASE + tipoVeiculo + "/marcas/" + codigo + "/modelos");

        var tipos = converteDados.obterDados(json, DadosModelos.class);

        System.out.println(tipos);
        System.out.println("\nModelos dessa marca: ");
        tipos.modelos().stream()
                .sorted(Comparator.comparing(DadosMarcas::nome))
                .forEach(System.out::println);

    }
}
