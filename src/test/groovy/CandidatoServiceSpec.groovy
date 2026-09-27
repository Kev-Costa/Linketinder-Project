import org.zgsolucoes.model.Candidato
import org.zgsolucoes.model.CompetenciaEnum
import org.zgsolucoes.servicelayer.CandidatoService
import spock.lang.Specification

class CandidatoServiceSpec extends Specification {

    CandidatoService candidatoService

    def setup() {
        candidatoService = new CandidatoService()
    }

    def "deve adicionar um novo candidato com sucesso e aumentar a lista"() {
        given: "um repositorio inicializando com 5 candidatos pre-cadastrados"
        int tamanhoInicial = candidatoService.listarTodos().size()

        and: "um novo candidato valido"
        def novoCandidato = new Candidato(
                nome: "Lucas Ferreira",
                email: "lucas@email.com",
                cpf: "999.888.777-66",
                idade: 25,
                estado: "SP",
                cep: "01000-000",
                descricao: "Dev Groovy",
                competencias: [CompetenciaEnum.GROOVY]
        )

        when: "o novo candidato e cadastrado"
        candidatoService.cadastrarCandidato(novoCandidato)

        then: "a quantidade total de candidatos deve ser incrementada em 1"
        candidatoService.listarTodos().size() == tamanhoInicial + 1

        and: "o novo candidato deve estar contido na lista"
        candidatoService.listarTodos().contains(novoCandidato)
    }

    def "deve lançar IllegalArgumentException ao tentar cadastrar candidato nulo"() {
        when: "tenta cadastra um candidato nulo"
        candidatoService.cadastrarCandidato()

        then: "deve capturar a exceçao de argumento invalido"
        thrown(IllegalArgumentException)
    }

    def "Lança uma exceçao quando o nome do candiato esta vazio"() {
        given: "Candidato com nome em banco"
        def candidatoInvalido = new Candidato(nome: "", email: "teste@email.com")

        when: "tenta cadastrar"
        candidatoService.cadastrarCandidato(candidatoInvalido)

        then: "deve capturar a exceçao"
        thrown(IllegalArgumentException)
    }
}
