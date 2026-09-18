# 🚀 Linketinder - Sistema de Matching (MVP) Feito por: KEVIN COSTA DA SILVA

> Aplicação de terminal desenvolvida em **Groovy** e **Gradle** para gerenciar e conectar perfis de candidatos e empresas com base em competências técnicas.

Este projeto foi construído como um **MVP (Minimum Viable Product)** para um programa de estudos, aplicando conceitos de Orientação a Objetos, herança, polimorfismo, enums, coleções idiomáticas do Groovy e a arquitetura em camadas (**Service Layer Pattern**).

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Groovy (v4.0.22)
* **Plataforma:** Java JDK (v17+)
* **Gerenciador de Build:** Gradle
* **IDE Recomendada:** IntelliJ IDEA

---

## 🏗️ Arquitetura do Projeto

O projeto segue a **Arquitetura em Camadas (Service Layer Pattern)**, separando as responsabilidades de domínio, persistência em memória, regras de negócio e apresentação:

```text
src/main/groovy/org/zgsolucoes/
├── app/
│   └── Main.groovy               # Interface de usuário (CLI / Terminal)
├── model/
│   ├── IPessoa.groovy            # Contrato comum para perfis
│   ├── Pessoa.groovy             # Classe base abstrata
│   ├── Candidato.groovy          # Modelo de Pessoa Física (CPF, Idade)
│   ├── Empresa.groovy            # Modelo de Pessoa Jurídica (CNPJ, País)
│   └── CompetenciaEnum.groovy    # Mapeamento de competências técnicas
├── repository/
│   ├── CandidatoRepository.groovy # Persistência em memória (Dados pré-cadastrados)
│   └── EmpresaRepository.groovy   # Persistência em memória (Dados pré-cadastrados)
└── servicelayer/
    ├── CandidatoService.groovy   # Regras de negócio e formatação de Candidatos
    └── EmpresaService.groovy     # Regras de negócio e formatação de Empresas
```
---

## 💻 Funcionalidades do MVP

* [x] **Menu Interativo via Terminal:** Navegação simples e intuitiva para interação com o utilizador.
* [x] **Massa de Dados Pré-cadastrada:** 
  * **5 Candidatos:** Nome, E-mail, CPF, Idade, Estado, CEP, Descrição e Competências.
  * **5 Empresas:** Nome, E-mail Corporativo, CNPJ, País, Estado, CEP, Descrição e Competências Esperadas.
* [x] **Modelagem Orientada a Objetos com Groovy:** Uso de herança, interfaces, *getters/setters* automáticos e métodos utilitários de coleção.

---

## 📋 Pré-requisitos

Antes de iniciar, certifique-se de que tem instalado na sua máquina:

* **Java Development Kit (JDK 17 ou superior)**
* **Git**

> ℹ️ *Nota: Não é necessário ter o Gradle instalado globalmente, pois o projeto utiliza o Gradle Wrapper (`./gradlew`).*

---

## 🚀 Como Executar o Projeto

### 1. Clonar o Repositório

```bash
git clone [https://github.com/Kev-Costa/Linketinder.git](https://github.com/Kev-Costa/Linketinder.git)
cd Linketinder
```

### 2. Executar via Terminal (Linha de Comando)

Você pode executar a aplicação diretamente pelo terminal utilizando o Gradle Wrapper:

#### 🐧 Linux / 🍎 macOS
```bash
./gradlew run --console=plain
```
#### Windows (Command Prompt ou PowerShell)
```cmd
gradlew.bat run --console=plain
```
### 3. Executar via IntelliJ IDEA

1. Abra o **IntelliJ IDEA**.
2. Acesse **File > Open** e selecione a pasta do projeto.
3. Aguarde até que o Gradle sincronize as dependências e monte a estrutura.
4. Navegue no painel esquerdo até `src/main/groovy/org/zgsolucoes/app/Main.groovy`.
5. Clique no ícone de **Play (▶️)** ao lado da classe ou do método `main` para executar.

---

## 📄 Licença

Este projeto foi desenvolvido estritamente para fins educacionais e de aprendizagem prática da linguagem Groovy.
