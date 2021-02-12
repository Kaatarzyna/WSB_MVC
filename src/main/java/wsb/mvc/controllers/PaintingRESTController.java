package wsb.mvc.controllers;

import org.springframework.web.bind.annotation.*;
import wsb.mvc.models.Painting;
import wsb.mvc.services.PaintingService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("api")
public class PaintingRESTController {

    final PaintingService paintingService;

    public PaintingRESTController(PaintingService paintingService) {
        this.paintingService = paintingService;
    }

    @GetMapping("/")
    List<Painting> index() {
        return paintingService.findAllByName("");
    }

    @PostMapping("/")
    Painting save(@RequestBody Painting painting) {
        paintingService.save(painting);
        return painting;
    }

    @RequestMapping("exception")
    void exception() {
        throw new RuntimeException("COŚ POSZŁO NIE TAK");
    }

    @RequestMapping("customStatus")
    String customStatus(HttpServletResponse response) {
        response.setStatus(422);
        return "OHH NOO";
    }


}
