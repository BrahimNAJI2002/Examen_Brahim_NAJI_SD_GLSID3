package brahim.enset.banquecentraleservice;

import brahim.enset.banquecentraleservice.dtos.AgenceBancaireDTO;
import brahim.enset.banquecentraleservice.services.AgenceBancaireService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BanqueCentraleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanqueCentraleServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(AgenceBancaireService agenceBancaireService) {
		return args -> {
			System.out.println("******* Début d'insertion des agences bancaires *******");

			AgenceBancaireDTO agence1 = AgenceBancaireDTO.builder()
					.nom("Agence BMCE Casablanca Centre")
					.ville("Casablanca")
					.urlWebService("http://localhost:8082/api/agence1")
					.build();

			AgenceBancaireDTO agence2 = AgenceBancaireDTO.builder()
					.nom("Agence CIH Rabat Agdal")
					.ville("Rabat")
					.urlWebService("http://localhost:8082/api/agence2")
					.build();

			AgenceBancaireDTO agence3 = AgenceBancaireDTO.builder()
					.nom("Agence BP Marrakech Gueliz")
					.ville("Marrakech")
					.urlWebService("http://localhost:8082/api/agence3")
					.build();

			try {
				agenceBancaireService.saveAgence(agence1);
				agenceBancaireService.saveAgence(agence2);
				agenceBancaireService.saveAgence(agence3);

				System.out.println("Liste des agences bancaires insérées :");
				agenceBancaireService.listAgences().forEach(agence -> {
					System.out.println("--------------------------------");
					System.out.println("ID: " + agence.getId());
					System.out.println("Nom: " + agence.getNom());
					System.out.println("Ville: " + agence.getVille());
					System.out.println("URL: " + agence.getUrlWebService());
					System.out.println("--------------------------------");
				});
			} catch (Exception e) {
				System.err.println("Erreur lors de l'insertion des données: " + e.getMessage());
				e.printStackTrace();
			}
		};
	}
}
