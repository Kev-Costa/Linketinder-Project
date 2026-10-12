export declare enum CompetenciaEnum {
    JAVA = "Java",
    GROOVY = "Groovy",
    SPRING_FRAMEWORK = "Spring Framework",
    PYTHON = "Python",
    JAVASCRIPT = "JavaScript"
}
export interface Candidato {
    id: string;
    nome: string;
    email: string;
    senha?: string;
    cpf: string;
    idade: number;
    estado: string;
    cep: string;
    descricao: string;
    formacao: string;
    competencias: CompetenciaEnum[];
}
export interface Vaga {
    titulo: string;
    descricao: string;
    competenciasDesejadas: CompetenciaEnum[];
}
export interface Empresa {
    id: string;
    nome: string;
    email: string;
    senha?: string;
    cnpj: string;
    pais: string;
    estado: string;
    cep: string;
    descricao: string;
    competencias: CompetenciaEnum[];
    vagas: Vaga[];
    matchRealizado?: boolean;
}
//# sourceMappingURL=Interfaces.d.ts.map