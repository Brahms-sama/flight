//package com.m2i.web.rest;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.m2i.service.IServiceClient;
//import com.m2i.service.IServiceReservation;
//import com.m2i.service.IServiceVol;
//
////@Controller
////@RequestMapping(value="/")
//public class FlightController {
//
//	Map<String, Object> attributes = new HashMap<>();
//	// business service vers lequel déléguer les traitements :
//	@Autowired
//	private IServiceVol serviceVols;
//
//	@Autowired
//	private IServiceReservation serviceResa;
//
//	@Autowired
//	private IServiceClient serviceClient;
//			
//			@RequestMapping(value="/vols}", method=RequestMethod.GET)
//			public ModelAndView getVols() {
//				attributes.put("vols", serviceVols.rechercherTousLesVols());
//				return new ModelAndView("vols", attributes);
//			}
//			
//			@RequestMapping(value="/resa/{idVol}", method=RequestMethod.GET)
//			public ModelAndView reservation( @PathVariable("idVol") Long idVol) {
//				attributes.put("vol", serviceVols.rechercherVolParNumero(idVol));
//				return new ModelAndView("resa", attributes);
//			}
//			
//			
//			@RequestMapping(value="/clients", method=RequestMethod.GET)
//			public ModelAndView getClients() {
//				attributes.put("clients", serviceClient.listeClients());
//				System.out.println("getClients");
//				return new ModelAndView("clients", attributes);
//			}
//
//}
