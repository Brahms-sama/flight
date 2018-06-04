package com.m2i.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.m2i.entity.Vol;
import com.m2i.service.IServiceReservation;
import com.m2i.service.IServiceVol;

@RestController
@RequestMapping(value="/rest/vols" , 
                headers="Accept=application/json")
public class FlightController {

	Map<String, Object> attributes = new HashMap<>();
	//business service vers lequel déléguer les traitements :
		@Autowired
		private IServiceVol serviceVols; 
		
		@Autowired
		private IServiceReservation serviceResa;
		
		//sera appelé en HTTP / GET avec l' URL suivante:
		// http://localhost:8080/flight_Web/mvc/rest/vols/all
		@RequestMapping(value="/all" , method=RequestMethod.GET)
		List<Vol> getVols(  ){
			return serviceVols.rechercherTousLesVols();
			//NB: le resultat java de type List<Vol>
			//sera automatiquement transformé au format JSON
		}
		
//		@RequestMapping(value="/resa/{idVol}", method=RequestMethod.GET)
//		public ModelAndView reservation( @PathVariable("idVol") Long idVol) {
//			attributes.put("vol", serviceVols.rechercherVolParNumero(idVol));
//			return new ModelAndView("resa", attributes);
//		}
		
		@RequestMapping(value="/resa/{idVol}", method=RequestMethod.GET)
		public Vol reservation( @PathVariable("idVol") Long idVol) {
			return serviceVols.rechercherVolParNumero(idVol);
		}
}
