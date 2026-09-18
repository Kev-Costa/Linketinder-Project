package org.zgsolucoes.model

class Candidato extends Pessoa {
    String cpf
    int idade

    @Override
    String getDocumento() {
        return null
    }

    @Override
    String obterResumo() {
        return null
    }
}
