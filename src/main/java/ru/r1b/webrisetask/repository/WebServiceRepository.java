package ru.r1b.webrisetask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.r1b.webrisetask.entity.WebService;

import java.util.List;
import java.util.UUID;

public interface WebServiceRepository extends JpaRepository<WebService, UUID> {

    @Query(value = """
            SELECT id, name FROM (SELECT s.id, s.name, count(s.id) as cnt
                           FROM users u
                                    CROSS JOIN LATERAL JSONB_ARRAY_ELEMENTS(u.subscriptions) AS e(usr)
                                    INNER JOIN subscriptions s ON (e.usr ->> 0)::text::uuid = s.id
                           GROUP BY s.id, s.name) m
            ORDER BY cnt DESC
            LIMIT 3""", nativeQuery = true)
    public List<WebService> findTop();
}
