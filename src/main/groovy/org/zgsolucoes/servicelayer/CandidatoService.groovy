package org.zgsolucoes.servicelayer

import org.zgsolucoes.model.Candidato
import org.zgsolucoes.repository.CandidatoRepository

class CandidatoService {

    private CandidatoRepository candidatoRepository = new CandidatoRepository()

    List<Candidato> listarTodos() {
        candidatoRepository.buscarTodos()
    }

    void exibirCandidatosFormatados() {
        List<Candidato> candidatos = listarTodos()

        if (candidatos.isEmpty()) {
            println "Nenhum candidato cadastrado"
        }

        println """===========================
                        LISTA DE CANDIDATOS  
                   ==========================="""

        candidatos.eachWithIndex { candidato, index ->
            println """---- Candidato #${index + 1} ----
                    Nome: ${candidato.nome}
                    CPF: ${candidato.cpf} | Idade: ${candidato.idade} anos
                    E-mail: ${candidato.email}
                    Localizaçao: ${candidato.estado} (CEP: ${candidato.cep})
                    Descriçao: ${candidato.descricao}"""

            def listaCompetencias = candidato.competencias*.nomeExibicao.join(", ")
            println "Competencias: [${listaCompetencias}]"
        }
    }

    void cadastrarCandidato(Candidato novoCandidato) {

        if (novoCandidato == null) {
            throw new IllegalArgumentException("O candidato nao pode ser nulo")
        }
        if (novoCandidato.nome == null || novoCandidato.nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do candidato 'e obrigatorio")
        }

        candidatoRepository.adicionar(novoCandidato)
    }

}
