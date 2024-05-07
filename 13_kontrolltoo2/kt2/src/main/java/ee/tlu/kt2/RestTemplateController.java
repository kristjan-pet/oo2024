package ee.tlu.kt2;

import ee.tlu.kt2.floods.FloodArea;
import ee.tlu.kt2.floods.Item;
import ee.tlu.kt2.floods.Root;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestTemplateController {
    @GetMapping("saa-info")
    public List<Gazzeeter> getInfo() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://marineregions.org/rest/getGazetteerTypes.json/";
        ResponseEntity<Gazzeeter[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Gazzeeter[].class);
        return List.of(response.getBody());
    }

    @GetMapping("floods")
    public List<Root> getFloods() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://environment.data.gov.uk/flood-monitoring/id/floods";
        ResponseEntity<Root[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Root[].class);
        return List.of(response.getBody());
    }

    @GetMapping("floods/{nimi}")
    public List<Root> getFloodName(@PathVariable String nimi) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://environment.data.gov.uk/flood-monitoring/id/floods";
        ResponseEntity<Root[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Root[].class);
        Root[] allFloods = response.getBody();
        List<Root> filteredFloods = new ArrayList<>();

        for (Root root : allFloods) {
            boolean containsAreaName = false;
            for (Item item : root.getItems()) {
                if (item.eaAreaName.equalsIgnoreCase(nimi)) {
                    containsAreaName = true;
                    break;
                }
            }
            if (containsAreaName) {
                filteredFloods.add(root);
            }
        }

        return filteredFloods;
    }
}
