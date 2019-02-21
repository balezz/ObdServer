package systems.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import systems.Message;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String showHome(Model model) {
        model.addAttribute("message", new Message());
        return "/index";
    }

    @PostMapping
    public String processMessage(@Valid @ModelAttribute("message") Message message,
                                 Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "/";
        }

        // Storing message

        log.info("Recieved new message!");
        return "confirmOk";
    }


}
