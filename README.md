Passo a Passo para Execução do MVP<br>
1. Pré-requisitos<br>
Antes de começar, certifique-se de ter as seguintes ferramentas instaladas:<br>

Git: Para controle de versão do código.<br>
Node.js e npm (ou yarn): Para o frontend React Native.<br>
Java (versão 8 ou superior): Para o backend Spring Boot.<br>
Heroku CLI: Para fazer deploy no Heroku.<br>
Expo CLI: Para rodar o aplicativo React Native.<br>

2. Clonando o Repositório<br>
Clone o repositório do GitHub com o seguinte comando:<br>
git clone https://github.com/seu-usuario/seu-repositorio.git<br>

Entre no diretório do projeto:<br>
cd seu-repositorio<br>

3. Configuração do Backend (Spring Boot)<br>
3.1. Dependências e Configuração Inicial<br>

O backend foi desenvolvido usando o Spring Boot. Para rodar o servidor backend, é necessário:<br>

- Instalar o Java 8+: Caso não tenha, baixe e instale a versão mais recente do Java a partir do site oficial do Java.<br>

- Instalar o Maven: Maven é usado para gerenciar dependências e construir o projeto. Instale-o a partir do site oficial do Maven ou usando um gerenciador de pacotes como Homebrew no macOS ou Chocolatey no Windows.<br>

3.2. Rodando o Backend Localmente<br>
- Navegue até o diretório do backend (onde o código do Spring Boot está localizado).<br>
- Verifique as configurações do banco de dados no arquivo application.properties (ou application.yml):<br>

Caso esteja usando um banco local, configure os detalhes do banco (exemplo: MySQL, PostgreSQL).<br>
Para o Heroku, o banco pode ser configurado com variáveis de ambiente automaticamente, então não se preocupe em configurar isso localmente, se não estiver utilizando um banco local.<br>
Rodando o Backend:<br>

Caso o Maven esteja instalado corretamente, rode o seguinte comando:<br>
mvn spring-boot:run<br>

- O servidor Spring Boot será iniciado na porta 8080. Você pode acessar a API localmente em http://localhost:8080.<br>
- Teste da API: Verifique se o backend está funcionando corretamente acessando o endpoint de login, por exemplo, em http://localhost:8080/auth/login.<br>

3.3. Deploy no Heroku<br>
- Criar um App no Heroku:<br>
- Caso ainda não tenha o aplicativo no Heroku, crie um novo aplicativo:<br>

heroku create nome-do-app<br>
Deploy do Backend para o Heroku:<br>

Se o aplicativo já estiver configurado no Git, basta adicionar o repositório remoto do Heroku e fazer o push:<br>

git remote add heroku https://git.heroku.com/nome-do-app.git<br>
git push heroku master<br>
Após o deploy, o Heroku fornecerá um endereço URL para acessar sua API online (exemplo: https://nome-do-app.herokuapp.com).<br>

4. Configuração do Frontend (React Native)<br>
4.1. Dependências e Configuração Inicial<br>
Instalar Node.js e npm:<br>

Caso ainda não tenha, baixe e instale o Node.js aqui.<br>
Instalar o Expo CLI: Expo é uma ferramenta para desenvolver e rodar aplicativos React Native de forma simples.<br>

Instale o Expo CLI globalmente com:<br>

npm install -g expo-cli<br>
4.2. Rodando o Frontend Localmente<br>
Instalar as dependências do frontend:<br>

No diretório do frontend (onde o código React Native está localizado), instale as dependências com o npm:<br>

npm install<br>

Rodar o aplicativo:<br>

Para rodar o aplicativo no seu dispositivo ou no emulador, use o comando:<br>

npx expo start<br>
Isso abrirá o Expo DevTools no seu navegador e permitirá que você execute o aplicativo no seu dispositivo físico com o código QR ou em um emulador Android/iOS.<br>

Configuração da URL do Backend no Frontend:<br>

No arquivo TelaLogin.tsx, certifique-se de que a URL do backend está configurada corretamente. Por exemplo:<br>

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

    setIsLoading(false);

    if (response.ok) {
      const data = await response.json();
      await AsyncStorage.setItem('token', data.token);

      Alert.alert('Sucesso', 'Login realizado com sucesso');
      navigation.navigate('PainelInicial');
      
    } //else if (response.status === 401) { POR ALGUM MOTIVO O BACK NÃO ESTA RETORNANDO ERRO 401 QUANDO ERRO A SENHA ELE APARECE ESSA MENSAGEM "Ocorreu um erro inesperado. Tente novamente." OU SEJA O ELSE DE BAIXO
      //Alert.alert('Erro', 'CPF ou senha incorretos. Tente novamente.');//} 
      
      //else { 
      //const errorMessage = await response.text();
      //Alert.alert('Erro', 'Ocorreu um erro inesperado. Tente novamente.');
      //console.log('Erro do backend:', errorMessage); // Log do erro para fins de debug
    //} POR ENQUANDO VOU UTILIZAR ESSE ELSE ABAIXO COM A MENSAGEM DE cpf OU SENHA ERRADOS AINDA QUE NÃO SEJA ERRO 401 PARA CONTINUIDADE DO PROJETO

    else {
      const errorMessage = await response.text();
      Alert.alert('Erro', 'CPF ou senha incorretos. Tente novamente.');
      
    }
    
      } catch (error) {
        Alert.alert('Erro', 'Não foi possível conectar ao servidor. Verifique sua conexão.');
        console.log('Erro de conexão:', error);
      }
    }

5. Deploy do Frontend (Expo) no Heroku ou na Google Play/App Store<br>
O frontend (React Native) geralmente é enviado para a Google Play ou a Apple App Store, mas também pode ser configurado para rodar em um servidor. No caso do Expo, você pode gerar um APK para Android ou um IPA para iOS:<br>

Gerar o APK para Android:<br>
Execute o comando abaixo para gerar o APK de produção:<br>

expo build:android<br>

6. Conclusão<br>
   
- Agora, seu aplicativo deve estar funcionando tanto no backend quanto no frontend. O backend foi implementado com Spring Boot e está rodando no Heroku, enquanto o frontend foi desenvolvido em React Native usando Expo.<br> Ambos devem estar conectados corretamente.<br>

- Com o APK gerado, você pode instalar o aplicativo diretamente no seu dispositivo Android ou enviá-lo para a Google Play Store.<br>

Se você tiver qualquer problema durante a configuração ou execução, consulte a documentação oficial do Heroku ou Expo.<br>
