package ru.r1b.webrisetask.http.controller.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.r1b.webrisetask.entity.WebService;
import ru.r1b.webrisetask.repository.WebServiceRepository;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/subscriptions")
public class WebServiceResourceController extends CommonResourceController<WebService> {
    public WebServiceResourceController(JpaRepository<WebService, UUID> repository, ObjectMapper objectMapper) {
        super(repository, objectMapper);
    }


    @GetMapping("/top")
    public List<WebService> getTop() {
        return ((WebServiceRepository) repository).findTop();
    }
}
