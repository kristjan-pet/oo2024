package ee.tlu.Kodutoo1.controller;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NumberController {
    List<Integer> numbrid = new ArrayList<>();

    @GetMapping("numbrid")  // brauser
    public List<Integer> saaNumbrid() {
        return numbrid;
    }

    @PostMapping("numbrid/{number}") // POST (postman)
    public List<Integer> lisaNumber(@PathVariable Integer number) {
        numbrid.add(number);
        return numbrid;
    }

    @DeleteMapping("numbrid/{index}") // DELETE
    public List<Integer> kustutaNumber(@PathVariable int index) {
        numbrid.remove(index);
        return numbrid;
    }

    @GetMapping("numbritearv")  // brauser
    public int saaNumbriteArv() {
        return numbrid.size();
    }

    @GetMapping("numbritesumma")  // brauser
    public int saaNumbriteSumma() {
        int summa = 0;
        for (int i = 0; i < numbrid.size(); i++) {
            summa += numbrid.get(i);
        }
        return summa;
    }

    @GetMapping("numbritekeskmine")  // brauser
    public int saaNumbriteKeskmine() {
        int summa = 0;
        for (Integer integer : numbrid) {
            summa += integer;
        }
        return summa / numbrid.size();
    }
}
