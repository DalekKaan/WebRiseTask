package ru.r1b.webrisetask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.r1b.webrisetask.entity.WebService;

import java.util.UUID;

public interface WebServiceRepository extends JpaRepository<WebService, UUID> {

}
