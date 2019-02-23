package systems.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import systems.Message;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcMessageRepository implements MessageRepository {

    /*Основной класс для работы с базами данных*/
    private JdbcTemplate jdbc;

    @Autowired
    public JdbcMessageRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Message save(Message message) {
        jdbc.update(
            "insert into Message (name, email, messageText) values (?, ?, ?)",
            message.getName(), message.getEmail(), message.getMessageText());
        return message;
    }

    @Override
    public Message read(String name) {
        return jdbc.queryForObject(
                "select name, email, messageText from Message where name=?",
                this::mapRowToMessage, name);
    }

    private Message mapRowToMessage(ResultSet rs, int rowNum)
            throws SQLException {
        return new Message(
                rs.getString("name"),
                rs.getString("email"),
                rs.getString("messageText"));
    }

}
