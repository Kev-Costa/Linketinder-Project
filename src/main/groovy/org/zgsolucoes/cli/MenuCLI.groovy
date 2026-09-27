package org.zgsolucoes.cli

import org.zgsolucoes.model.Candidato
import org.zgsolucoes.model.CompetenciaEnum
import org.zgsolucoes.model.Empresa
import org.zgsolucoes.servicelayer.CandidatoService
import org.zgsolucoes.servicelayer.EmpresaService

class MenuCLI {

    private final CandidatoService candidatoService = new CandidatoService()
    private final EmpresaService empresaService = new EmpresaService()
    private final Scanner scanner = new Scanner(System.in)

    void iniciar(){
        boolean executando = true

        println"""====================================
       BEM-VINDO AO SISTEMA MATCHING
===================================="""

        while (executando) {
            exibirOpcoes()
            print "Escolha uma opçao: "
            String opcao = scanner.nextLine()

            switch (opcao) {
                case "1":
                    candidatoService.exibirCandidatosFormatados()
                    break
                case "2":
                    empresaService.exibirEmpresasFormatadas()
                    break
                case "3":
                    cadastrarNovoCandidato()
                    break
                case "4":
                    cadastrarNovaEmpresa()
                    break
                case "0":
                    println "\nSaindo do sistema..."
                    executando = false
                    break
                default:
                    println "\nOpcao invalida! Digite uma opcao entre (0 a 4)"
            }

            if (executando) {
                println "\nPressione ENTER para continuar"
                scanner.nextLine()
            }
        }
    }

    private void exibirOpcoes() {
        println"""------------------------------------
            MENU PRINCIPAL
------------------------------------
1 - Listar Candidatos Pre-cadastrados
2 - Listar Empresas Pre-cadastradas
3 - Cadastrar Novo Candidato
4 - Cadastrar Nova Empresa
0 - Sair
------------------------------------"""
    }

    private void cadastrarNovoCandidato() {
        println "\n--- Cadastrar novo Candidato ---"
        print "Nome: "
        String nome = scanner.nextLine()

        print "E-mail: "
        String email = scanner.nextLine()

        print "CPF: "
        String cpf = scanner.nextLine()

        print "Idade: "
        int idade = scanner.nextLine().toInteger()

        print "Estado (UF): "
        String estado = scanner.nextLine()

        print "CEP: "
        String cep = scanner.nextLine()

        print "Descriçao: "
        String descricao = scanner.nextLine()

        List<CompetenciaEnum> competencias = [CompetenciaEnum.GROOVY, CompetenciaEnum.JAVA]

        def novoCandidato = new Candidato(
                nome: nome,
                email: email,
                cpf: cpf,
                idade: idade,
                estado: estado,
                cep: cep,
                descricao: descricao,
                competencias: competencias
        )

        try {
            candidatoService.cadastrarCandidato(novoCandidato)
        } catch (IllegalArgumentException e) {
            println "Erro ao cadastrar candidato: ${e.message}"
        }
    }

    private void cadastrarNovaEmpresa() {
        println "\n--- Cadastrar nova Empresa ---"
        print "Nome: "
        String nome = scanner.nextLine()

        print "E-mail: "
        String email = scanner.nextLine()

        print "CNPJ: "
        String cnpj = scanner.nextLine()

        print "Pais: "
        String pais = scanner.nextLine()

        print "Estado (UF): "
        String estado = scanner.nextLine()

        print "CEP: "
        String cep = scanner.nextLine()

        print "Descriçao: "
        String descricao = scanner.nextLine()

        List<CompetenciaEnum> competencias = [CompetenciaEnum.SPRING_FRAMEWORK, CompetenciaEnum.JAVA]

        def novaEmpresa = new Empresa(
                nome: nome,
                email: email,
                cnpj: cnpj,
                pais: pais,
                estado: estado,
                cep: cep,
                descricao: descricao,
                competencias: competencias
        )

        try {
            empresaService.cadastrarEmpresa(novaEmpresa)
        } catch (IllegalArgumentException e) {
            println "Erro ao cadastrar empresa: ${e.message}"
        }
    }

}
