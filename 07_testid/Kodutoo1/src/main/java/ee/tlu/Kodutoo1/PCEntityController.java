package ee.tlu.Kodutoo1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PCEntityController {
    List<PCEntity> arvutid = new ArrayList<>();

    // (brauser) http://localhost:8080/api/arvutid/
    @GetMapping("arvutid")
    public List<PCEntity> saaArvutid() {
        return arvutid;
    }

    // (POST) http://localhost:8080/api/arvutid/Lenovo/euronics/2600
    @PostMapping("arvutid/{nimetus}/{valmistaja}/{maksumus}")
    public List<PCEntity> lisaNumber(@PathVariable String nimetus, @PathVariable String valmistaja, @PathVariable int maksumus) {
        PCEntity arvuti = new PCEntity(nimetus, valmistaja, maksumus);
        arvutid.add(arvuti);
        return arvutid;
    }

    // (DELETE) http://localhost:8080/api/arvutid/0
    @DeleteMapping("arvutid/{index}")
    public List<PCEntity> kustutaArvuti(@PathVariable int index) {
        arvutid.remove(index);
        return arvutid;
    }

    // (PUT) http://localhost:8080/api/arvutid?index=0&nimetus="MSI"&(jne)
    @PutMapping("arvutid")
    public List<PCEntity> muudaArvuti(@RequestParam int index, @RequestParam String nimetus, @RequestParam String valmistaja, @RequestParam Integer maksumus) {
        PCEntity arvuti = new PCEntity(nimetus, valmistaja, maksumus);
        arvutid.set(index, arvuti);
        return arvutid;
    }

    // (brauser) http://localhost:8080/api/arvutid/0
    @GetMapping("arvutid/{index}")
    public PCEntity saaYksArvuti(@PathVariable int index) {
        return arvutid.get(index);
    }

    @GetMapping("arvutitemaksumusesumma")  // brauser
    public int saaArvutiteMakusmuseSumma() {
        int summa = 0;
        for (int i = 0; i < arvutid.size(); i++) {
            summa += arvutid.get(i).maksumus;
        }
        return summa;
    }
}
