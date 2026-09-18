package org.zgsolucoes

import org.zgsolucoes.servicelayer.CandidatoService
import org.zgsolucoes.servicelayer.EmpresaService


class Main {

    static void main(String[] args) {

        CandidatoService candidatoService = new CandidatoService()
        EmpresaService empresaService = new EmpresaService()

        Scanner scanner = new Scanner(System.in)
        boolean executando = true

        println """=======================================
                BEM-VINDO AO SISTEMA DE MATCHING
              ======================================="""

        while (executando) {
            exibirMenu()
            print "Escolha uma opçao: "

            String opcao = scanner.nextLine()

            switch (opcao) {
                case "1":
                    candidatoService.exibirCandidatosFormatados()
                    break
                case "2":
                    empresaService.exibirEmpresasFormatadas()
                    break
                case "0":
                    println "Saindo do sistema... Ate logo"
                    executando = false
                    break
                default:
                    println: "Opçao invalida! Tente novamente"
                    break
            }

            if (executando) {
                println "Pressione ENTER para continuar..."
                scanner.nextLine()
            }
        }

        scanner.close()
    }

    private static void exibirMenu() {
        println """------------------------------------
                            MENU PRINCIPAL
                   ------------------------------------
                   1 - Listar Candidatos Pre-cadastrados"
                   2 - Listar Empresas Pre-cadastradas
                   0 - Sair
                   ------------------------------------         
"""
    }
}