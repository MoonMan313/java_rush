package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;


public class Program {
    private static final String URL = "jdbc:postgresql://localhost:5433/postgres";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(URL);
        ds.setUsername(USER_NAME);
        ds.setPassword(PASSWORD);

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(ds);

        User creator = new User(1L, "Stella", "stella", new ArrayList(), new ArrayList());
        User author = creator;
        Chatroom room = new Chatroom(1L,  "chat1", creator, new ArrayList());

        Optional<Message> messageOptional;
        try {
            messageOptional = repository.findById(1L);
            if (messageOptional.isPresent()) {
                Message msgs = messageOptional.get();
                System.out.println(msgs.getRoom().getId());
                msgs.setText("Bye");
                msgs.setDateTime(null);
                repository.update(msgs);
            } else {
                System.out.println("No message found for this ID.");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
