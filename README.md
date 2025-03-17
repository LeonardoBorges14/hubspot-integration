# Hubspot integration
Por: Leonardo Borges

## Demonstração do Projeto

Gravei um vídeo mostrando toda a execução do projeto. Assista para entender melhor como utilizá-lo:

[▶️ Assista ao vídeo](https://www.youtube.com/watch?v=I4qGdAp6WBQ)

O projeto foi hospedado e pode ser acessado pelo seguinte URL:

[HubSpot Integration - Swagger UI](https://hubspot-integration-leonardo.onrender.com/swagger-ui/index.html#/)

**Obs:** Este projeto está hospedado em uma plataforma gratuita, portanto, pode demorar cerca de 1 ou 2 minutos para carregar na primeira vez que for acessado. Isso é normal devido às restrições do serviço gratuito.

Além disso, o projeto pode ser executado localmente. No entanto, o disparo do webhook pode apresentar erros, pois o HubSpot aceita apenas URLs com HTTPS. Por isso, foi necessário hospedar o projeto em um servidor. Caso queira rodar o projeto localmente é necessário seguir os passos a seguir:

## Configuração e Execução do Projeto

### Requisitos

Antes de iniciar, certifique-se de ter instalado:

- Java 17+
- Maven
- PostgreSQL (ou outra base compatível)

### Configuração das Variáveis de Ambiente

O projeto requer algumas variáveis de ambiente para funcionar corretamente. Defina-as antes de iniciar a aplicação:

**Obs:** Os campos referentes ao banco de dados podem ser preenchidos com algum banco próprio local, porém já hospedei um banco postgresql em um servidor externo para facilitar o processo

```sh
DATABASE_URL=jdbc:postgresql://dpg-cvbbtutsvqrc73c5ko70-a.oregon-postgres.render.com:5432/hubspot_integration
DATABASE_USERNAME=hubspot_integration_user
DATABASE_PASSWORD=6kg1SQZQX1gKLN65L6UsYd3Hq3JSRfnM
HUBSPOT_APP_ID=9280844
HUBSPOT_CLIENT_ID=32279544-d78b-4556-a8f4-846d2592fbce
HUBSPOT_CLIENT_SECRET=4b6ae9b5-8768-437f-af04-4908ef2e291a
HUBSPOT_REDIRECT_URI=http://localhost:8080
HUBSPOT_OPTIONAL_SCOPE=crm.objects.contacts.write
HUBSPOT_AUTH_SCOPE=oauth crm.objects.contacts.read
HUBSPOT_AUTH_GRANT_TYPE=authorization_code
HUBSPOT_AUTH_API_URL=https://app.hubspot.com/oauth/authorize
```
---
### Compilação e Execução

Para executar o projeto em uma IDE como IntelliJ IDEA, siga os passos abaixo:

1. **Faça o pull do projeto:**
   - Crie uma pasta no computador e abra um terminal dentro dessa pasta.
   - Execute o comando ```git init```
   - Execute o comando ```git pull https://github.com/LeonardoBorges14/hubspot-integration.git```

2. **Importar o projeto:**
   - Abra o IntelliJ IDEA.
   - Clique em **Open** e selecione a pasta do projeto.
   - Aguarde o IntelliJ carregar as dependências do Maven automaticamente.

3. **Configurar as variáveis de ambiente:**
   - No IntelliJ, vá até **Run → Edit Configurations**.
   - Crie uma nova configuração de execução do tipo **Application**.
   - No campo **Environment Variables**, adicione as variáveis de ambiente necessárias, conforme listado na seção anterior.

4. **Executar a aplicação:**
   - Certifique-se de que a classe principal do Spring Boot está configurada corretamente.
   - Clique no botão de **Run** (ou pressione `Shift + F10`).
   - Aguarde até que o servidor seja iniciado e os logs indiquem que a aplicação está rodando.
   - Acesse o swagger com a documentação da api por meio da URL http://localhost:8080/swagger-ui/index.html#/
---

## Uso da API

A API possui os seguintes endpoints, que devem ser executados na ordem correta:

### 1. Obter URL de Autorização

**Endpoint:** `GET /authentication/authorization-url`

**Descrição:** Esse endpoint retorna uma URL do HubSpot. É necessário copir e colar essa URL no navegador para autorizar a aplicação. Após a autorização, o HubSpot redireciona para uma URL de exemplo com um parâmetro preenchido que é o código de autorização, que deve ser copiado. Você será redirecionado para uma URL parecida com http://localhost:8080/?code=na1-e792-a182-4f7f-85ec-45cd0c687208&state=null, onde nesse caso o código que deve ser copiado é na1-e792-a182-4f7f-85ec-45cd0c687208

---

### 2. Callback de Autenticação

**Endpoint:** `POST /authentication/callback`

**Descrição:** Esse endpoint recebe o código de autorização gerado pelo HubSpot e obtido por meio da URL do endpoint aterior, que retorna um *access token* e um *refresh token*. O *access token* é necessário para autenticar os próximos endpoints.

---

### 3. Criar um Novo Contato

**Endpoint:** `POST /contacts`

**Autenticação:** Requer o *access token* recebido do endpoint anterior.

**Descrição:** Esse endpoint cria um novo contato no HubSpot. O corpo da requisição deve conter os dados do contato.

**Fluxo do Webhook:** Quando um contato é criado, o HubSpot dispara um webhook automaticamente.

---

### 4. Receber Webhook de Criação de Contato

**Endpoint:** `POST /webhooks/consume/contact-creation`

**Descrição:** Esse endpoint recebe o webhook enviado pelo HubSpot e salva os dados do evento em uma tabela no banco de dados.

---

### 5. Listar Todos os Webhooks Salvos

**Endpoint:** `GET /webhooks`

**Descrição:** Esse endpoint retorna todos os webhooks salvos no banco de dados, junto com a quantidade total registrada.

---

## Bibliotecas usadas

#### 1. Spring Boot Starter Data JPA
**Motivação:** Foi usada para gerenciamento de persistência de dados da entidade de Webhook que precisou ser salva no banco, assim com o uso do Starter Data JPA facilitou muito esse processo.

#### 2. Spring Cloud OpenFeign
**Motivação:** Foi utilizada para fazer a integração com as APIs do HubSpot de forma simples, e foi necessária tanto no processo de geração de token, quanto da criação de contatos.

#### 3. SpringDoc OpenAPI (Swagger)
**Motivação:** A motivação para o uso foi para testar os endpoints de forma mais fácil e também já criar a documentação automática da API.

#### 4. Lombok
**Motivação:** Utilizei para facilitar no processo de desenvolvimento reduzindo códgio, já que com as anotações do lombok, consigo automatizar diversos pontos, como a criação dos métodos getters e setters ou de construtores.

---

## Possíveis Melhorias Futuras

#### 1. Tratamento de Erros
- Implementar um ExceptionHandler centralizado
- Padronizar respostas de erro usando DTOs específicos
- Criar códigos de erro customizados
- Implementar logs estruturados para erros

#### 2. Testes
- Expandir cobertura de testes 
- Adicionar testes de performance
- Implementar testes funcionais

#### 3. Funcionalidades
- Adicionar um front end para na geração de token por exemplo já fazer automático o redirecionamento para a autorização no hubspot e gerar o token de acesso.
- Implementar operações diferentes com contato (Exclusão, Busca por Id, Listagem paginada, Edição)
