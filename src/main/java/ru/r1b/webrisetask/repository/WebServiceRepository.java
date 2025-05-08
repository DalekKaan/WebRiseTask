package ru.r1b.webrisetask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.r1b.webrisetask.entity.Subscription;

import java.util.List;
import java.util.UUID;

public interface WebServiceRepository extends JpaRepository<Subscription, UUID> {

    @Query(value = """
            SELECT id, name FROM (
                        SELECT s.id, s.name, count(us.*) AS cnt
                        FROM subscriptions s
                                 LEFT JOIN users_subscriptions us ON s.id = us.subscriptions_id
                        GROUP BY s.id, s.name
                ) m
            ORDER BY cnt DESC
            LIMIT ?1""", nativeQuery = true)
    List<Subscription> findTop(int limit);
}
