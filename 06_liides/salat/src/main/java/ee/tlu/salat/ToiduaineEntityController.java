package ee.tlu.salat;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class ToiduaineEntityController {
    ToiduaineRepository toiduaineRepository;

    public ToiduaineEntityController(ToiduaineRepository toiduaineRepository) {
        this.toiduaineRepository = toiduaineRepository;
    }

    //List<ToiduaineEntity> toiduained = new ArrayList<>();

    @GetMapping("toiduained")  // brauser
    public List<ToiduaineEntity> saaToiduained() {
        return toiduaineRepository.findAll();
    }

    @PostMapping("toiduained/{nimi}/{valk}/{rasv}/{sysivesik}") // POST (postman)
    public List<ToiduaineEntity> lisaToiduaine(@PathVariable String nimi, @PathVariable int valk, @PathVariable int rasv, @PathVariable int sysivesik) {
        if (valk + rasv + sysivesik > 100) {
            return toiduaineRepository.findAll();
        }
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduaineRepository.save(toiduaine);
        return toiduaineRepository.findAll();
    }

    @PostMapping("toiduained") // POST (postman)
    public List<ToiduaineEntity> lisaToiduaine(@RequestBody ToiduaineEntity toiduaineEntity) {
        if (toiduaineEntity.valk + toiduaineEntity.rasv + toiduaineEntity.sysivesik > 100) {
            return toiduaineRepository.findAll();
        }
        //ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        toiduaineRepository.save(toiduaineEntity);
        return toiduaineRepository.findAll();
    }

    @DeleteMapping("toiduained/{nimi}")  // DELETE
    public List<ToiduaineEntity> kustutaToiduaine(@PathVariable String nimi) {
        toiduaineRepository.deleteById(nimi);
        return toiduaineRepository.findAll();
    }

    // http://localhost:8080/api/toiduained?index=0&nimetus="munad"
    @PutMapping("toiduained") // PUT
    public List<ToiduaineEntity> muudaToiduaine(@RequestParam int index, @RequestParam String nimi, @RequestParam int valk, @RequestParam int rasv, @RequestParam int sysivesik) {
        ToiduaineEntity toiduaine = new ToiduaineEntity(nimi, valk, rasv, sysivesik);
        //toiduained.set(index, toiduaine);
        toiduaineRepository.save(toiduaine);
        return toiduaineRepository.findAll();
    }

    @GetMapping("toiduained/{nimi}") // brauser
    public ToiduaineEntity saaYksToiduaine(@PathVariable String nimi) {
        return toiduaineRepository.findById(nimi).get();
    }

    @GetMapping("toiduainedte-koguarv") // brauser
    public int toiduaineteKoguarv() {
        return toiduaineRepository.findAll().size();
    }

}
