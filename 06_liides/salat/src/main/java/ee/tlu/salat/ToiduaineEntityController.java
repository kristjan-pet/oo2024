package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ToiduaineEntityController {
    List<ToiduaineEntity> toiduained = new ArrayList<>();

    @GetMapping("toiduained")  // brauser
    public List<ToiduaineEntity> saaToiduained() {
        return toiduained;
    }

    @PostMapping("toiduained/{nimi}/{valk}/{rasv}/{sysivesik}") // POST (postman)
    public List<ToiduaineEntity> lisaToiduaine(@PathVariable String nimi, @PathVariable int valk, @PathVariable int rasv, @PathVariable int sysivesik) {
        if (valk + rasv + sysivesik > 100) {
            return toiduained;
        }
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduained.add(toiduaine);
        return toiduained;
    }

    @DeleteMapping("toiduained/{index}")  // DELETE
    public List<ToiduaineEntity> kustutaToiduaine(@PathVariable int index) {
        toiduained.remove(index);
        return toiduained;
    }

    // http://localhost:8080/api/toiduained?index=0&nimetus="munad"
    @PutMapping("toiduained") // PUT
    public List<ToiduaineEntity> muudaToiduaine(@RequestParam int index, @RequestParam String nimi, @RequestParam int valk, @RequestParam int rasv, @RequestParam int sysivesik) {
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduained.set(index, toiduaine);
        return toiduained;
    }

    @GetMapping("toiduained/{index}") // brauser
    public ToiduaineEntity saaYksToiduaine(@PathVariable int index) {
        return toiduained.get(index);
    }

}
