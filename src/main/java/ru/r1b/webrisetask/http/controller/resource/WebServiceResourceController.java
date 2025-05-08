package ru.r1b.webrisetask.http.controller.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.r1b.webrisetask.entity.WebService;

import java.util.UUID;
@RestController
@RequestMapping("/web-service")
public class WebServiceResourceController extends CommonResourceController<WebService> {
    public WebServiceResourceController(JpaRepository<WebService, UUID> repository, ObjectMapper objectMapper) {
        super(repository, objectMapper);
    }
}
