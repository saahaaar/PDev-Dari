package tn.esprit.spring.service;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Abonnement;
import tn.esprit.spring.entity.AppartementLocation;
import tn.esprit.spring.entity.Location;
import tn.esprit.spring.entity.MaisonLocation;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.VillaLocation;
import tn.esprit.spring.repository.AbonnementRepository;
import tn.esprit.spring.repository.AppartementLocRepository;
import tn.esprit.spring.repository.LocationRepository;
import tn.esprit.spring.repository.MaisonLocRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.repository.VillaLocRepository;
@Service
public class LocationServiceImpl implements LocationService {
@Autowired
MaisonLocRepository mlr;
@Autowired
LocationRepository lr;
@Autowired
AppartementLocRepository alr;
@Autowired
AbonnementRepository ar;
@Autowired
UserRepository ur;
@Autowired
VillaLocRepository vlr;
private static final Logger L = LogManager.getLogger(LocationServiceImpl.class);
	
	@Override
	public List<MaisonLocation> afficherMlocation() {
		List<MaisonLocation> locations = (List<MaisonLocation>) mlr.findAll();
		return locations;
	}
	@Override
	public List<Location> afficherTlocation() {
	
		List<Location> list=(List<Location>)lr.findAll();
		return list;
	}
	@Override
	public List<AppartementLocation> afficherAlocation() {
		List<AppartementLocation> app=(List<AppartementLocation>) alr.findAll();
		return app;
	}
	@Override
	public MaisonLocation updateMlocation(MaisonLocation location) {
		return mlr.save(location);
	}
	@Override
	public MaisonLocation ajouterMlocation(MaisonLocation location) {
		location.setDate_loc(new Date());
		MaisonLocation loc= mlr.save(location);
		return loc;
	}
	@Override
	public AppartementLocation ajouterAlocation(AppartementLocation location) {
		location.setDate_loc(new Date());
		AppartementLocation loc= alr.save(location);
		return loc;
	}
	@Override
	public VillaLocation ajouterVlocation(VillaLocation location) {
		location.setDate_loc(new Date());
		VillaLocation loc= vlr.save(location);
		return loc;
	}
	@Override
	public List<VillaLocation> afficherVlocation() {
		List<VillaLocation> vill=(List<VillaLocation>) vlr.findAll();
		return vill;
	}
	@Override
	public AppartementLocation updateAlocation(AppartementLocation location) {
		return alr.save(location);
	}
	@Override
	public VillaLocation updateVlocation(VillaLocation location) {
		return vlr.save(location);
	}
	@Override
	public void deletelocation(String id) {
		lr.deleteById(Long.parseLong(id));
		
	}
	@Override
	public List<Location> afficherDinflocation(String d) {
		List<Location> loc=null;
		try {
			loc = (List<Location>) lr.locinfdate(new SimpleDateFormat("dd-MM-yyyy").parse(d) );
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return loc;
	}
	@Override
	public List<Location> afficherDsuplocation(String d) {
		List<Location> loc=null;
		try {
			loc = (List<Location>) lr.locsupdate(new SimpleDateFormat("dd-MM-yyyy").parse(d) );
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return loc;
	}
	@Override
	public List<Location> afficherDentrelocation(String d1,String d2) {
		List<Location> loc=null;
		try {
			loc = (List<Location>) lr.locentredate(new SimpleDateFormat("dd-MM-yyyy").parse(d1),new SimpleDateFormat("dd-MM-yyyy").parse(d2));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return loc;
	}
	@Override
	public List<Location> afficherprixinflocation(String p) {
		List<Location> loc;
			loc = (List<Location>) lr.locinfprix(Long.parseLong(p));
		return loc;
	}
	@Override
	public List<Location> afficherprixsuplocation(String p) {
		List<Location> loc;
		loc = (List<Location>) lr.locsupprix(Long.parseLong(p));
	return loc;
	}
	@Override
	public List<Location> afficherprixentrelocation(String p1,String p2) {
		List<Location> loc;
		loc = (List<Location>) lr.locentreprix(Long.parseLong(p1),Long.parseLong(p2));
	return loc;
	}
	@Override
	public List<Location> estimationP() {
		List<Location> loc=(List<Location>)lr.findAll();
		long prixM=200;
		long prixA=150;
		long prixV=300;
		for(Location locations:loc){
			long nbrechambre=locations.getNbre_chambre();
			long nbrepiece=locations.getNbre_piece();
			if(locations instanceof MaisonLocation){
				prixM=prixM+nbrechambre*100+nbrepiece*50;
				locations.setPrix(prixM);
				if(locations.getMeuble()==1){
					prixM=prixM+nbrechambre*50;
					locations.setPrix(prixM);
				}
				if(((MaisonLocation) locations).getEspaceVoiture()==1){
					prixM=prixM+150;
					locations.setPrix(prixM);
				}
				if(((MaisonLocation) locations).getTerrasses()==1){
					prixM=prixM+50;
					locations.setPrix(prixM);
				}
			} else if(locations instanceof AppartementLocation){
				prixA=prixA+nbrechambre*100+nbrepiece*50;
				locations.setPrix(prixA);
				if(locations.getMeuble()==1){
					prixA=prixA+nbrechambre*50;
					locations.setPrix(prixA);
				}
				if(((AppartementLocation) locations).getParking()==1){
					prixA=prixA+50;
					locations.setPrix(prixA);
				}
				if(((AppartementLocation) locations).getSurface_enfant()==1)
				{
					prixA=prixA+50;
					locations.setPrix(prixA);
				}
			}
			else{
			long nbreetage=((VillaLocation) locations).getNbre_etage();
			   prixV=prixV*nbreetage+nbrechambre*100+nbrepiece*50;
			   locations.setPrix(prixV);
			   if(((VillaLocation) locations).getPiscine()==1){
				   prixV=prixV+150;
				   locations.setPrix(prixV);
			   }
			   if(((VillaLocation) locations).getGarage()==1){
				   prixV=prixV+100;
				   locations.setPrix(prixV);
			   }
			   if(((VillaLocation) locations).getJardin()==1){
				   prixV=prixV+100;
				   locations.setPrix(prixV);
			   }
			   if(((VillaLocation) locations).getVue()=="mer"){
				   prixV=prixV+50;
				   locations.setPrix(prixV);
			   }
			}
			lr.save(locations)	;
		}
		
		return  loc;
	}
}
