import { Candidato, Empresa } from '../models/Interfaces';
export declare class StorageService {
    private static candidatosKey;
    private static empresasKey;
    private static usuarioLogadoKey;
    static getCandidatos(): Candidato[];
    static salvarCandidato(candidato: Candidato): void;
    static deletarCandidato(id: string): void;
    static getEmpresas(): Empresa[];
    static salvarEmpresa(empresa: Empresa): void;
    static setUsuarioLogado(usuario: {
        id: string;
        nome: string;
        tipo: 'candidato' | 'empresa';
    }): void;
    static getUsuarioLogado(): {
        id: string;
        nome: string;
        tipo: 'candidato' | 'empresa';
    } | null;
    static logout(): void;
}
//# sourceMappingURL=StorageService.d.ts.map