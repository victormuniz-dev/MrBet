# 🎲 Mr. Bet — Sistema de Apostas Esportivas

Este projeto foi desenvolvido por mim durante a disciplina de **Laboratório de Programação II (LP2)** do curso de **Bacharelado em Ciência da Computação** na **Universidade Federal de Campina Grande (UFCG)**.

O **Mr. Bet** é um sistema em Java projetado para gerenciar times de futebol, campeonatos e palpites de apostas esportivas[cite: 15, 16]. O sistema permite cadastrar clubes, associá-los a campeonatos com limite de participantes, registrar apostas em colocações e consultar o status geral de apostas efetuadas[cite: 15, 16].

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java[cite: 15, 16]
- **Testes Unitários:** JUnit 5
- **Estruturas de Dados:** `HashMap` e `ArrayList`
- **Paradigma:** Programação Orientada a Objetos (POO)[cite: 16, 17, 18, 19]

---

## 🚀 Funcionalidades

- 🛡️ **Gerenciamento de Times:** Cadastro de clubes com ID único, nome e mascote, além da recuperação e busca de dados[cite: 16, 17].
- 🏆 **Controle de Campeonatos:** Criação de campeonatos com limitação de vagas e inclusão controlada de times[cite: 16, 19].
- 📊 **Verificação de Participação:** Consulta se um time está inscrito em determinado campeonato ou exibição dos campeonatos que disputa[cite: 16].
- 🎯 **Registro de Apostas:** Realização de palpites de colocação e valor para um time em determinado campeonato[cite: 16, 18].
- 📋 **Status das Apostas:** Exibição listada e numerada de todas as apostas registradas[cite: 15, 16].
- 💻 **Interface CLI Interativa:** Menu em modo texto via terminal operado por `Scanner`[cite: 15].

---

## 📦 Estrutura dos Arquivos

O projeto está organizado entre o pacote principal `mrbet` e o pacote de testes `mrbet.tests`[cite: 15, 20]:

| Arquivo | Descrição |
| :--- | :--- |
| **`Time.java`** | Classe que representa o clube (ID, nome, mascote e histórico de campeonatos)[cite: 17]. |
| **`Campeonato.java`** | Classe responsável por gerenciar os dados do torneio e os times inscritos[cite: 19]. |
| **`Aposta.java`** | Representação de uma aposta individual (palpite, valor, time e campeonato)[cite: 18]. |
| **`SistemaMrBet.java`** | Controller principal que gerencia as coleções de dados e valida as regras de negócio[cite: 16]. |
| **`MainMrBet.java`** | Classe principal com a interface de linha de comando (CLI) e menu do sistema[cite: 15]. |
| **`TimeTeste.java`** | Testes unitários para validação de igualdade e representação textual de times[cite: 23]. |
| **`CampeonatoTeste.java`** | Testes para inclusão de times, verificações de presença e `equals` de campeonatos[cite: 21]. |
| **`ApostaTeste.java`** | Testes de integridade da representação textual das apostas[cite: 20]. |
| **`SistemaMrBetTest.java`** | Suíte de testes integrados para validação dos fluxos do sistema (duplicatas, limites de vaga e exceções). |

---

## 💻 Como Executar o Projeto

### Pré-requisitos
- **Java Development Kit (JDK)** versão 8 ou superior.
- Módulo **JUnit 5** (para execução dos testes automatizados).

### Passos para compilar e rodar via Terminal

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/seu-usuario/mr-bet.git](https://github.com/seu-usuario/mr-bet.git)
   cd mr-bet
