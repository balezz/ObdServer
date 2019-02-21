package systems;

import lombok.Data;

@Data
public class Message {
    private int id;
    private String name;
    private String email;
    private String messageText;
}
