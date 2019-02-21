package systems.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(("/generic"))
public class GenericController {

    @GetMapping
    public String generic() {
        return "/generic";
    }
}
