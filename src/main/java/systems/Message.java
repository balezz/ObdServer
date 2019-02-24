package systems;

import lombok.Data;

/*
* Класс с данными сообщения, которое пользователь
* оставляет при обращении через форму обратной связи
* на главной странице
* */
@Data
public class Message {

    /*Имя пользователя*/
    private String name;

    /*Почтовый ящик для обратной связи*/
    private String email;

    /*Текст сообщения*/
    private String messageText;

    /*Конструктор, переопределен для создания новых сообщений*/
    public Message(String name, String email, String messageText) {
        this.name = name;
        this.email = email;
        this.messageText = messageText;
    }
}
