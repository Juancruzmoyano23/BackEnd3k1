package ar.edu.utnfrc.backend.services;

import java.util.HashMap;
import java.util.Map;
import ar.edu.utnfrc.backend.entities.Designers;
import ar.edu.utnfrc.backend.repositories.DesignerRepository;


public class DesignerService {

    private final DesignerRepository DR;
    private final Map<String, Designers> designers;

    public DesignerService() {
        DR = new DesignerRepository();
        designers = new HashMap<>();
    }

    public Designers getOrCreateDesigner(String designerName) {
        if (designers.containsKey(designerName)) { 
            return designers.get(designerName);
        }
        Designers designer = new Designers("designer" + designerName);
        designers.put(designerName, designer);
        DR.add(designer);
        return designer;
    }
}
