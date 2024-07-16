package com.projeto_tabela_fipe.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.projeto_tabela_fipe.entities.record.DadosMarcas;
import com.projeto_tabela_fipe.service.API;
import com.projeto_tabela_fipe.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramPrincipal {

    private Scanner sc = new Scanner(System.in);
    private API consumoAPI = new API();
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    private ConverteDados converteDados = new ConverteDados();
    public void principal() throws JsonProcessingException {

        System.out.print("Digite para pesquisar por carros, motos ou caminhoes: ");
        String tipoVeiculo = sc.nextLine();

        List<DadosMarcas> listDadosMarcas = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            String json = consumoAPI.consultaAPI(ENDERECO + tipoVeiculo.toLowerCase() + "/marcas");
            DadosMarcas dadosMarcas = converteDados.obterDados(json, DadosMarcas.class);
            listDadosMarcas.add(dadosMarcas);
        }

        listDadosMarcas.forEach(System.out::println);
    }
}
