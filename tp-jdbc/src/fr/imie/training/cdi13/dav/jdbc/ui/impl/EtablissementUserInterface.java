package fr.imie.training.cdi13.dav.jdbc.ui.impl;

import java.util.List;
import java.util.Map;

import fr.imie.training.cdi13.dav.jdbc.bl.Service;
import fr.imie.training.cdi13.dav.jdbc.bl.Service.SERVICE_TYPE;
import fr.imie.training.cdi13.dav.jdbc.model.DTO;
import fr.imie.training.cdi13.dav.jdbc.model.dto.EtablissementDTO;
import fr.imie.training.cdi13.dav.jdbc.ui.UserInterface;
import fr.imie.training.cdi13.dav.jdbc.ui.UserInterfaceException;

public class EtablissementUserInterface implements UserInterface {

	private Map<Service.SERVICE_TYPE, Service> serviceMap;

	public EtablissementUserInterface() {
	}

	@Override
	public void init(Map<SERVICE_TYPE, Service> serviceMap) {
		this.serviceMap = serviceMap;
	}

	@Override
	public void execute() throws UserInterfaceException {
		try {
			this.started();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw new UserInterfaceException(e.getMessage());
		}

	}

	private void started() throws Exception {

		final Service service = this.serviceMap.get(Service.SERVICE_TYPE.ACADEMY);

		boolean exit = false;
		while (!exit) {

//			Runtime.getRuntime().exec("cmd /c cls");
			String reponse = Console.demanderChoixUtilisateur("^[1-4]$", Console.afficherMenu());

			if (reponse.equals("exit")) {
				exit = true;
			} else {

				switch (Integer.valueOf(reponse).intValue()) {
				case 1:
					// Lister
					System.out.println("Lister Etablissements ...");
					System.out.println("- - - - - - - - - - - - - - - - ");

					List<DTO> liste = service.listerEtablissement();
					for (DTO dto : liste) {
						System.out.println(dto.toString());
					}

					break;

				case 2:
					// creer
					System.out.println("Creation Etablissement ...");
					System.out.println("- - - - - - - - - - - - - - - - ");
					System.out.println("Saisissez les parametres ");
					List<String> params = Console.demanderParametreUtilisateur(EtablissementDTO.parameters());

					EtablissementDTO eltDto = new EtablissementDTO();
					eltDto.setNom(params.get(0));
					eltDto.setNumRue(Integer.valueOf(params.get(1)));
					eltDto.setNomRue(params.get(2));
					eltDto.setCodePostal(params.get(3));
					eltDto.setVille(params.get(4));

					service.create(eltDto);

					System.out.println("\n ID créé : " + eltDto.getId() + "\n");

					break;

				case 3:
					// modifier
					System.out.println("Modifier Etablissement ...");
					System.out.println("- - - - - - - - - - - - - - - - ");
					String param = Console.demanderParametreUtilisateur("id");
					EtablissementDTO elt = (EtablissementDTO) service.findById(Integer.valueOf(param));
					System.out.println(elt.toString());

					params = Console.demanderParametreUtilisateur(EtablissementDTO.parameters());
					eltDto = new EtablissementDTO();
					eltDto.setId(Integer.valueOf(param));
					eltDto.setNom(params.get(0));
					eltDto.setNumRue(Integer.valueOf(params.get(1)));
					eltDto.setNomRue(params.get(2));
					eltDto.setCodePostal(params.get(3));
					eltDto.setVille(params.get(4));

					System.out.println("Modifier ");
					System.out.println(elt.toString());
					System.out.println("Par ");
					System.out.println(eltDto.toString());

					boolean confirm = Console.confirmer();
					if (confirm) {
						service.update(eltDto);
					} else {
						System.out.println("Modification abandonnee");
					}

					break;

				case 4:
					// supprimer
					System.out.println("Supprimer Etablissement ...");
					System.out.println("- - - - - - - - - - - - - - - - ");
					param = Console.demanderParametreUtilisateur("id");

					elt = (EtablissementDTO) service.findById(Integer.valueOf(param));
					System.out.println(elt.toString());
					confirm = Console.confirmer();
					if (confirm) {
						eltDto = new EtablissementDTO();
						eltDto.setId(Integer.valueOf(param));

						service.delete(eltDto);
					} else {
						System.out.println("Suppression abandonnee");
					}

					break;

				}
			}
		}

	}

}
