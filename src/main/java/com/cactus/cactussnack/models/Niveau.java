package com.cactus.cactussnack.models;

public enum Niveau {
	Tacheron(0), Serveur(1), Barman(2), CaissierSecondaire(3), CaissierPrincipal(
			4), MagasinierProduit(6), MagasinierEmballage(5), Controlleur(7), Gerant(
			8), Directeur(9), Sudo(21);

	int indice;

	Niveau(int indice) {
		this.indice = indice;
	}

}
