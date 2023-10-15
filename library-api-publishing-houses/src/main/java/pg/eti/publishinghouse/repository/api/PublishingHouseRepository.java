package pg.eti.publishinghouse.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pg.eti.publishinghouse.entity.PublishingHouse;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PublishingHouseRepository extends JpaRepository<PublishingHouse, UUID> {
	Optional<PublishingHouse> findByName(String publishingHouseName);
}
