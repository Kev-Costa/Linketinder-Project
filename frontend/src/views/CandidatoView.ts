import { StorageService } from '../services/StorageService';
import { Empresa, Vaga } from '../models/Interfaces';

// Proteção de Rota
const usuarioLogado = StorageService.getUsuarioLogado();
if (!usuarioLogado || usuarioLogado.tipo !== 'candidato') {
    alert('Acesso restrito a candidatos!');
    window.location.href = 'login.html';
}

export class CandidatoView {
    static init(): void {
        const header = document.querySelector('h2');
        if (header && usuarioLogado) {
            header.innerText = `Painel do Candidato — Olá, ${usuarioLogado.nome}`;
        }
        this.renderizarVagas();
    }

    static renderizarVagas(): void {
        const tbody = document.getElementById('tabela-vagas-candidato');
        if (!tbody) return;

        const empresas: Empresa[] = StorageService.getEmpresas();
        tbody.innerHTML = '';

        let totalVagas = 0;

        empresas.forEach((empresa) => {
            if (empresa.vagas && empresa.vagas.length > 0) {
                empresa.vagas.forEach((vaga: Vaga) => {
                    totalVagas++;
                    const tr = document.createElement('tr');
                    tr.innerHTML = `
            <td><b>${empresa.nome}</b> (${empresa.estado})</td>
            <td>${vaga.titulo}</td>
            <td>${vaga.descricao}</td>
            <td>
              <span class="tooltip-trigger">
                Ver Skills (${vaga.competenciasDesejadas.length})
                <div class="tooltip-content">
                  <b>Desejadas:</b> ${vaga.competenciasDesejadas.join(', ')}
                </div>
              </span>
            </td>
          `;
                    tbody.appendChild(tr);
                });
            }
        });

        if (totalVagas === 0) {
            tbody.innerHTML = `<tr><td colspan="4" style="text-align: center; color: #666;">Nenhuma vaga cadastrada no momento.</td></tr>`;
        }
    }
}

document.addEventListener('DOMContentLoaded', () => {
    CandidatoView.init();
});