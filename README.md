# AppGestao Back-end

Este é o repositório do back-end em Spring Boot para o painel administrativo do aplicativo de gestão (AppGestao).

O front-end correspondente deste aplicativo pode ser encontrado no repositório [AppGestao-Front](https://github.com/leonardols10/AppGestao-Front).

## Pré-requisitos

- Java 11 ou superior
- Maven

## Configuração

Siga as instruções abaixo para configurar o ambiente de desenvolvimento e executar o back-end localmente.

1. Clone este repositório para o seu diretório local:
git clone https://github.com/leonardols10/AppGestao-Back.git

2. Navegue até o diretório do projeto:
cd AppGestao-Back

3. Compile o projeto usando o Maven:
mvn clean install

## Executando o back-end

Após a compilação, você pode executar o back-end usando o seguinte comando:
mvn spring-boot:run


O servidor será iniciado e estará disponível em `http://localhost:8080`.

## Banco de Dados

Este projeto utiliza o banco de dados H2 em tempo de execução e o conector MySQL em tempo de execução.

## API Endpoints

A API do back-end possui os seguintes endpoints:

- `GET /api/chamados`: Retorna todos os chamados registrados.
- `POST /api/chamados`: Cria um novo chamado.
- `GET /api/chamados/{id}`: Retorna um chamado específico pelo seu ID.
- `PUT /api/chamados/{id}`: Atualiza um chamado existente.
- `DELETE /api/chamados/{id}`: Exclui um chamado existente.

Consulte o código fonte para obter mais detalhes sobre a implementação desses endpoints.

## Segurança

Este projeto utiliza o Spring Security para a segurança da API. Ele possui autenticação baseada em token JWT (JSON Web Token). Certifique-se de configurar corretamente as propriedades de segurança no arquivo `application.properties`.

## Front-end

O front-end correspondente deste aplicativo pode ser encontrado no repositório [AppGestao-Front](https://github.com/leonardols10/AppGestao-Front). Certifique-se de configurar e iniciar o front-end antes de utilizar este aplicativo.

## Contribuição

Se você encontrar problemas, bugs ou tiver sugestões para melhorias, sinta-se à vontade para abrir uma "issue" neste repositório. Ficaremos felizes em receber contribuições da comunidade.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).
