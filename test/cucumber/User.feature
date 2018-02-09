Feature: Gerenciar usuario
	As a Usuário do sistema
	I want to Editar e apagar usuários
	So that Gerenciar informações relacionadas a usuários 
@ignore 
Scenario: Editar Usuario GUI
    Given estou na pagina de editar usuario
    When coloco o novo username "user_default" a ser adicionado
    And coloco os outros dados corretamente
    And e envio as mudancas
    Then o username eh alterado com sucesso
@ignore
  Scenario: apagar usuario GUI
    Given estou na pagina de listagem de usuarios
    And existe um usuario na listagem
    And seleciono este usuario
    When aperto o botao Remover
    And confirmo a opcao
    Then estou na pagina de listagem e este usuario nao consta mais

  Scenario: Apagar usuario
    Given existe no sistema um usuario com username "padrao" e preferredSector "CIn" 
    When o usuario seleciona remover este usuario
    Then nao existem mais usuario 

   Scenario: Editar Usuario
  	Given existe no sistema um usuario com nome de usuario "default"
  	When O usuario altera o username para "null"
  	Then o sistema atualiza o username
