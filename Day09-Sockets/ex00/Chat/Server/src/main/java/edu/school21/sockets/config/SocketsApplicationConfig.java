package edu.school21.sockets.config;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.sockets.repositories.UsersRepository;
import edu.school21.sockets.repositories.UsersRepositoryImpl;
import edu.school21.sockets.services.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@ComponentScan("edu.school21.sockets")
@PropertySource("classpath:db.properties")
public class SocketsApplicationConfig {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;
    @Value("${db.driver.name}")
    private String driver;

    @Bean
    public UsersServiceImpl usersService() {
        return new UsersServiceImpl(usersRepository(), bCryptPasswordEncoder());
    }

    @Bean
    public UsersRepositoryImpl usersRepository() {
        return new UsersRepositoryImpl(hikariDataSource());
    }

    @Bean
    public HikariDataSource hikariDataSource() {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setJdbcUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driver);

        return dataSource;
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
