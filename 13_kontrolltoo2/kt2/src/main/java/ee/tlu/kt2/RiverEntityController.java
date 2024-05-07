package ee.tlu.kt2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RiverEntityController {
    @Autowired
    RiverRepository riverRepository;

    @GetMapping("rivers")
    public List<RiverEntity> saaJoed() {
        return riverRepository.findAll();
    }

    @PostMapping("rivers")
    public List<RiverEntity> lisaJogi(@RequestBody RiverEntity riverEntity) {
        riverRepository.save(riverEntity);
        return riverRepository.findAll();
    }

    @DeleteMapping("rivers/{id}")
    public List<RiverEntity> kustutaJogi(@PathVariable Long id) {
        riverRepository.deleteById(id);
        return riverRepository.findAll();
    }

    @GetMapping("river_length/{id}")
    public double leiaPikkus(@PathVariable Long id) {
        Optional<RiverEntity> riverOptional = riverRepository.findById(id);
        if (riverOptional.isPresent()) {
            RiverEntity river = riverOptional.get();
            double distance = Math.round(Math.sqrt(Math.pow(river.getLahtmex() - river.getSuudmex(), 2) +
                    Math.pow(river.getLahtmey() - river.getSuudmey(), 2)) * 111); //see on umbes value, kus 1 degree -> 111 km (google'dasin ja panin et ilus oleks)
            return distance;
        } else {
            throw new RuntimeException("Jõge primaarvõtmega" + id + " ei ole olemas.");
        }
    }

    @GetMapping("fastest_river")
    public List<RiverEntity> leiaKiireimJogi() {
        List<RiverEntity> rivers = riverRepository.findAll();
        List<RiverEntity> fastestRivers = new ArrayList<>();
        double maxSpeed = rivers.get(0).getKiirus();
        for (RiverEntity river : rivers) {
            double speed = river.getKiirus();
            if (speed > maxSpeed) {
                maxSpeed = speed;
                fastestRivers.clear();
                fastestRivers.add(river);
            } else if (speed == maxSpeed) {
                fastestRivers.add(river);
            }
        }

        return fastestRivers;
    }
}
