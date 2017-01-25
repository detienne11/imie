package fr.imie.training.cdi13.dav.jdbc.ui;

import java.util.List;

import fr.imie.training.cdi13.dav.jdbc.Application;
import fr.imie.training.cdi13.dav.jdbc.ApplicationException;
import fr.imie.training.cdi13.dav.jdbc.bl.Service;
import fr.imie.training.cdi13.dav.jdbc.bl.ServiceFactory;
import fr.imie.training.cdi13.dav.jdbc.dal.DAOFactory;
import fr.imie.training.cdi13.dav.jdbc.model.DTO;
import fr.imie.training.cdi13.dav.jdbc.model.dto.EtablissementDTO;

public class Tp2ApplicationImpl implements Application {

	private DAOFactory daoFactory = null;

	public Tp2ApplicationImpl() {
	}

	@Override
	public String getNom() {
		return "TP2 via business layer";
	}

	@Override
	public void init() throws ApplicationException {
		daoFactory = DAOFactory.getInstance();
		daoFactory.openConnection();
	}

	@Override
	public void stop() throws ApplicationException {
		daoFactory.closeConnection();
	}

	private void started() throws Exception {
		
		final Service service = ServiceFactory.getInstance().getService(Service.SERVICE_TYPE.ACADEMIE);
		
		boolean exit = false;
		while (!exit) {
			
			String reponse = Console.demanderChoixUtilisateur("^[1-4]$", Console.afficherMenu());
			if (reponse.equals("exit")) {
				exit = true;
			}
			else {
				
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
					
					EtablissementDTO eltDto  = new EtablissementDTO();
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
					EtablissementDTO elt = (EtablissementDTO)service.findById(Integer.valueOf(param));
					System.out.println(elt.toString());
					
					params = Console.demanderParametreUtilisateur(EtablissementDTO.parameters());
					eltDto  = new EtablissementDTO();
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
					}
					else {
						System.out.println("Modification abandonnee");
					}
					
					break;
					
				case 4 :
					//supprimer
					System.out.println("Supprimer Etablissement ...");
					System.out.println("- - - - - - - - - - - - - - - - ");
					param = Console.demanderParametreUtilisateur("id");
					
					elt = (EtablissementDTO)service.findById(Integer.valueOf(param));
					System.out.println(elt.toString());
					confirm = Console.confirmer();
					if (confirm) {
						eltDto  = new EtablissementDTO();
						eltDto.setId(Integer.valueOf(param));
						
						service.delete(eltDto);
					}
					else {
						System.out.println("Suppression abandonnee");
					}
					
					
					break;
					
				}
			}
		}
		
	}
	
	@Override
	public void start() throws ApplicationException {
		
		try {
			this.started();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			throw new ApplicationException(e.getMessage());
		}
		

	}

}
