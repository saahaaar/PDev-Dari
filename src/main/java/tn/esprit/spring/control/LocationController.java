package tn.esprit.spring.control;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entity.AppartementLocation;
import tn.esprit.spring.entity.Location;
import tn.esprit.spring.entity.MaisonLocation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.VillaLocation;
import tn.esprit.spring.service.LocationService;

@Controller
public class LocationController {
	  @Autowired
	     LocationService locService;
	//http://localhost:8081/SpringMVC/Servlet/fileuploads
  public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
  @RequestMapping("/fileuploads")
  public String UploadPage(Model model) {
	  return "uploadview";
	//http://localhost:8081/SpringMVC/Servlet/autocomplete
  }
  @RequestMapping("/autocomplete")
  public String autocomplete(Model model) {
	  return "autocomlete";
  }
//http://localhost:8081/SpringMVC/Servlet/interdit
  
  @RequestMapping("/interdit")
  public String interdit(Model model) {
	  return "interdit";
  }
//http://localhost:8081/SpringMVC/Servlet/share
  
  @RequestMapping("/share")
  public String share(Model model) {
	  return "share";
  }
  //http://localhost:8081/SpringMVC/Servlet/upload
  @RequestMapping("/upload")
  public String upload(Model model,@RequestParam("files") MultipartFile[] files) {
	  StringBuilder fileNames = new StringBuilder();
	  for (MultipartFile file : files) {
		  Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
		  fileNames.append(file.getOriginalFilename()+" ");
		  try {
			Files.write(fileNameAndPath, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	  model.addAttribute("msg", "Successfully uploaded files "+fileNames.toString());
	  return "uploadstatusview";
  }
    // Ajouter maison : http://localhost:8081/SpringMVC/Servlet/add-Mloc
  @PostMapping("/add-Mloc")
  @ResponseBody
  public MaisonLocation addMLoc(@RequestBody MaisonLocation ml) {
  MaisonLocation location= locService.ajouterMlocation(ml);
  return location;
  }
  // Ajouter Appartement : http://localhost:8081/SpringMVC/Servlet/add-Aloc
  @PostMapping("/add-Aloc")
  @ResponseBody
  public AppartementLocation addALoc(@RequestBody AppartementLocation ml) {
	  AppartementLocation location= locService.ajouterAlocation(ml);
  return location;
  }
  // Ajouter Villa : http://localhost:8081/SpringMVC/Servlet/add-Vloc
  @PostMapping("/add-Vloc")
  @ResponseBody
  public VillaLocation addLoc(@RequestBody VillaLocation ml) {
	  VillaLocation location= locService.ajouterVlocation(ml);
  return location;
  }
//afficher locations : http://localhost:8081/SpringMVC/Servlet/affiche-tloc
 @GetMapping("/affiche-tloc")
 @ResponseBody
 public List<Location> gettLoc() {
	 List<Location> list=locService.afficherTlocation();
 return list;
 }
	  // afficher maison : http://localhost:8081/SpringMVC/Servlet/affiche-Mloc
  @GetMapping("/affiche-Mloc")
  @ResponseBody
  public List<MaisonLocation> getLoc() {
  List<MaisonLocation> list=locService.afficherMlocation();
  return list;
  }
  
  // afficher appartement : http://localhost:8081/SpringMVC/Servlet/affiche-Aloc
  @GetMapping("/affiche-Aloc")
  @ResponseBody
  public List<AppartementLocation> getappLoc() {
  List<AppartementLocation> app=locService.afficherAlocation();
  return app;
  }
  // afficher Villa : http://localhost:8081/SpringMVC/Servlet/affiche-Vloc
  @GetMapping("/affiche-Vloc")
  @ResponseBody
  public List<VillaLocation> getvLoc() {
  List<VillaLocation> app=locService.afficherVlocation();
  return app;
  }
  //update maison : http://localhost:8081/SpringMVC/Servlet/update-Mloc
  @PutMapping("/update-Mloc")
  @ResponseBody
  public MaisonLocation updateMLoc(@RequestBody MaisonLocation ml) {
  MaisonLocation location= locService.updateMlocation(ml);
  return location;
  }
//update Appartement : http://localhost:8081/SpringMVC/Servlet/update-Aloc
  @PutMapping("/update-Aloc")
  @ResponseBody
  public AppartementLocation updateALoc(@RequestBody AppartementLocation ml) {
	  AppartementLocation location= locService.updateAlocation(ml);
  return location;
  }
//update maison : http://localhost:8081/SpringMVC/Servlet/update-Vloc
  @PutMapping("/update-Vloc")
  @ResponseBody
  public VillaLocation updateVLoc(@RequestBody VillaLocation ml) {
	  VillaLocation location= locService.updateVlocation(ml);
  return location;
  }
//supprimer Location http://localhost:8081/SpringMVC/Servlet/delete-Loc/{id}
	@DeleteMapping("/delete-Loc/{id}")
	@ResponseBody
	public void removeVente(@PathVariable("id") String id) {
		locService.deletelocation(id);
	}
	//*********************//
	 // afficher location : http://localhost:8081/SpringMVC/Servlet/affiche-locDinf/{date}
	  @GetMapping("/affiche-locDinf/{date}")
	  @ResponseBody
	  public List<Location> getLocinf(@PathVariable("date") String date) {
	  List<Location> loc=locService.afficherDinflocation(date);
	  return loc;
	  }
	 // afficher location : http://localhost:8081/SpringMVC/Servlet/affiche-locDsup/{date}
	  @GetMapping("/affiche-locDsup/{date}")
	  @ResponseBody
	  public List<Location> getLocsup(@PathVariable("date") String date) {
	  List<Location> loc=locService.afficherDsuplocation(date);
	  return loc;
	  }
	// afficher location : http://localhost:8081/SpringMVC/Servlet/affiche-locDsup/{date1}/{date2}
		  @GetMapping("/affiche-locDentre/{date1}/{date2}")
		  @ResponseBody
		  public List<Location> getLocentre(@PathVariable("date1") String date1,@PathVariable("date2") String date2) {
		  List<Location> loc=locService.afficherDentrelocation(date1,date2);
		  return loc;
		  }
		// afficher location : http://localhost:8081/SpringMVC/Servlet/affiche-locPinf/{prix}
		  @GetMapping("/affiche-locPinf/{prix}")
		  @ResponseBody
		  public List<Location> getLocpinf(@PathVariable("prix") String prix) {
		  List<Location> loc=locService.afficherprixinflocation(prix);
		  return loc;
		  }
		// afficher location : http://localhost:8081/SpringMVC/Servlet/affiche-locPsup/{prix}
		  @GetMapping("/affiche-locPsup/{prix}")
		  @ResponseBody
		  public List<Location> getLocpsup(@PathVariable("prix") String prix) {
		  List<Location> loc=locService.afficherprixsuplocation(prix);
		  return loc;
		  }
		// afficher location : http://localhost:8081/SpringMVC/Servlet/affiche-locPentre/{prix1}/{prix2}
		  @GetMapping("/affiche-locPentre/{prix1}/{prix2}")
		  @ResponseBody
		  public List<Location> getLocpentre(@PathVariable("prix1") String prix1,@PathVariable("prix2") String prix2) {
		  List<Location> loc=locService.afficherprixentrelocation(prix1, prix2);
		  return loc;
		  }
		//update prix : http://localhost:8081/SpringMVC/Servlet/update-Prixloc
		  @PutMapping("/update-Prixloc")
		  @ResponseBody
		  public List<Location> updatePrixLoc() {
		  List<Location> location= locService.estimationP();
		  return location;
		  }
		  
}