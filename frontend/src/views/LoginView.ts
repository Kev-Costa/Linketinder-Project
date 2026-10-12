import { StorageService } from '../services/StorageService';

// Função global injetada no window para ser chamada direto pelo HTML
(window as any).fazerLogin = () => {
    const emailInput = document.getElementById('email') as HTMLInputElement;
    const senhaInput = document.getElementById('senha') as HTMLInputElement;

    if (!emailInput || !senhaInput) {
        alert('Campos de e-mail ou senha não encontrados.');
        return;
    }

    const email = emailInput.value.trim();
    const senha = senhaInput.value.trim();

    if (!email || !senha) {
        alert('Por favor, preencha o e-mail e a senha.');
        return;
    }

    // 1. Validar Candidatos
    const candidatos = StorageService.getCandidatos();
    const candidatoEncontrado = candidatos.find(c => c.email === email && c.senha === senha);

    if (candidatoEncontrado) {
        StorageService.setUsuarioLogado({
            id: candidatoEncontrado.id,
            nome: candidatoEncontrado.nome,
            tipo: 'candidato'
        });
        window.location.href = 'candidato.html';
        return;
    }

    // 2. Validar Empresas
    const empresas = StorageService.getEmpresas();
    const empresaEncontrada = empresas.find(emp => emp.email === email && emp.senha === senha);

    if (empresaEncontrada) {
        StorageService.setUsuarioLogado({
            id: empresaEncontrada.id,
            nome: empresaEncontrada.nome,
            tipo: 'empresa'
        });
        window.location.href = 'empresa.html';
        return;
    }

    // 3. Caso não encontre
    alert('E-mail ou senha incorretos. Utilize as credenciais de teste indicadas na tela.');
};