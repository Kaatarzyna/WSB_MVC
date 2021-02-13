package wsb.mvc.controllers;

import org.springframework.web.bind.annotation.*;
import wsb.mvc.models.Painting;
import wsb.mvc.services.PaintingService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @RequestMapping("auth")
    String auth(HttpServletResponse response, HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        response.setHeader("Authorization", "Bearer 123");
        return authorizationHeader;
    }

    @RequestMapping("cookie")
    String cookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        System.out.println("Cookies: " + Arrays.stream(cookies).map(Cookie::getValue).collect(Collectors.toList()));

        Cookie newCookie = new Cookie("cookie_serwer", "witam");
        newCookie.setMaxAge(400);

        response.addCookie(newCookie);

        return "OK";
    }
}
