package ar.edu.utnfrc.backend.services;

import java.util.HashMap;
import java.util.Map;
import ar.edu.utnfrc.backend.entities.Publishers;
import ar.edu.utnfrc.backend.repositories.PublisherRepository;


public class PublisherService {

    private final PublisherRepository PR;
    private final Map<String, Publishers> publishers;

    public PublisherService() {
        PR = new PublisherRepository();
        publishers = new HashMap<>();
    }

    public Publishers getOrCreatePublisher(String publisherName) {
        if (publishers.containsKey(publisherName)) { 
            return publishers.get(publisherName);
        }
        Publishers publisher = new Publishers("publisher" + publisherName);
        publishers.put(publisherName, publisher);
        PR.add(publisher);
        return publisher;
    }
}
