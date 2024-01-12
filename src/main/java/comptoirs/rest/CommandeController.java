package comptoirs.rest;

import comptoirs.dto.CommandeDTO;
import comptoirs.dto.LigneDTO;
import comptoirs.entity.Commande;

import org.modelmapper.ModelMapper;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import comptoirs.service.CommandeService;

@RestController // Cette classe est un contrôleur REST
@RequestMapping(path = "/services/commandes") // chemin d'accès
public class CommandeController {
	private final CommandeService commandeService;
	private final ModelMapper mapper;
	// @Autowired
	public CommandeController(CommandeService commandeService,  ModelMapper mapper) {
		this.commandeService = commandeService;
		this.mapper = mapper;
	}

	@PostMapping("ajouterPour/{clientCode}")
	public CommandeDTO ajouter(@PathVariable @NonNull String clientCode) {
		Commande commande = commandeService.creerCommande(clientCode);
		return mapper.map(commande, CommandeDTO.class);
	}

	@PostMapping("expedier/{commandeNum}")
	public CommandeDTO expedier(@PathVariable int commandeNum) {
		return mapper.map(commandeService.enregistreExpedition(commandeNum), CommandeDTO.class);
	}

	@PostMapping("ajouterLigne")
	public LigneDTO ajouterLigne(@RequestParam int commandeNum, @RequestParam int produitRef, @RequestParam int quantite) {
		var ligne = commandeService.ajouterLigne(commandeNum, produitRef, quantite);
		return mapper.map(ligne, LigneDTO.class);
	}
}
