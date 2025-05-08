package ru.r1b.webrisetask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.r1b.webrisetask.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
