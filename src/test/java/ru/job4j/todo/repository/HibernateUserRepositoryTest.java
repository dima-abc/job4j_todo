package ru.job4j.todo.repository;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;
import ru.job4j.todo.configuration.HibernateConfiguration;
import ru.job4j.todo.model.User;

import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * 3. Мидл
 * 3.3. HibernateТема
 * 3.3.2. Конфигурирование
 * 4. TODO list
 * HibernateUserRepository TEST.
 *
 * @author Dmitry Stepanov, user Dima_Nout
 * @since 03.04.2023
 */
class HibernateUserRepositoryTest {
    private static SessionFactory sf;
    private static HibernateUserRepository userRepository;

    private static void deleteUsers() {
        var crud = new CrudRepository(sf);
        crud.run("delete from Task as t where t.id >:tId",
                Map.of("tId", 0));
        crud.run("delete from Priority as p where p.id >:pId",
                Map.of("pId", 0));
        crud.run("delete from Category as c where c.id >:cId",
                Map.of("cId", 0));
        crud.run("delete from User as u where u.id >:uId",
                Map.of("uId", 0));
    }

    @BeforeAll
    public static void initRepository() {
        sf = HibernateConfigurationFromTest.getSFFromTest();
        var crud = new CrudRepository(sf);
        userRepository = new HibernateUserRepository(crud);
    }

    @AfterAll
    public static void closeSF() {
        sf.close();
    }

    @BeforeEach
    public void deleteBefore() {
        deleteUsers();
    }

    @AfterEach
    public void deleteAfter() {
        deleteUsers();
    }

    @Test
    void whenCreateUserThenReturnUserIdNotZero() {
        var user = new User(0, "user", "mail", "123", "UTC");
        var userActual = userRepository.create(user);

        assertThat(userActual.getId()).isGreaterThan(0);
        assertThat(userActual).isEqualTo(user);
    }

    @Test
    void whenFindByIdUserThenReturnUserOptional() {
        var user = new User(0, "user", "mail", "123", "UTC");
        userRepository.create(user);

        var userExpected = Optional.of(user);
        var userOptional = userRepository.findByIdUser(user.getId());

        assertThat(userOptional).usingRecursiveComparison().isEqualTo(userExpected);
    }

    @Test
    void whenFindByIdUserThenReturnEmpty() {
        var userActual = userRepository.findByIdUser(5);

        assertThat(userActual).isEmpty();
    }

    @Test
    void whenUpdateUserThenFindBuIdEquals() {
        var user = new User(0, "user", "mail", "123", "UTC");
        userRepository.create(user);
        user.setName("newName");
        user.setEmail("newEmail");
        user.setPassword("321");
        userRepository.update(user);

        var userInDb = userRepository.findByIdUser(user.getId());

        assertThat(userInDb.get()).usingRecursiveComparison().isEqualTo(user);
    }

    @Test
    void whenDeleteUserThenFindByIdReturnEmpty() {
        var user = new User(0, "user", "mail", "123", "UTC");
        userRepository.create(user);
        userRepository.delete(user.getId());
        var userInDb = userRepository.findByIdUser(user.getId());
        assertThat(userInDb).isEmpty();
    }

    @Test
    void whenFindUserByEmailAndPasswordThenReturnOptionalUser() {
        var user = new User(0, "user", "mail", "123", "UTC");
        userRepository.create(user);

        var actual = userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
        var expected = Optional.of(user);

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void whenFindUserByEmailAndPasswordThenReturnOptionalEmpty() {
        var actual = userRepository.findUserByEmailAndPassword("mail", "pass");

        assertThat(actual).isEmpty();
    }
}