package edu.school21.sockets.services;

import edu.school21.sockets.models.User;
import edu.school21.sockets.repositories.UsersRepository;
import edu.school21.sockets.repositories.UsersRepositoryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public UsersServiceImpl(UsersRepositoryImpl usersRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void signUp(String username, String password) {
        usersRepository.save(new User(username, passwordEncoder.encode(password)));
    }
}
