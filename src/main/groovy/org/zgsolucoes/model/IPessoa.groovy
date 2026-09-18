package org.zgsolucoes.model

interface IPessoa {
    String getNome()
    String getDocumento()
    List<CompetenciaEnum> getCompetencias()
    String obterResumo()
}