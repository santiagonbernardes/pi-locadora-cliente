package br.com.senaigo.locadora.model;

import br.com.senaigo.locadora.interfaces.PersisteDados;

public enum PersisteDadosFactory {
	CATEGORIA {
		@Override
		PersisteDados obtenhaInstancia() {
			return new Categoria();
		}
	},
	CLIENTE {
		@Override
		PersisteDados obtenhaInstancia() {
			return new Cliente();
		}
	},
	FUNCIONARIO {
		@Override
		PersisteDados obtenhaInstancia() {
			return new Funcionario();
		}
	},
	MARCA {
		@Override
		PersisteDados obtenhaInstancia() {
			return new Marca();
		}
	},
	MODELO {
		@Override
		PersisteDados obtenhaInstancia() {
			return new Modelo();
		}
	},
	MOTORISTA {
		@Override
		PersisteDados obtenhaInstancia() {
			return new Motorista();
		}
	},
	VEICULO {
		@Override
		PersisteDados obtenhaInstancia() {
			return new Veiculo();
		}
	},
	LOCACAO {
		@Override
		PersisteDados obtenhaInstancia() {
			return new Locacao();
		}
	};

	public static PersisteDados obtenhaInstancia(String nomeEntidade) {
		return PersisteDadosFactory.valueOf(nomeEntidade.toUpperCase()).obtenhaInstancia();
	}

	abstract PersisteDados obtenhaInstancia();
}
