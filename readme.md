## 🎨  API de Receitas: Uma Delícia de Documentação!

Bem-vindos à deliciosa documentação da API de Receitas, construída com Kotlin e Ktor, e com um toque especial de PostgreSQL para armazenar todas as suas delícias culinárias!

### 🍽️ Endpoints: A Mesa Está Posta

A nossa API oferece uma variedade de endpoints saborosos para você explorar:

**URL Base:** `/recipes`

**1. 😋  Obter Todas as Receitas**

* **Endpoint:** `/recipes/`
* **Método:** `GET`
* **Descrição:**  Sirva-se de uma lista completa de todas as receitas deliciosas armazenadas no nosso banco de dados PostgreSQL!
* **Resposta:**
    * **Código de Status:** 200 (OK) - Delicioso!
    * **Conteúdo:**  Uma lista completa de objetos `Recipe`  prontos para serem saboreados.

**2. 🍰 Obter Receitas por Categoria**

* **Endpoint:** `/recipes/category={categoryId}`
* **Método:** `GET`
* **Descrição:**  Explore um menu especial de receitas de uma categoria específica!
* **Parâmetros:**
    * **categoryId:** (inteiro)  O ID da categoria que você deseja explorar.
* **Resposta:**
    * **Código de Status:**
        * 200 (OK) -  A categoria está repleta de delícias!
        * 400 (Bad Request) -  O `categoryId`  está incorreto ou faltando.
    * **Conteúdo:**
        * Uma lista saborosa de objetos `Recipe` se a categoria existir.
        * "Categoria não existe" -  Que pena! A categoria não está disponível no momento.
        * "Categoria inválida" -  O `categoryId`  está incorreto.

**3. 🍕 Obter Receitas por Título**

* **Endpoint:** `/recipes/title={title}`
* **Método:** `GET`
* **Descrição:**  Encontre a receita perfeita pelo seu nome!
* **Parâmetros:**
    * **title:** (string)  O título da receita que você procura.
* **Resposta:**
    * **Código de Status:** 200 (OK) -  Encontrei a receita!
    * **Conteúdo:** Uma lista de objetos `Recipe` que correspondem ao título.
    * **Código de Status:** 400 (Bad Request) -  O `title`  está incorreto ou faltando.

**4. 🍳 Obter Receita por ID**

* **Endpoint:** `/recipes/id={id}`
* **Método:** `GET`
* **Descrição:**  Busque uma receita específica pelo seu ID.
* **Parâmetros:**
    * **id:** (inteiro) O ID da receita que você deseja encontrar.
* **Resposta:**
    * **Código de Status:**
        * 200 (OK) -  A receita foi encontrada!
        * 400 (Bad Request) -  O `id`  está incorreto ou faltando.
    * **Conteúdo:**
        * Um objeto `Recipe`  se a receita existir.
        * "Receita não existe" -  Que pena! A receita não está disponível no momento.
        * "Id inválido" -  O `id`  está incorreto.

**5. 📸 Obter Imagens de Receitas**

* **Endpoint:** `/recipes/images`
* **Método:** `GET`
* **Descrição:**  Apresente suas receitas com imagens apetitosas! As imagens são armazenadas em um sistema de arquivos separado, e a URL da imagem é armazenada no objeto `Recipe`  no banco de dados PostgreSQL.
* **Resposta:**
    * **Código de Status:** 200 (OK) -  As imagens estão prontas para serem exibidas!
    * **Conteúdo:**  Imagens para receitas, acessadas através da URL armazenada no objeto `Recipe`.

### 🗃️  Estruturas de Dados: Os Ingredientes da API

**Objeto Recipe:**

O objeto `Recipe`  armazena todos os detalhes da sua receita no banco de dados PostgreSQL:

* `id` (inteiro):  O ID único da receita.
* `title` (string):  O título da receita.
* `category` (string):  A categoria da receita.
* `imageUrl` (string):  A URL da imagem associada à receita.
* `ingredients` (string):  Uma lista dos ingredientes necessários para a receita.
* `instructions` (string):  As instruções detalhadas sobre como preparar a receita.

### 🔐  Autenticação:  Livre para Degustar

A API não requer autenticação. Sinta-se à vontade para explorar todas as receitas!

### 👨‍🍳 Notas:  Dicas para um Banquete Perfeito

* A API é projetada para ser fácil de usar e agradável.
* A estrutura do objeto `Recipe`  pode ser modificada de acordo com suas necessidades.
* A classe `RecipeRepository`  no código cuida de armazenar e recuperar as receitas no banco de dados PostgreSQL.

Desfrute da sua jornada culinária com a API de Receitas! 😄
