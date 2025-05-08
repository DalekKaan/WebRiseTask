package ru.r1b.webrisetask.http.controller.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.r1b.webrisetask.entity.User;

import java.util.UUID;
@RestController
@RequestMapping("/users")
public class UserResourceController extends CommonResourceController<User>{
    public UserResourceController(JpaRepository<User, UUID> repository, ObjectMapper objectMapper) {
        super(repository, objectMapper);
    }
}
