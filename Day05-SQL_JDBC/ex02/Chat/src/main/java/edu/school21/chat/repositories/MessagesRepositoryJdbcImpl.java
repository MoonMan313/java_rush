package edu.school21.chat.repositories;

import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{

    private final DataSource ds;

    public MessagesRepositoryJdbcImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Optional<Message> massage;
        String query = "SELECT * FROM chat.msgs WHERE id = " + id;

        Connection connection = ds.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        if (!resultSet.next()) {
            return Optional.empty();
        }

        massage = Optional.of(new Message(resultSet.getLong("id"), new User("user", "user"),
                new Chatroom("room"),
                resultSet.getString("message"),
                resultSet.getTimestamp("time").toLocalDateTime()));

        statement.cancel();
        connection.close();

        return massage;
    }

    @Override
    public void save(Message message) {
        String query = "INSERT INTO chat.msgs (room_id, sender, message, time) VALUES (?, ?, '" + message.getText()  + "', '" + message.getDateTime() + "');";

        try(Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setLong(1, message.getRoom().getId());
            statement.setLong(2, message.getAuthor().getId());

            statement.execute();

            ResultSet key = statement.getGeneratedKeys();
            key.next();
            message.setId(key.getLong("id"));
        } catch (SQLException e) {
            throw new NotSavedSubEntityException();
        }
    }
}
