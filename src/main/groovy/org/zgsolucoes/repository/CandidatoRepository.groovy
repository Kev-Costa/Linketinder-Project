package org.zgsolucoes.repository

import org.zgsolucoes.model.Candidato
import org.zgsolucoes.model.CompetenciaEnum

class CandidatoRepository {
    private List<Candidato> candidatos = [
            new Candidato(
                    nome: "Ana Souza",
                    email: "ana.souza@email.com",
                    cpf: "111.222.333-44",
                    idade: 24,
                    estado: "SP",
                    cep: "01000-000",
                    descricao: "Desenvolvedora focada em backend e APIs",
                    competencias: [CompetenciaEnum.JAVA, CompetenciaEnum.SPRING_FRAMEWORK]
            ),
            new Candidato(
                    nome: "Bruno Lima",
                    email: "bruno.lima@email.com",
                    cpf: "222.333.444-55",
                    idade: 29,
                    estado: "RJ",
                    cep: "2000-000",
                    descricao: "Desenvolvedor Fullstack com foco em interfaces",
                    competencias: [CompetenciaEnum.PYTHON, CompetenciaEnum.ANGULAR]
            ),
            new Candidato(
                    nome: "Carla Mendes",
                    email: "carla.mendes@email.com",
                    cpf: "333.444.555-66",
                    idade: 22,
                    estado: "MG",
                    cep: "30000-000",
                    descricao: "Entusiasta de automaçao e scripts em Groovy",
                    competencias: [CompetenciaEnum.GROOVY, CompetenciaEnum.JAVA]
            ),
            new Candidato(
                    nome: "Diego Rocha",
                    email: "diego.rocha@email.com",
                    cpf: "444.555.666-77",
                    idade: 31,
                    estado: "PR",
                    cep: "8000-000",
                    descricao: "Especialista em ecossitema Spring e microsserviços",
                    competencias: [CompetenciaEnum.SPRING_FRAMEWORK, CompetenciaEnum.JAVA]
            ),
            new Candidato(
                    nome: "Eduarda Costa",
                    email: "eduarda.costa@email.com",
                    cpf: "555.666.777-88",
                    idade: 26,
                    estado: "SC",
                    cep: "88000-000",
                    descricao: "Desenvolvedora Python voltada para analise de dados",
                    competencias: [CompetenciaEnum.PYTHON]
            )
    ]

    List<Candidato> buscarTodos(){
        candidatos
    }

    void adicionar(Candidato candidato) {
        candidatos.add(candidato)
    }
}
