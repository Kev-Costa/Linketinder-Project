package org.zgsolucoes.model

class Empresa extends Pessoa {
    String cnpj
    String pais

    @Override
    String getDocumento() {
        return null
    }

    @Override
    String obterResumo() {
        return null
    }
}
