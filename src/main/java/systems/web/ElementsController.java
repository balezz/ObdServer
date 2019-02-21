package systems.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/elements")
public class ElementsController {

    @GetMapping
    public String elements() {
        return "/elements";
    }
}
