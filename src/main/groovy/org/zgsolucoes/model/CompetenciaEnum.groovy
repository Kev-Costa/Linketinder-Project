package org.zgsolucoes.model

enum CompetenciaEnum {
    PYTHON("Python"),
    JAVA("Java"),
    SPRING_FRAMEWORK("Spring Framework"),
    ANGULAR("Angular"),
    GROOVY("Groovy")

    final String nomeExibicao

    CompetenciaEnum(String nomeExibicao) {
        this.nomeExibicao = nomeExibicao
    }
}