package sn.samaneCorporation.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sn.samaneCorporation.entities.Pharmacie;
import sn.samaneCorporation.repository.PharmetieRepository;

@RestController
public class PharmatieController {
	
	@Autowired
	private PharmetieRepository pharmacieDb;
	
	
	@RequestMapping(value = "/Pharmacie", method = RequestMethod.GET)
	public List<Pharmacie> liste(){
		
		return (List<Pharmacie>) pharmacieDb.findAll();
	}
	
	@RequestMapping(value = "/Pharmacie/{id}", method = RequestMethod.GET)
	public Pharmacie getPharmacie(@PathParam(value = "id") int id){
		
		return  pharmacieDb.findById(id).get();
	}
	
	@RequestMapping(value = "/Pharmacie/add", method = RequestMethod.POST)
	public Pharmacie addPharmacie(@RequestParam(value="nom") String nom, @RequestParam(value="etat") int etat,
			@RequestParam(value="quartier") String quartier, @RequestParam(value="ville") String ville){
		
		Pharmacie pharmacie = new Pharmacie();
		pharmacie.setNom(nom);
		pharmacie.setEtat(etat);
		pharmacie.setQuartier(quartier);
		pharmacie.setVille(ville);
		
		return pharmacieDb.save(pharmacie);
	}
	
	@RequestMapping(value = "/Pharmacie/edit/{id}", method = RequestMethod.POST)
	public Pharmacie editPharmacie(@RequestParam(value="nom") String nom, @RequestParam(value="etat") int etat,
			@RequestParam(value="quartier") String quartier, @RequestParam(value="ville") String ville,
			@PathParam(value = "id")int id){
		
		Pharmacie pharmacie = new Pharmacie();
		pharmacie.setId(id);
		pharmacie.setNom(nom);
		pharmacie.setEtat(etat);
		pharmacie.setQuartier(quartier);
		pharmacie.setVille(ville);
		
		return pharmacieDb.save(pharmacie);
	}

}
