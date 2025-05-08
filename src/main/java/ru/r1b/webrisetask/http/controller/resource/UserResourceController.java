package ru.r1b.webrisetask.http.controller.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;
import ru.r1b.webrisetask.entity.Subscription;
import ru.r1b.webrisetask.entity.User;

import java.util.Set;
import java.util.UUID;
@RestController
@RequestMapping("/users")
public class UserResourceController extends CommonResourceController<User>{
    public UserResourceController(JpaRepository<User, UUID> repository, ObjectMapper objectMapper) {
        super(repository, objectMapper);
    }

    @GetMapping("/{id}/subscriptions")
    public Set<Subscription> getSubscription(@PathVariable UUID id) {
        User user = this.getOne(id);
        return user.getSubscriptions();
    }

    @PostMapping("/{id}/subscriptions")
    public Subscription addSubscription(@PathVariable UUID id, @RequestBody Subscription subscription) {
        // todo: validation
        User user = this.getOne(id);
        user.getSubscriptions().add(subscription);
        this.repository.save(user);
        return subscription;
    }

    @DeleteMapping("/{id}/subscriptions/{sub}")
    public Subscription deleteSubscription(@PathVariable UUID id, @PathVariable Subscription sub) {
        // todo: validation
        User user = this.getOne(id);
        user.getSubscriptions().remove(sub);
        this.repository.save(user);
        return sub;
    }
}
