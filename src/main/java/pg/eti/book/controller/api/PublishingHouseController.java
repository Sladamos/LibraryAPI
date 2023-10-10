package pg.eti.book.controller.api;

import pg.eti.book.dto.GetPublishingHouseResponse;
import pg.eti.book.dto.GetPublishingHousesResponse;
import pg.eti.book.dto.PatchPublishingHouseRequest;
import pg.eti.book.dto.PutPublishingHouseRequest;

import java.util.UUID;

public interface PublishingHouseController {

	GetPublishingHousesResponse getPublishingHouses();

	GetPublishingHouseResponse getPublishingHouse(UUID id);

	void putPublishingHouse(UUID id, PutPublishingHouseRequest request);

	void patchPublishingHouse(UUID id, PatchPublishingHouseRequest request);

	void deletePublishingHouse(UUID id);
}
