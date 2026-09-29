import org.zgsolucoes.model.CompetenciaEnum
import org.zgsolucoes.model.Empresa
import org.zgsolucoes.service.EmpresaService
import spock.lang.Specification

class EmpresaServiceSpec extends Specification {

    EmpresaService empresaService

    def setup() {
        empresaService = new EmpresaService()
    }

    def "Adiciona nova empresa e aumenta a lista"() {
        given: "repositorio iniciado com 5 empresas pre-cadastradas"
        int tamanhoInicial = empresaService.listarTodas().size()

        and: "uma nova empresa valida"
        def novaEmpresa = new Empresa(
                nome: "MegaSystems Provider",
                email: "work@magasystems.com",
                cnpj: "88.999.010/0001-33",
                pais: "BR",
                estado: "MG",
                descricao: "Provedora de sistemas bancarios e de ciberseguranca",
                competencias: [CompetenciaEnum.JAVA, CompetenciaEnum.SPRING_FRAMEWORK, CompetenciaEnum.PYTHON]
        )

        when: "nova empresa cadastrada"
        empresaService.cadastrarEmpresa(novaEmpresa)

        then: "a quantidade total de empresas e incrementada em 1"
        empresaService.listarTodas().size() == tamanhoInicial + 1

        and: "o novo candidato deve estar contido na lista"
        empresaService.listarTodas().contains(novaEmpresa)
    }

    def "deve lancar IllegalArgumentException ao tentar cadastrar empresa nula"() {
        when: "tenta cadastrar uma empresa nula"
        empresaService.cadastrarEmpresa()

        then: "deve capturar a exceçao/argumento invalido"
        thrown(IllegalArgumentException)
    }

    def "Lança uma exception para um empresa com nome vazio"(){
        given: "Empresa com nome em banco"
        def empresaInvalida = new Empresa(nome: "", email: "teste@email.com")

        when: "tenta cadastrar"
        empresaService.cadastrarEmpresa(empresaInvalida)

        then: "deve capturar a exceçao"
        thrown(IllegalArgumentException)
    }

}
