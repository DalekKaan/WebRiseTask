package ru.r1b.webrisetask.http.controller.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;
import ru.r1b.webrisetask.entity.User;
import ru.r1b.webrisetask.entity.WebService;

import java.util.Set;
import java.util.UUID;
@RestController
@RequestMapping("/users")
public class UserResourceController extends CommonResourceController<User>{
    public UserResourceController(JpaRepository<User, UUID> repository, ObjectMapper objectMapper) {
        super(repository, objectMapper);
    }

    @GetMapping("/{id}/subscriptions")
    public Set<WebService> addSubscription(@PathVariable UUID id) {
        User user = this.getOne(id);
        return user.getSubscriptions();
    }

    @PostMapping("/{id}/subscriptions")
    public WebService addSubscription(@PathVariable UUID id, @RequestBody WebService webService) {
        // todo: validation
        User user = this.getOne(id);
        user.getSubscriptions().add(webService);
        this.repository.save(user);
        return webService;
    }

    @DeleteMapping("/{id}/subscriptions/{sub}")
    public WebService deleteSubscription(@PathVariable UUID id, @PathVariable WebService sub) {
        // todo: validation
        User user = this.getOne(id);
        user.getSubscriptions().remove(sub);
        this.repository.save(user);
        return sub;
    }
}
