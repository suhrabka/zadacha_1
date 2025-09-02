package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        try {

            userService.createUsersTable();
            System.out.println("Таблица users создана");

            // Добавляем 4 пользователей
            userService.saveUser("Иван", "Иванов", (byte) 25);
            userService.saveUser("Петр", "Петров", (byte) 30);
            userService.saveUser("Мария", "Сидорова", (byte) 28);
            userService.saveUser("Анна", "Смирнова", (byte) 35);

            System.out.println("Пользователи добавлены в базу данных");

            // Получаем всех пользователей и выводим их
            System.out.println("\nСписок всех пользователей:");
            List<User> users = userService.getAllUsers();
            for (User user : users) {
                System.out.println(user);
            }

            // Очищаем таблицу
            userService.cleanUsersTable();
            System.out.println("\nТаблица users очищена");

            // Удаляем таблицу
            userService.dropUsersTable();
            System.out.println("Таблица users удалена");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
