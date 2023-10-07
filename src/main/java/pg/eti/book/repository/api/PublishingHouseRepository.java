package pg.eti.book.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pg.eti.book.entity.PublishingHouse;

import java.util.UUID;

@Repository
public interface PublishingHouseRepository extends JpaRepository<PublishingHouse, UUID> {
}
