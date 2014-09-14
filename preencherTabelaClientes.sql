select * from clientes inner join tel_cli on clientes.id_cliente = tel_cli.id_cli
		inner join telefone on tel_cli.id_tel= telefone.id_telefone
inner join bairro on clientes.id_bairro= bairro.id_bairro
inner join cidade on bairro.id_cidade=cidade.id_cidade