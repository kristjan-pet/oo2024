package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToiduaineController {
    List<String> toiduained = new ArrayList<>();

    @GetMapping("toiduained")  // brauser
    public List<String> saaToiduained() {
        return toiduained;
    }

    @PostMapping("toiduained/{toiduaine}") // POST (postman)
    public List<String> lisaToiduaine(@PathVariable String toiduaine) {
        toiduained.add(toiduaine);
        return toiduained;
    }

    @DeleteMapping("toiduained/{index}")  // DELETE
    public List<String> kustutaToiduaine(@PathVariable int index) {
        toiduained.remove(index);
        return toiduained;
    }

    @PutMapping("toiduained/{index}/{newValue}") // PUT
    public List<String> muudaToiduaine(@PathVariable int index, @PathVariable String newValue) {
        toiduained.set(index, newValue);
        return toiduained;
    }

    @GetMapping("toiduained/{index}") // brauser
    public String saaYksToiduaine(@PathVariable int index) {
        return toiduained.get(index);
    }

    @GetMapping("tere/{nimi}")
    public String hello(@PathVariable String nimi) {
        return "Tere, " + nimi;
    }

    @GetMapping("korruta/{arv1}/{arv2}")
    public int multiply(@PathVariable int arv1, @PathVariable int arv2) {
        return arv1 * arv2;
    }
}
