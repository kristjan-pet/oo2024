package ee.tlu.Proovikontrolltoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ToodeController {

    //@Autowired
    ToodeRepository toodeRepository;

    public ToodeController(ToodeRepository toodeRepository) {
        this.toodeRepository = toodeRepository;
    }

    @GetMapping("Tooted")
    public List<Toode> getTooted() {
        return toodeRepository.findAll();
    }

    @PostMapping("Tooted")
    public List<Toode> postToode(@RequestBody Toode toode) {
        toodeRepository.save(toode);
        return toodeRepository.findAll();
    }

    @DeleteMapping("Tooted/{id}")
    public List<Toode> deleteToode(@RequestBody Long id) {
        toodeRepository.deleteById(id);
        return toodeRepository.findAll();
    }

    @GetMapping("toote-hind-vahemik/{min}/{max}")
    public List<Toode> tooteHindVahemik(@PathVariable double min, @PathVariable double max) {
        return toodeRepository.findByHindBetween(min, max);
    }

    @GetMapping("max-hinnaga-toode")
    public Toode maxHinnagaToode() {
        return toodeRepository.findFirstByHindNotNullOrderByHindDesc();
    }
}
