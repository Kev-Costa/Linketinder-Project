import { StorageService } from '../services/StorageService';
import { CompetenciaEnum } from '../models/Interfaces';

document.getElementById('form-cad-cand')?.addEventListener('submit', (e) => {
    e.preventDefault();

    const nome = (document.getElementById('nome') as HTMLInputElement).value;
    const email = (document.getElementById('email') as HTMLInputElement).value;
    const senha = (document.getElementById('senha') as HTMLInputElement).value;
    const cpf = (document.getElementById('cpf') as HTMLInputElement).value;
    const idade = Number((document.getElementById('idade') as HTMLInputElement).value);
    const formacao = (document.getElementById('formacao') as HTMLInputElement).value;
    const estado = (document.getElementById('estado') as HTMLInputElement).value;
    const cep = (document.getElementById('cep') as HTMLInputElement).value;
    const descricao = (document.getElementById('descricao') as HTMLInputElement).value;

    StorageService.salvarCandidato({
        id: Date.now().toString(),
        nome, email, senha, cpf, idade, formacao, estado, cep, descricao,
        competencias: [CompetenciaEnum.JAVA, CompetenciaEnum.GROOVY]
    });

    alert('Cadastro realizado com sucesso! Efetue login para continuar.');
    window.location.href = 'login.html';
});