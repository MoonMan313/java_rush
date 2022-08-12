package edu.school21.sockets.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.sockets.models.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;


public class UsersRepositoryImpl implements UsersRepository {
    public JdbcTemplate jdbcTemplate;

    public UsersRepositoryImpl(HikariDataSource hikariDataSource) {
        jdbcTemplate = new JdbcTemplate(hikariDataSource);
    }

    @Override
    public User findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id = ?",
                        (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2), rs.getString(3)),
                        new Object[]{id})
                .stream()
                .findAny()
                .orElse(null);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users",
                (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2), rs.getString(3)));
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update("INSERT INTO users (email, password) VALUES (?, ?);", entity.getEmail(), entity.getPassword());
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update("UPDATE users SET email = ?, password = ? WHERE id = ?;", entity.getEmail(), entity.getPassword(), entity.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        User user = jdbcTemplate.query("SELECT * FROM users WHERE email = ?",
                        (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2), rs.getString(3)),
                        new Object[]{email})
                .stream()
                .findAny()
                .orElse(null);
        return Optional.of(user);
    }
}
