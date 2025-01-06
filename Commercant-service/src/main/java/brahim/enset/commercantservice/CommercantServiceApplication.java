package brahim.enset.commercantservice;

import brahim.enset.commercantservice.dtos.ChequeDTO;
import brahim.enset.commercantservice.services.ChequeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommercantServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommercantServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(ChequeService chequeService) {
		return args -> {
			// Premier chèque
			ChequeDTO cheque1 = ChequeDTO.builder()
					.numeroCheque("1234567890")
					.codeBanque("12345")
					.numeroCompte("12345678901")
					.nomClient("Brahim NAJI")
					.montant(5000.0)
					.certifie(false)
					.build();

			// Deuxième chèque
			ChequeDTO cheque2 = ChequeDTO.builder()
					.numeroCheque("9876543210")
					.codeBanque("54321")
					.numeroCompte("10987654321")
					.nomClient("Fatima BENTAHER")
					.montant(7500.0)
					.certifie(false)
					.build();

			// Troisième chèque
			ChequeDTO cheque3 = ChequeDTO.builder()
					.numeroCheque("5555666677")
					.codeBanque("11111")
					.numeroCompte("22222333344")
					.nomClient("Ahmed BENNANI")
					.montant(3000.0)
					.certifie(false)
					.build();

			try {
				System.out.println("******* Début d'insertion des données *******");

				chequeService.saveCheque(cheque1);
				System.out.println("Chèque 1 inséré avec succès");

				chequeService.saveCheque(cheque2);
				System.out.println("Chèque 2 inséré avec succès");

				chequeService.saveCheque(cheque3);
				System.out.println("Chèque 3 inséré avec succès");

				System.out.println("******* Fin d'insertion des données *******");

				// Afficher la liste des chèques insérés
				System.out.println("Liste des chèques dans la base de données :");
				chequeService.listCheques().forEach(cheque -> {
					System.out.println("--------------------------------");
					System.out.println("ID: " + cheque.getId());
					System.out.println("Numéro: " + cheque.getNumeroCheque());
					System.out.println("Client: " + cheque.getNomClient());
					System.out.println("Montant: " + cheque.getMontant());
					System.out.println("--------------------------------");
				});

			} catch (Exception e) {
				System.err.println("Erreur lors de l'insertion des données: " + e.getMessage());
				e.printStackTrace();
			}
		};
	}
}
