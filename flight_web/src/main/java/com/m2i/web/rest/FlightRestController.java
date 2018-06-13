package com.m2i.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.entity.Client;
import com.m2i.entity.Login;
import com.m2i.entity.Vol;
import com.m2i.service.IServiceClient;
import com.m2i.service.IServiceReservation;
import com.m2i.service.IServiceVol;

@RestController
@RequestMapping(value = "/rest/", headers = "Accept=application/json")
public class FlightRestController {

	// business service vers lequel déléguer les traitements :
	@Autowired
	private IServiceVol serviceVols;

	@Autowired
	private IServiceReservation serviceResa;

	@Autowired
	private IServiceClient serviceClient;

	// sera appelé en HTTP / GET avec l' URL suivante:
	// http://localhost:8080/flight_Web/mvc/rest/vols/all
	@RequestMapping(value = "/vols", method = RequestMethod.GET)
	public List<Vol> getVols() {
		return serviceVols.rechercherTousLesVols();
		// NB: le resultat java de type List<Vol>
		// sera automatiquement transformé au format JSON
	}


	@RequestMapping(value = "/resa/{idVol}", method = RequestMethod.GET)
	public Vol reservation(@PathVariable("idVol") Long idVol) {
		return serviceVols.rechercherVolParNumero(idVol);
	}
	
	@RequestMapping(value = "/clients", method = RequestMethod.GET)
	public List<Client> getClients() {
		return serviceClient.listeClients();
	}
	
	@RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
	public Client getClient(@PathVariable("id") Integer id) {
		return serviceClient.rechercherClientParId(id);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	ResponseEntity<Client> postDevise(@RequestBody Login login) {
		try {
			Client client = serviceClient.authentifierClient(login.getUsername(), login.getPassword());
			if(client == null)
				return new ResponseEntity<Client>(HttpStatus.UNAUTHORIZED);
			else
				return new ResponseEntity<Client>(client, HttpStatus.OK);
			// C'est souvent intéressant de renvoyer l'objet insérer
			// dans le cas d'une clé primaire auto-increment
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return new ResponseEntity<Client>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
