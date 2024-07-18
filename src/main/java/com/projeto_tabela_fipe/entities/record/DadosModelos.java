package com.projeto_tabela_fipe.entities.record;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public record DadosModelos(List<DadosMarcas> modelos, List<DadosMarcas> anos) {
}
