package main;

import tps.banque.AgenceBancaire;
import tps.banque.Compte;
import tps.banque.exception.ABCompteDejaExistantException;
import tps.banque.exception.ABCompteNullException;
import tps.banque.exception.CompteException;

public class ClasseEssaiAgenceBancaire {

	public static void main(String[] args) {
		AgenceBancaire monAg;
		monAg = new AgenceBancaire("AgenceBancaireTp", "Toulouse");
		monAg.afficher();
		int nbComptes = monAg.getNbComptes();
		System.out.println(nbComptes);
		
		Compte cUn;
		cUn = new Compte("0101", "prop1");
		Compte cDeux, cTrois;
		cDeux = new Compte("0202", "prop2");
		cTrois = new Compte("0303", "prop2");
		
		try {
			monAg.addCompte(cUn);
		} catch (ABCompteNullException e) {
			System.out.println (e.getMessage());
		} catch (ABCompteDejaExistantException e) {
			System.out.println (e.getMessage());
		}
		
		try {
			monAg.addCompte(cDeux);
		} catch (ABCompteNullException e) {
			System.out.println (e.getMessage());
		} catch (ABCompteDejaExistantException e) {
			System.out.println (e.getMessage());
		}
		
		try {
			monAg.addCompte(cTrois);
		} catch (ABCompteNullException e) {
			System.out.println (e.getMessage());
		} catch (ABCompteDejaExistantException e) {
			System.out.println (e.getMessage());
		}
		monAg.afficher();
		
		Compte recherche = monAg.getCompte("999");
		if (recherche == (null)) {
			System.out.println("pas de compte trouve");
		}
		else {
			recherche.afficher();
		}
		
		recherche = monAg.getCompte("0101");
		if (recherche == (null)) {
			System.out.println("pas de compte trouve");
		}
		else {
			recherche.afficher();
		}
		
		try {
			recherche.deposer(100);
			
		} catch (CompteException e) {
			System.out.println(e);
		}
		recherche = monAg.getCompte("0101");
		if (recherche == (null)) {
			System.out.println("pas de compte trouve");
		}
		else {
			recherche.afficher();
		}
		
		Compte rech[] = monAg.getComptesDe("prop2");
		if (rech.length < 1) {
			System.out.println("Pas de compte trouve");
		}
		for (int i=0; i<rech.length; i++) {
			System.out.println("Les comptes de prop2  sont : ");
			rech[i].afficher();
		}
		
		try {
			monAg.getCompte("0202").deposer(2000);
			
		} catch (CompteException e) {
			System.out.println(e);
		}
		try {
			monAg.getCompte("0303").deposer(3000);
			
		} catch (CompteException e) {
			System.out.println(e);
		}
		
		rech = monAg.getComptesDe("prop2");
		if (rech.length < 1) {
			System.out.println("Pas de compte trouve");
		}
		for (int i=0; i<rech.length; i++) {
			System.out.println("Les comptes de prop2  sont : ");
			rech[i].afficher();
		}
		//ils ont deux comptes differents avec un credit different
		
		rech = monAg.getComptesDe("ABSENT");
		if (rech.length < 1) {
			System.out.println("Pas de compte trouve");
		}
		for (int i=0; i<rech.length; i++) {
			System.out.println("Les comptes de ABSENT  sont : ");
			rech[i].afficher();
		}
		
		Compte c;
		try {
			c = null;
			monAg.addCompte(c);
		} catch (ABCompteNullException e) {
			System.out.println (e.getMessage());
		} catch (ABCompteDejaExistantException e) {
			System.out.println (e.getMessage());
		}
		
		try {
		monAg.removeCompte("0202");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			monAg.removeCompte("9999");
			} catch (Exception e) {
				System.out.println(e);
			}
		
		Compte cCinq;
		cCinq = new Compte ("0101", "prop99");
		try {
			monAg.addCompte(cCinq);
			} catch (ABCompteNullException e) {
				System.out.println(e.getMessage());
			} catch (ABCompteDejaExistantException e) {
				System.out.println(e.getMessage());
			}
	}
}
