package wsb.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import wsb.mvc.services.PaintingService;

@Controller
public class PaintingController {

    private final PaintingService paintingService;

    public PaintingController(PaintingService paintingService) {
        this.paintingService = paintingService;
    }

    @RequestMapping("/")
    public ModelAndView paintings(@RequestParam(required = false, defaultValue = "") String paintingName) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("paintings", paintingService.findAllByName(paintingName));
        return modelAndView;
    }
}
