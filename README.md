# Seduc Class SEU ASSISTENTE DE SALA DE AULA

Este é o projeto **Seduc Class**, uma solução desenvolvida para auxiliar no gerenciamento de turmas, autenticação de usuários e comunicação entre professores e alunos. O projeto utiliza Java(Spring Boot) para o backend e React Native com Expo para o frontend, distribuído como APK.

## Tecnologias Utilizadas

- **Spring Boot**: Framework utilizado para o desenvolvimento do backend.
- **Postgresql**: Banco de dados utilizado para armazenar informações do sistema.
- **Java**: Linguagem de programação utilizada para backend.
- **React Native**: Framework para o desenvolvimento do aplicativo mobile.
- **Heroku**: Plataforma usada para hospedar o backend.
- **AsyncStorage**: Ferramenta para armazenamento local de dados no aplicativo.

## Funcionalidades

- **Autenticação de Usuários**: Login com CPF e senha, utilizando tokens JWT.
- **Salvar chamada**: Marcar alunos presentes e faltantes e salvar a chamada.
- **Conteudo ministrado**: Salvar e se necessario atualizar o conteudo ministrado.
- **Gerenciamento de Turmas**: Organização e consulta de informações sobre turmas e alunos.

## Como Rodar o Projeto

### Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas:<br>

- Git: Para controle de versão do código.
- Node.js e npm: Para o frontend React Native.
- Java (versão 17 ou superior): Para o backend Spring Boot.
- Heroku CLI: Para fazer deploy no Heroku.
- Expo CLI: Para rodar o aplicativo React Native.
- Maven instalado (para gerenciar as dependências do backend).
- Postman ou Insominia: Para testes das requisições
- Android Studio: Para emular o projeto

### Passos

1. Clonando o Repositório

Clone o repositório do GitHub e acesse o diretório com o seguinte comando:<br>

  ```bash
  git clone https://github.com/seu-usuario/my-app.git
  cd my-app
  ```

2. Configure o banco de dados no arquivo application.properties:

  ```bash
  spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco
  spring.datasource.username=seu_usuario
  spring.datasource.password=sua_senha
  spring.jpa.hibernate.ddl-auto=update
  ```

3. Configuração do Backend (Spring Boot)

  3.1. Dependências e Configuração Inicial<br>
    - O backend foi desenvolvido usando o Spring Boot. Para rodar o servidor backend, é necessário:<br>
        - Instalar o Java 17: Caso não tenha, baixe e instale a versão mais recente do Java a partir do site oficial do Java.<br>
        - Instalar o Maven: Maven é usado para gerenciar dependências e construir o projeto. Instale-o a partir do site oficial do Maven ou usando um gerenciador de pacotes como Homebrew no macOS ou Chocolatey no Windows.

  3.2. Rodando o Backend Localmente<br>
    - Navegue até o diretório do backend (onde o código do Spring Boot está localizado).
    - Verifique as configurações do banco de dados no arquivo application.properties (ou application.yml):

  3.3. Rodando o Backend:

- Caso o Maven esteja instalado corretamente, rode o seguinte comando para executar o backend:

      ```bash
      mvn spring-boot:run
      ```

    - O servidor Spring Boot será iniciado na porta 8080. Você pode acessar a API localmente em http://localhost:8080.
    - Teste da API: Verifique se o backend está funcionando corretamente acessando o endpoint de login, por exemplo, em http://localhost:8080/auth/login.

  3.4. Deploy no Heroku
    - Criar um App no Heroku:
    - Caso ainda não tenha o aplicativo no Heroku, crie um novo aplicativo no site da propria heroku e conecte o seu github para que ele possa acessar o repositorio onde você salvou seu backend

    - Se o aplicativo já estiver configurado no Git, basta adicionar o repositório remoto do Heroku e fazer o push:<br>

    git remote add heroku https://git.heroku.com/nome-do-app.git<br>
    git push heroku master<br>

    - Após o deploy, o Heroku fornecerá um endereço URL para acessar sua API online (exemplo: https://nome-do-app.herokuapp.com).<br>

4. Configuração do Frontend (React Native)<br>
  4.1. Dependências e Configuração Inicial<br>

    - instalar Node.js e npm:<br>

    - Caso ainda não tenha, baixe e instale o Node.js aqui.<br>
    - Instalar o Expo CLI: Expo é uma ferramenta para desenvolver e rodar aplicativos React Native de forma simples.<br>

    - Instale o Expo CLI globalmente com:
  
    ```bash
    npm install -g expo-cli
    ```

  4.2. Rodando o Frontend Localmente
    - Instalar as dependências do frontend:

    - No diretório do frontend (onde o código React Native está localizado), instale as dependências com o npm:

    ```bash
    npm install
    ```
    - Rodar o aplicativo:

    - Para rodar o aplicativo no seu dispositivo ou no emulador, use o comando:

    ```bash
    npx expo start
    ```

    - Isso abrirá o Expo DevTools no seu navegador e permitirá que você execute o aplicativo no seu dispositivo físico com o código QR ou em um emulador Android/iOS.<br>

5. Configuração da URL do Backend no Frontend:<br>

  - No arquivo TelaLogin.tsx, certifique-se de que a URL do backend está configurada corretamente. Por exemplo:<br>
    ```bash
    async function getLogin() {
      try {
        if (!CPF || !Senha) {
          return Alert.alert('Atenção!', 'Informe os campos obrigatórios!');
        }

    setIsLoading(true);a

    const response = await fetch('http://192.168.1.70:8080/auth/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        cpf: CPF,
        senha: Senha,
      }),
    });

    if (response.ok) {
      const data = await response.json();
      await AsyncStorage.setItem('token', data.token);

      Alert.alert('Sucesso', 'Login realizado com sucesso');
      navigation.navigate('PainelInicial');
      
    else {
      const errorMessage = await response.text();
      Alert.alert('Erro', 'CPF ou senha incorretos. Tente novamente.');
      
    }
    
      } catch (error) {
        Alert.alert('Erro', 'Não foi possível conectar ao servidor. Verifique sua conexão.');
        console.log('Erro de conexão:', error);
          }
        }
      }
    ```

5. Instalação e Execução do Frontend<

  - O frontend foi desenvolvido com React Native e gerado como APK. Para instalar e executar no dispositivo Android, siga os passos abaixo:

  5.1. Gerar o APK para Android:
    - Execute o comando abaixo para gerar o APK de produção:

    ```bash
    eas build --platform android
    ```

  5.2. Instale o APK no dispositivo Android:

  - Copie o APK para o dispositivo.
  - Ative a instalação de aplicativos de fontes desconhecidas no Android:
  - Acesse Configurações > Segurança > Fontes desconhecidas e habilite a opção.
  - Clique no arquivo APK e siga as instruções para instalação.

  5.3. Execute o aplicativo:

  - Após a instalação, o aplicativo estará disponível na lista de aplicativos do dispositivo.
  - Abra o aplicativo, insira as credenciais (CPF e senha) e teste a funcionalidade.

## Estrutura do Projeto
```bash
Front-end:

/my-app
  ├── /.expo
  ├── /assets
  ├── /node_modules
  ├── /src
  │     ├── /@types
  │     │     ├── png.d.ts
  │     ├── /global
  │     │     ├── themes.tsx
  │     ├── /pages                        # Telas do aplicativo
  │     │     ├── /Chamada
  │     │     │     ├── TelaChamada.tsx
  │     │     ├── /Horário
  │     │     │     ├── HorarioAulas.tsx
  │     │     ├── /list
  │     │     │     ├── PainelInicial.tsx
  │     │     ├── /login
  │     │     │     ├── TelaLogin.tsx
  │     ├── /routes
  │     │     ├── index.routes.tsx
  ├── .gitignore
  ├── app.json
  ├── App.tsx                     # Arquivo principal do aplicativo
  ├── babel.config.js
  ├── eas.json
  ├── gesture-handler.js
  ├── gesture-handler.native.js
  ├── package-lock.json
  ├── package.json                # Gerenciamento de dependências npm
  ├── README.md                   # Documentação do projeto
  └── tsconfig.json
```
```bash
BACK END:

/my-app-back
  ├── /src/main/java                                        # Código fonte do backend
  │     ├── /com.seducapp.gerenciadordeaulas
  │     │     ├── GerenciadordeaulasApplication.java
  │     ├── /com.seducapp.gerenciadordeaulas.config
  │     │     ├── TestConfig.java
  │     ├── /com.seducapp.gerenciadordeaulas.controller
  │     │     ├── AuthController.java
  │     │     ├── ChamadaController.java
  │     │     ├── ConteudoMinistradoControler.java
  │     │     ├── HorarioController.java
  │     ├── /com.seducapp.gerenciadordeaulas.dto
  │     │     ├── AlunoPresencaDTO.java
  │     │     ├── AuthRequest.java
  │     │     ├── AuthResponse.java
  │     │     ├── ChamadaResponseDTO.java
  │     │     ├── ConteudoMinistradoRequestDTO.java
  │     │     ├── ConteudoMinistradoResponseDTO.java
  │     │     ├── HorarioDTO.java
  │     │     ├── LoginDTO.java
  │     │     ├── PresencaAlunoDTO.java
  │     │     ├── RealizarChamadaRequestDTO.java
  │     ├── /com.seducapp.gerenciadordeaulas.enums
  │     │     ├── Dia_semana.java
  │     │     ├── Grau_ensino.java
  │     │     ├── ModalidadesEnum.java
  │     │     ├── Tipo_usuario.java
  │     ├── /com.seducapp.gerenciadordeaulas.model
  │     │     ├── Aluno.java
  │     │     ├── Chamada.java
  │     │     ├── Conteudo_ministrado.java
  │     │     ├── Disciplina.java
  │     │     ├── Horario.java
  │     │     ├── Modalidades.java
  │     │     ├── Professor.java
  │     │     ├── Serie.java
  │     │     ├── Turma_disciplina.java
  │     │     ├── Turma.java
  │     │     ├── TurmaDisciplinaId.java
  │     │     ├── Usuario.java
  │     ├── /com.seducapp.gerenciadordeaulas.repository
  │     │     ├── AlunoRepository.java
  │     │     ├── ChamadaRepository.java
  │     │     ├── Conteudo_ministradoRepository.java
  │     │     ├── DisciplinaRepository.java
  │     │     ├── HorarioRepository.java
  │     │     ├── ModalidadesRepository.java
  │     │     ├── ProfessorRepository.java
  │     │     ├── SerieRepository.java
  │     │     ├── Turma_disciplinaRepository.java
  │     │     ├── TurmaRepository.java
  │     │     ├── UsuarioRepository.java
  │     ├── /com.seducapp.gerenciadordeaulas.security
  │     │     ├── CustomUserDetailsService.java
  │     │     ├── JwtAuthenticationFilter.java
  │     │     ├── JwtConfig.java
  │     │     ├── JwtTokenProvider.java
  │     │     ├── SecurityConfig.java
  │     ├── /com.seducapp.gerenciadordeaulas.services
  │     │     ├── AlunoService.java
  │     │     ├── ChamadaService.java
  │     │     ├── Conteudo_ministradoService.java
  │     │     ├── DisciplinaService.java
  │     │     ├── HorarioService.java
  │     │     ├── ModalidadesService.java
  │     │     ├── ProfessorService.java
  │     │     ├── SerieService.java
  │     │     ├── TurmaService.java
  │     │     ├── UsuarioService.java
  │     ├── /com.seducapp.gerenciadordeaulas.services.exceptions
  │     │     ├── ResourceNotFoundException.java
  ├── /src/main/resource                                            # Configurações do backend
  │     ├── application.properties                                  # Configurações de banco de dados
  └── pom.xml                                                       # Gerenciamento de dependências Maven
```



6. Conclusão<br>
   
- Agora, seu aplicativo deve estar funcionando tanto no backend quanto no frontend. O backend foi implementado com Spring Boot e está rodando no Heroku, enquanto o frontend foi desenvolvido em React Native usando Expo. 

- Ambos devem estar conectados corretamente.

- Com o APK gerado, você pode instalar o aplicativo diretamente no seu dispositivo Android ou enviá-lo para a Google Play Store se tiver gerado  o AAB.<br>

Se você tiver qualquer problema durante a configuração ou execução, consulte a documentação oficial do Heroku ou Expo.<br>

## Próximas Funcionalidades

- Implementar sistema de esqueceu a senha para usuários.

**# Seduc Class SEU ASSISTENTE DE SALA DE AULA** - Transformando a educação com tecnologia!
