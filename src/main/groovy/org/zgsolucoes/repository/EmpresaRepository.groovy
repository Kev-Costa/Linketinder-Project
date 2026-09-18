package org.zgsolucoes.repository

import org.zgsolucoes.model.CompetenciaEnum
import org.zgsolucoes.model.Empresa

class EmpresaRepository {
    private List<Empresa> empresas = [
            new Empresa(
                    nome: "Tech Solutions",
                    email: "contato@techsolutions.com",
                    cnpj: "12.345.678/0001-90",
                    pais: "Brasil",
                    estado: "SP",
                    cep: "01310-100",
                    descricao: "Empresa focada em soluçoes corporativas em Java",
                    competencias: [CompetenciaEnum.JAVA, CompetenciaEnum.SPRING_FRAMEWORK]
            ),
            new Empresa(
                    nome: "Data Analytics Brasil",
                    email: "rh@dataanalytics.com.br",
                    cnpj: "98.765.432/0001-10",
                    pais: "Brasil",
                    estado: "RJ",
                    cep: "20010-020",
                    descricao: "Consultoria focada em automaçao e dados com Python",
                    competencias: [CompetenciaEnum.PYTHON]
            ),
            new Empresa(
                    nome: "WebFront Digital",
                    email: "vagas@webfront.com",
                    cnpj: "11.222.333/0001-44",
                    pais: "Brasil",
                    estado: "MG",
                    cep: "30140-071",
                    descricao: "Agencia web focada no desenvolvimento de interfaces modernas"
            ),
            new Empresa(
                    nome: "DevGroovy Corp",
                    email: "carreiras@devgroovy.io",
                    cnpj: "55.666.777/0001-88",
                    pais: "Brasil",
                    estado: "PR",
                    cep: "80020-300",
                    descricao: "Sistemas modernos utilizando automaç~ao na JVM com Groovy",
                    competencias: [CompetenciaEnum.GROOVY, CompetenciaEnum.JAVA]
            ),
            new Empresa(
                    nome: "Global Cloud Systems",
                    email: "jobs@globalcloud.com",
                    cnpj: "77.888.999/0001-22",
                    pais: "Brasil",
                    estado: "SP",
                    cep: "04571-010",
                    descricao: "Multinacional expandindo time de backend na America Latina",
                    competencias: [CompetenciaEnum.JAVA, CompetenciaEnum.SPRING_FRAMEWORK, CompetenciaEnum.PYTHON]
            )
    ]

    List<Empresa> buscarTodos() {
        empresas
    }

    void adicionar(Empresa empresa) {
        empresas.add(empresa)
    }

}
