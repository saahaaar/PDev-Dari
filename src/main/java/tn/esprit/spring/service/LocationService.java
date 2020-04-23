package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entity.AppartementLocation;
import tn.esprit.spring.entity.Location;
import tn.esprit.spring.entity.MaisonLocation;
import tn.esprit.spring.entity.VillaLocation;

public interface LocationService {
	public MaisonLocation ajouterMlocation(MaisonLocation location);
	public AppartementLocation ajouterAlocation(AppartementLocation location);
	public VillaLocation ajouterVlocation(VillaLocation location);
    public List<Location> afficherTlocation();
    public List<AppartementLocation> afficherAlocation();
    public List<MaisonLocation> afficherMlocation();
    public List<VillaLocation> afficherVlocation();
    public MaisonLocation updateMlocation(MaisonLocation location);
    public AppartementLocation updateAlocation(AppartementLocation location);
    public VillaLocation updateVlocation(VillaLocation location);
    public void deletelocation(String id);
    public List<Location> afficherDinflocation(String d);
    public List<Location> afficherDsuplocation(String d);
    public List<Location> afficherDentrelocation(String d1,String d2);
    public List<Location> afficherprixinflocation(String p);
    public List<Location> afficherprixsuplocation(String p);
    public List<Location> afficherprixentrelocation(String p1,String p2);
    public List<Location> estimationP();
}
