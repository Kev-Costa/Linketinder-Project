import { Candidato, Empresa, CompetenciaEnum } from '../models/Interfaces';

export class StorageService {
    private static candidatosKey = "linketinder_candidatos";
    private static empresasKey = "linketinder_empresas";
    private static usuarioLogadoKey = "linketinder_usuario_logado";

    static getCandidatos(): Candidato[] {
        const data = localStorage.getItem(this.candidatosKey);
        if (!data) {
            const initial: Candidato[] = [
                {
                    id: "1",
                    nome: "Lucas Silva",
                    email: "candidato@email.com",
                    senha: "123",
                    cpf: "111.111.111-11",
                    idade: 25,
                    estado: "SP",
                    cep: "01000-000",
                    descricao: "Dev Backend",
                    formacao: "Análise de Sistemas",
                    competencias: [CompetenciaEnum.JAVA, CompetenciaEnum.GROOVY]
                },
                {
                    id: "2",
                    nome: "Mariana Souza",
                    email: "mariana@email.com",
                    senha: "123",
                    cpf: "222.222.222-22",
                    idade: 28,
                    estado: "RJ",
                    cep: "20000-000",
                    descricao: "Dev Fullstack",
                    formacao: "Ciência da Computação",
                    competencias: [CompetenciaEnum.JAVA, CompetenciaEnum.SPRING_FRAMEWORK]
                }
            ];
            localStorage.setItem(this.candidatosKey, JSON.stringify(initial));
            return initial;
        }

        // Converte e garante que registros antigos tenham senha preenchida
        const candidatos: Candidato[] = JSON.parse(data);
        return candidatos.map(c => ({
            ...c,
            senha: c.senha || "123"
        }));
    }

    static salvarCandidato(candidato: Candidato): void {
        const list = this.getCandidatos();
        list.push(candidato);
        localStorage.setItem(this.candidatosKey, JSON.stringify(list));
    }

    static deletarCandidato(id: string): void {
        let list = this.getCandidatos();
        list = list.filter(c => c.id !== id);
        localStorage.setItem(this.candidatosKey, JSON.stringify(list));
    }

    static getEmpresas(): Empresa[] {
        const data = localStorage.getItem(this.empresasKey);
        if (!data) {
            const initial: Empresa[] = [
                {
                    id: "e1",
                    nome: "MegaSystems",
                    email: "empresa@email.com",
                    senha: "123",
                    cnpj: "00.000.000/0001-00",
                    pais: "Brasil",
                    estado: "SP",
                    cep: "04000-000",
                    descricao: "Tech Provider",
                    competencias: [CompetenciaEnum.JAVA, CompetenciaEnum.GROOVY],
                    vagas: [{
                        titulo: "Dev Groovy Pleno",
                        descricao: "Atuar com backend robusto",
                        competenciasDesejadas: [CompetenciaEnum.GROOVY, CompetenciaEnum.JAVA]
                    }],
                    matchRealizado: false
                }
            ];
            localStorage.setItem(this.empresasKey, JSON.stringify(initial));
            return initial;
        }

        // Converte e garante que empresas antigas tenham senha preenchida
        const empresas: Empresa[] = JSON.parse(data);
        return empresas.map(e => ({
            ...e,
            senha: e.senha || "123"
        }));
    }

    static salvarEmpresa(empresa: Empresa): void {
        const list = this.getEmpresas();
        list.push(empresa);
        localStorage.setItem(this.empresasKey, JSON.stringify(list));
    }

    static setUsuarioLogado(usuario: { id: string; nome: string; tipo: 'candidato' | 'empresa' }): void {
        localStorage.setItem(this.usuarioLogadoKey, JSON.stringify(usuario));
    }

    static getUsuarioLogado(): { id: string; nome: string; tipo: 'candidato' | 'empresa' } | null {
        const data = localStorage.getItem(this.usuarioLogadoKey);
        return data ? JSON.parse(data) : null;
    }

    static logout(): void {
        localStorage.removeItem(this.usuarioLogadoKey);
    }
}