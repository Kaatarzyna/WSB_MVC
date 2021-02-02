package wsb.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import wsb.mvc.models.Painting;
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

    @RequestMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("painting", new Painting());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Painting painting) {
        paintingService.save(painting);
        return "redirect:/";
    }
}
