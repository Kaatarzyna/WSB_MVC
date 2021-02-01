package wsb.jsp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import wsb.jsp.repositories.PaintingRepository;

@Controller
public class PaintingController {

    private final PaintingRepository paintingRepository;

    public PaintingController(PaintingRepository paintingRepository) {
        this.paintingRepository = paintingRepository;
    }

    @RequestMapping("/")
    public ModelAndView paintings(@RequestParam(required = false, defaultValue = "") String paintingName) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("paintings", paintingRepository.findAll(paintingName));
        return modelAndView;
    }



}
