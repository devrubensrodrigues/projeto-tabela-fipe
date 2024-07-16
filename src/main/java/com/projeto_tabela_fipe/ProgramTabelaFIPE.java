package com.projeto_tabela_fipe;

import com.projeto_tabela_fipe.entities.ProgramPrincipal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgramTabelaFIPE {
    public static void main(String[] args) {
        SpringApplication.run(ProgramTabelaFIPE.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        ProgramPrincipal principal = new ProgramPrincipal();
        principal.principal();
    }
}
