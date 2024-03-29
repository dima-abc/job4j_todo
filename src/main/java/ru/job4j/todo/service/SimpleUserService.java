package ru.job4j.todo.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.job4j.todo.model.User;
import ru.job4j.todo.model.dto.TimeZoneDto;
import ru.job4j.todo.repository.UserRepository;

import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 3. Мидл
 * 3.3. HibernateТема
 * 3.3.2. Конфигурирование
 * 4. TODO list
 * SimpleUserService реализация бизнес логики обработки модели User
 *
 * @author Dmitry Stepanov, user Dima_Nout
 * @since 20.03.2023
 */
@Service
@AllArgsConstructor
@Slf4j
public class SimpleUserService implements UserService {
    private final UserRepository userRepository;

    @Override
    public Optional<User> create(User user) {
        Optional<User> result = Optional.empty();
        try {
            userRepository.create(user);
            result = Optional.of(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Optional<User> findByIdUser(int userId) {
        return userRepository.findByIdUser(userId);
    }

    @Override
    public boolean update(User user) {
        try {
            userRepository.update(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int userId) {
        try {
            userRepository.delete(userId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Optional<User> findUserByEmailAndPassword(String email, String password) {
        return userRepository.findUserByEmailAndPassword(email, password);
    }

    /**
     * Метод возвращает коллекцию часовых зон в формате
     *
     * @return Collection
     */
    @Override
    public Collection<TimeZone> getAllTimeZoneGMT() {
        return ZoneId.getAvailableZoneIds()
                .stream()
                .map(TimeZone::getTimeZone)
                .collect(Collectors.toList());
    }
}
