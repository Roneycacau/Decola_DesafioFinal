# Decola_DesafioFinal

Desafio final do projeto Decola da Iteris

Desafio foi criar uma api com banco de dados SQL Server para servir o site em angular de [outro grupo](https://github.com/victrmart/ticketstore).  

O grupo responsável pelo backend:

* [Douglas Correia](https://github.com/DouglasCorreiaBrito)
* [Jean Oliveira Miranda](https://github.com/JeanOliveiraMiranda)
* [Roney Cacau](https://github.com/RoneyCacau)
* [Victor Augusto](https://www.linkedin.com/in/victor-augusto-de-souza-444b94122/)

Grupo responsável pelo front:

* [Gabriel Moretti](https://www.linkedin.com/in/gabriel-moretti-caliman-1a3604134/)
* [Jorge Aranha](https://www.linkedin.com/in/jorge-aranha-a5143b60/)
* [Vitor Tinoco](https://github.com/victrmart)

API feita com Spring 2.1(Data, Web), lombok, Utilizado Swagger 2.9.2, model mapper 2.3.  
Front com Angular 8.

## Testando a aplicação

Abaixo teremos um passo-a-passo com o caminho necessário para atender aos requisitos da aplicação e testá-la. Contém alguns links bacanas para alguns artigos que me auxiliaram bastante no desenvolvimento e com certeza também somarão à você.  

### Passo 1 - Instalação do *Maven* e *npm*

Será necessário instalar o Java8 e o Maven
* Faça o download do [maven](http://maven.apache.org/download.cgi)
* Baixe e coloque em alguma pasta em seu computador.  
  * Configurando as variáveis de Ambiente:  
    * M2_HOME : caminho para o maven (C:\java\maven)  
  * PATH: adicionar:  
    * %M2_HOME%\bin
    * Validar: mvn --version

 Com o Java e o Mave instalados. Execute o comando ```mvn install``` dentro da pasta tickerstore para instalar todas as dependências do Maven

### e *npm*

Por conta do framework utilizado, é obrigatório se ter instalado o *NodeJS* e o *npm* (gerenciador de pacotes). Eles vão nos permitir instalar todas as dependências e o *CLI* do *Angular*. Então, caso não os possua instalados, segue [aqui](https://dicasdejavascript.com.br/instalacao-do-nodejs-e-npm-no-windows-passo-a-passo/) um passo a passo que o guiará para tal passo inicial.

### Passo 2 - Instalação do *Angular CLI*

Pós ter atendido nosso primeiro requisito agora vamos para a instalação do *CLI* em si que vai nos permitir criar aplicações, **executar o servidor local com a nossa aplicação**, criar componentes, módulos, serviços, etc. Para instalar usando o npm, abra o prompt de comandos (cmd no windows) e execute o seguinte comando:

```npm
npm install -g @angular/cli
```

O parâmetro ``-g`` faz com que tal pacote seja instalado globalmente no seu sistema operacional.

Após o *npm* baixar todas as dependências e instalar o *Angular CLI*, você já está pronto para usá-lo através do comando ``ng``.

### Passo 3

[Instalar o SQL Server Express](https://www.microsoft.com/pt-br/download/details.aspx?id=55994) e o [SQL Server Management Studio](https://docs.microsoft.com/pt-br/sql/ssms/download-sql-server-management-studio-ssms?view=sql-server-ver15). Scripts para gerar e popular o Banco se encontram dentro da pasta ticketstore\src\main\resources. Execute primeiro o geracaoBD, depois o insertMovies e por fim o populacao.

### Passo 4 - Rodando a aplicação

Rode a aplicação Spring. Com ela rodando poderá acessar os endpoints pelo [Swagger](http://localhost:8080/swagger-ui.html)
Aqui é bem simples, o citado anteriormente comando ``ng`` nos permitirá interagir com a *Angular CLI*. [Aqui](https://www.devmedia.com.br/angular-cli-como-criar-e-executar-um-projeto-angular/38246) temos um ótimo artigo show que vai te guiar para os primeiros passos à utilizando caso tenha interesse pelo framework.

Novamente, na pasta ``hackathon`` onde se encontra o projeto em angular, de forma enxugada vamos rodar os comandos:

```angular
ng serve --open
```

ou, abreviando:

```angular
ng s -o
```

Irá abrir sua aplicação na porta default (*http://localhost:4200*). O parâmetro ``--open`` ou abreviado `-o` faz com que além de abrir sua aplicação numa porta ele também abra essa porta no seu navegador padrão.
