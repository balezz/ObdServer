package systems.data;


import systems.Message;

public interface MessageRepository {

    /*метод записи в базу данных*/
    public Message save(Message message);

    /*метод чтения из базы данных*/
    Message read(String name);

}
