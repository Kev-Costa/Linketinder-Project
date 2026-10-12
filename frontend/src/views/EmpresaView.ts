import { StorageService } from '../services/StorageService';
import { Candidato, CompetenciaEnum } from '../models/Interfaces';

// Proteção de Rota
const usuarioLogado = StorageService.getUsuarioLogado();
if (!usuarioLogado || usuarioLogado.tipo !== 'empresa') {
    alert('Acesso restrito a empresas!');
    window.location.href = 'login.html';
}

export class EmpresaView {
    static init(): void {
        const header = document.querySelector('h2');
        if (header && usuarioLogado) {
            header.innerText = `Painel Corporativo — ${usuarioLogado.nome}`;
        }
        this.renderizarTabelaCandidatos();
        this.renderizarGrafico();
    }

    static renderizarTabelaCandidatos(): void {
        const tbody = document.getElementById('tabela-candidatos-empresa');
        if (!tbody) return;

        const candidatos: Candidato[] = StorageService.getCandidatos();
        tbody.innerHTML = '';

        if (candidatos.length === 0) {
            tbody.innerHTML = `<tr><td colspan="4" style="text-align: center; color: #666;">Nenhum candidato cadastrado.</td></tr>`;
            return;
        }

        candidatos.forEach((cand: Candidato, index: number) => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
        <td><b>Candidato #${index + 1}</b> (Anônimo)</td>
        <td>${cand.formacao}</td>
        <td>
            <span class="tooltip-trigger">
                Ver Skills (${cand.competencias.length})
                <div class="tooltip-content">
                    <b>Skills:</b> ${cand.competencias.join(', ')}<br>
                    <b>Estado:</b> ${cand.estado}<br>
                    <b>Descrição:</b> ${cand.descricao}
                </div>
            </span>
        </td>
        <td>
            <button class="danger" onclick="window.deletarCandidato('${cand.id}')">Excluir</button>
        </td>
      `;
            tbody.appendChild(tr);
        });
    }

    static renderizarGrafico(): void {
        const container = document.getElementById('grafico-competencias');
        if (!container) return;

        const candidatos: Candidato[] = StorageService.getCandidatos();
        const contagemSkills: { [key: string]: number } = {};

        // Conta quantos candidatos possuem cada competência
        candidatos.forEach((c: Candidato) => {
            if (c.competencias) {
                c.competencias.forEach((skill: CompetenciaEnum) => {
                    contagemSkills[skill] = (contagemSkills[skill] || 0) + 1;
                });
            }
        });

        container.innerHTML = '';
        const keys = Object.keys(contagemSkills);

        if (keys.length === 0) {
            container.innerHTML = `<p style="text-align: center; width: 100%; color: #666; line-height: 220px;">Sem dados suficientes para gerar o gráfico.</p>`;
            return;
        }

        keys.forEach((skill: string) => {
            const total = contagemSkills[skill] || 0;
            const barra = document.createElement('div');
            barra.className = 'bar';
            // Altura proporcional baseada na quantidade (mínimo de altura para visualização)
            barra.style.height = `${Math.max(total * 40, 30)}px`;
            barra.innerHTML = `<span><b>${total}</b></span><div style="font-size:11px; margin-top:8px; color:#333; font-weight:600;">${skill}</div>`;
            container.appendChild(barra);
        });
    }

    static deletar(id: string): void {
        if (confirm('Deseja realmente excluir este candidato da plataforma?')) {
            StorageService.deletarCandidato(id);
            this.renderizarTabelaCandidatos();
            this.renderizarGrafico();
        }
    }
}

// Injeção de funções globais para eventos de clique do DOM
(window as any).deletarCandidato = (id: string) => EmpresaView.deletar(id);

document.addEventListener('DOMContentLoaded', () => {
    EmpresaView.init();
});
