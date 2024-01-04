package hiber;

import hiber.config.AppConfig;

import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = User.builder()
                .firstName("Name1")
                .lastName("LastName1")
                .email("user1@gmail.com")
                .build();

        User user2 = User.builder()
                .firstName("Name2")
                .lastName("LastName2")
                .email("user2@gmail.com")
                .build();

        User user3 = User.builder()
                .firstName("Name3")
                .lastName("LastName3")
                .email("user3@gmail.com")
                .build();

        User user4 = User.builder()
                .firstName("Name4")
                .lastName("LastName4")
                .email("user4@gmail.com")
                .build();

        User user5 = User.builder()
                .firstName("Name5")
                .lastName("LastName5")
                .email("user5@gmail.com")
                .build();

        Car car1 = Car.builder()
                .model("car1")
                .series(1)
                .build();
        Car car2 = Car.builder()
                .model("car2")
                .series(2)
                .build();
        Car car3 = Car.builder()
                .model("car3")
                .series(3)
                .build();
        Car car4 = Car.builder()
                .model("car4")
                .series(4)
                .build();
        Car car5 = Car.builder()
                .model("car5")
                .series(5)
                .build();

        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);
        user4.setCar(car4);
        user5.setCar(car5);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);
        userService.add(user5);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }

        System.out.println("Поиск по модели и серии: " + userService.getUserByCarModelAndSeries("car1", 1));
        System.out.println("Поиск по модели и серии: " + userService.getUserByCarModelAndSeries("car2", 2));
        System.out.println("Поиск по модели и серии: " + userService.getUserByCarModelAndSeries("car3", 3));
        System.out.println("Поиск по модели и серии: " + userService.getUserByCarModelAndSeries("car4", 4));
        System.out.println("Поиск по модели и серии: " + userService.getUserByCarModelAndSeries("car5", 5));

        context.close();
    }
}
