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

/*
* Класс предназначен для управления запросами
* GET и POST к домашней странице
* */
@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {

    /*
    * Метод обрабатывает запрос GET,
    * добавляет в модель аттрибут message
    * и возвращает домашнюю страницу /index
    *
    * @param model  модель данных, обрабатываемых контроллером
    * */
    @GetMapping
    public String showHome(Model model) {
        model.addAttribute("message", new Message());
        return "/index";
    }


    /*
    * Метод обрабатывает запрос POST
    * записывает полученное message в базу данных
    * а также назначает отображаемым аттрибутом модели
    *
    * @param message    аттрибут модели, отображается посредством Thymeleaf
    * @param errors     ошибки в сообщении, если имеются - редирект в /
    * @param model      модель данных, обрабатываемых контроллером
    * */
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
