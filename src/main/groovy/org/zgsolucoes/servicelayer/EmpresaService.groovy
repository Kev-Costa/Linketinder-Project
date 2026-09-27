package org.zgsolucoes.servicelayer

import org.zgsolucoes.model.Empresa
import org.zgsolucoes.repository.EmpresaRepository

class EmpresaService {

    private EmpresaRepository empresaRepository = new EmpresaRepository()

    List<Empresa> listarTodas() {
        empresaRepository.buscarTodos()
    }

    void exibirEmpresasFormatadas() {
        List<Empresa> empresas = listarTodas()

        if (empresas.isEmpty()) {
            println "Nenhuma empresa cadastrada"
        }

        println """==============================
                        LISTA DE EMPRESAS
                   =============================="""

        empresas.eachWithIndex{ empresa, index ->
            println """---- Empresa #${index + 1} ----
                    Nome: ${empresa.nome}
                    CNPJ: ${empresa.cnpj}
                    E-mail Corporativo: ${empresa.email}
                    Localizaçao: ${empresa.estado}, ${empresa.pais} (CEP: ${empresa.cep}
                    Descriçao: ${empresa.descricao}"""

            def listaCompetencias = empresa.competencias*.nomeExibicao.join(", ")
            println "Comptencias Esperadas: [${listaCompetencias}]"
        }
    }

    void cadastrarEmpresa(Empresa novaEmpresa) {

        if (novaEmpresa == null) {
            throw new IllegalArgumentException("A empresa nao pode ser nula")
        }
        if (novaEmpresa.nome == null || novaEmpresa.nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da empresa e obrigatorio")
        }

        empresaRepository.adicionar(novaEmpresa)
    }

}
