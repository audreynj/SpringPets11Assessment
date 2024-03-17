
package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Pet;
import dmacc.repository.PetRepository;


/**
 * Audrey N. Johnston - ajohnston10
 * CIS175
 * Mar 16, 2024
 */

@Controller
public class WebController {
	@Autowired
	PetRepository repo;

	@GetMapping({ "/", "viewAll" })
	public String viewAllPetsInfo(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewPetInfo(model);
		}
		
		model.addAttribute("pets", repo.findAll());
		return "results";
	}

	@GetMapping("/inputPet")
	public String addNewPetInfo(Model model) {
		Pet c = new Pet();
		model.addAttribute("newPet", c);
		return "input";
	}

	@GetMapping("/edit/{id}")
	public String showUpdatePetInfo(@PathVariable("id") long id, Model model) {
		Pet c = repo.findById(id).orElse(null);
		System.out.println("ITEM TO EDIT: " + c.toString());
		model.addAttribute("newPet", c);
		return "input";
	}
	
	@PostMapping("/inputPet")
	public String addNewPetInfo(@ModelAttribute Pet c, Model model) {
		repo.save(c);
		return viewAllPetsInfo(model);
	}
	

	@PostMapping("/update/{id}")
	public String revisePetInfo(Pet c, Model model) {
		repo.save(c);
		return viewAllPetsInfo(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Pet c = repo.findById(id).orElse(null);
	    repo.delete(c);
	    return viewAllPetsInfo(model);
	}
}

