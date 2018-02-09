Feature: Cadastrar novo usuario
	as a usuario do sistema
	I want to Cadastrar um novo usuario
	so that Cada usuario tem seu proprio perfil no sistema
	
#GUI scenario - Andrei Lima
	
	Scenario: Cadastrar um novo usuario
	   Given Eu estou na pagina "Criar usuario" 
	   When Eu cadastro o usuario com nome de usuario "Andreimd" com primeiro nome "Andrei" com ultimo nome "Lima" com setor de preferencia "CCEN"
	   Then Eu vejo o usuario com nome de usuario "Andreimd" com primeiro nome "Andrei" com ultimo nome "Lima" com setor de preferencia "CCEN" na pagina "Listagem de usuarios"
	@ignore   
	Scenario: Cadastrar um usuario ja existente
	   Given Eu estou na pagina "Listagem de usuarios"
	   And Eu vejo o usuario com nome de usuario "Andreimd" com primeiro nome "Andrei" com ultimo nome "Lima" com setor de preferencia "CCEN" na pagina "Listagem de usuarios"
	   And Eu vou para pagina "Criar usuario"
	   When Eu cadastro o usuario com nome de usuario "Andreimd" com primeiro nome "Andrei" com ultimo nome "Lima" com setor de preferencia "CCEN"
	   Then Eu vejo uma mensagem de erro
	   
#Controller scenario - Andrei Lima
	
	Scenario: Cadastrar um novo usuario
	   Given O usuario com nome de usuario "Andreimd" com primeiro nome "Andrei" com ultimo nome "Lima" com setor de preferencia "CCEN" nao esta cadastrado no sistema
	   When Eu cadastro o usuario com nome de usuario "Andreimd" com primeiro nome "Andrei" com ultimo nome "Lima" com setor de preferencia "CCEN"
	   Then O sistema cadastra o usuario com nome de usuario "Andreimd" com primeiro nome "Andrei" com ultimo nome "Lima" com setor de preferencia "CCEN"   
	   

	Scenario: Cadastrar um usuario ja existente
	   Given O usuario com nome de usuario "Andreimd" com primeiro nome "Andrei" com ultimo nome "Lima" com setor de preferencia "CCEN" ja esta cadastrado no sistema
	   When Eu cadastro o usuario com nome de usuario "Andreimd" com primeiro nome "Andrei" com ultimo nome "Lima" com setor de preferencia "CCEN"
	   Then O sistema nao cadastra o usuario com nome de usuario "Andreimd" com primeiro nome "Andrei" com ultimo nome "Lima" com setor de preferencia "CCEN"   
