package hiber.service;

import hiber.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> listUsers();

    @Query("SELECT u FROM User u JOIN u.car c WHERE c.model = :model AND c.series = :series")
    User getUserByCarModelAndSeries(@Param("model") String model, @Param("series") int series);
}
