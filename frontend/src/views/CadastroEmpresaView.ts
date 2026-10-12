import { StorageService } from '../services/StorageService';
import { CompetenciaEnum } from '../models/Interfaces';

document.getElementById('form-cad-emp')?.addEventListener('submit', (e) => {
    e.preventDefault();

    const nome = (document.getElementById('nome') as HTMLInputElement).value;
    const email = (document.getElementById('email') as HTMLInputElement).value;
    const cnpj = (document.getElementById('cnpj') as HTMLInputElement).value;
    const pais = (document.getElementById('pais') as HTMLInputElement).value;
    const estado = (document.getElementById('estado') as HTMLInputElement).value;
    const cep = (document.getElementById('cep') as HTMLInputElement).value;
    const descricao = (document.getElementById('descricao') as HTMLInputElement).value;

    StorageService.salvarEmpresa({
        id: Date.now().toString(),
        nome, email, cnpj, pais, estado, cep, descricao,
        competencias: [CompetenciaEnum.SPRING_FRAMEWORK],
        vagas: [{
            titulo: 'Desenvolvedor Fullstack',
            descricao: 'Vaga para atuar em projetos inovadores',
            competenciasDesejadas: [CompetenciaEnum.JAVA]
        }],
        matchRealizado: false
    });

    alert('Empresa cadastrada com sucesso!');
    window.location.href = 'index.html';
});