package ee.tlu.Kodutoo1.controller;

import ee.tlu.Kodutoo1.entity.PCComponent;
import ee.tlu.Kodutoo1.repository.PCComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PCComponentController {

    @Autowired
    PCComponentRepository pcComponentRepository;

//    public PCComponentController(PCComponentRepository pcComponentRepository) {
//        this.pcComponentRepository = pcComponentRepository;
//    }

    @GetMapping("pcComponents")
    public List<PCComponent> getPcComponents() {
        return pcComponentRepository.findAll();
    }

    @DeleteMapping("pcComponents/{id}")
    public List<PCComponent> deletePCComponent(@PathVariable Long id) {
        pcComponentRepository.deleteById(id);
        return pcComponentRepository.findAll();
    }

    @PostMapping("pcComponents")
    public List<PCComponent> addPCComponent(@RequestBody PCComponent pcComponent) {
        pcComponentRepository.save(pcComponent);
        return pcComponentRepository.findAll();
    }
}
