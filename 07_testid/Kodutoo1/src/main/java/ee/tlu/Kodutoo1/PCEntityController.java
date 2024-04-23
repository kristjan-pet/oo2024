package ee.tlu.Kodutoo1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class PCEntityController {
    PCRepository pcRepository;

    public PCEntityController(PCRepository pcRepository) {
        this.pcRepository = pcRepository;
    }

    //List<PCEntity> arvutid = new ArrayList<>();

    // (brauser) http://localhost:8080/api/arvutid/
    @GetMapping("arvutid")
    public List<PCEntity> saaArvutid() {
        return pcRepository.findAll();
    }

    // (POST) http://localhost:8080/api/arvutid/Lenovo/euronics/2600
    @PostMapping("arvutid/{nimetus}/{valmistaja}/{maksumus}")
    public List<PCEntity> lisaNumber(@PathVariable String nimetus, @PathVariable String valmistaja, @PathVariable int maksumus) {
        PCEntity arvuti = new PCEntity(nimetus, valmistaja, maksumus);
        pcRepository.save(arvuti);
        return pcRepository.findAll();
    }

    @PostMapping("arvutid") // POST (postman)
    public List<PCEntity> lisaPC(@RequestBody PCEntity pcEntity) {
        pcRepository.save(pcEntity);
        return pcRepository.findAll();
    }

    // (DELETE) http://localhost:8080/api/arvutid/0
    @DeleteMapping("arvutid/{nimetus}")
    public List<PCEntity> kustutaArvuti(@PathVariable String nimetus) {
        pcRepository.deleteById(nimetus);
        return pcRepository.findAll();
    }

    // (PUT) http://localhost:8080/api/arvutid?index=0&nimetus="MSI"&(jne)
    @PutMapping("arvutid")
    public List<PCEntity> muudaArvuti(@RequestParam int index, @RequestParam String nimetus, @RequestParam String valmistaja, @RequestParam Integer maksumus) {
        PCEntity arvuti = new PCEntity(nimetus, valmistaja, maksumus);
        pcRepository.save(arvuti);
        return pcRepository.findAll();
    }

    // (brauser) http://localhost:8080/api/arvutid/0
    @GetMapping("arvutid/{nimetus}")
    public PCEntity saaYksArvuti(@PathVariable String nimetus) {
        return pcRepository.findById(nimetus).get();
    }

    @GetMapping("arvutitemaksumusesumma")  // brauser
    public int saaArvutiteMakusmuseSumma() {
        int summa = 0;
        for (int i = 0; i < pcRepository.findAll().size(); i++) {
            summa += pcRepository.findAll().get(i).maksumus;
        }
        return summa;
    }
}
