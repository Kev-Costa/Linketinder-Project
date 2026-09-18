package org.zgsolucoes.model

abstract class Pessoa implements IPessoa {
    String nome
    String email
    String estado
    String cep
    String descricao

    List<CompetenciaEnum> competencias = []

    void adicionarCompetencia(CompetenciaEnum competencia) {
        if (competencia && !competencias.contains(competencia)) {
            competencias.add(competencia)
        }
    }

}
