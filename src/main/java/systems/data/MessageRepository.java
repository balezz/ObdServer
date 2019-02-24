package systems.data;


import systems.Message;

/* Интерфейс для классов, связывающий объекты класса Message
 * в памяти с таблицами баз данных
 */
public interface MessageRepository {

    /*метод записи в базу данных*/
    Message save(Message message);

    /*метод чтения из базы данных*/
    Message read(String name);

}
