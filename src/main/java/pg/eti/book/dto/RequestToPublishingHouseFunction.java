package pg.eti.book.dto;

import pg.eti.book.entity.PublishingHouse;

import java.util.UUID;
import java.util.function.BiFunction;

public class RequestToPublishingHouseFunction implements BiFunction<UUID, PutPublishingHouseRequest, PublishingHouse> {

	@Override
	public PublishingHouse apply(UUID uuid, PutPublishingHouseRequest putPublishingHouseRequest) {
		return PublishingHouse.builder()
				.id(uuid)
				.name(putPublishingHouseRequest.getName())
				.creationYear(putPublishingHouseRequest.getCreationYear())
				.build();
	}
}
