package pg.eti.book.function;

import pg.eti.book.dto.GetPublishingHousesResponse;
import pg.eti.book.entity.PublishingHouse;

import java.util.List;
import java.util.function.Function;

public class PublishingHousesToResponseFunction implements Function<List<PublishingHouse>, GetPublishingHousesResponse> {

	@Override
	public GetPublishingHousesResponse apply(List<PublishingHouse> publishingHouses) {
		return GetPublishingHousesResponse.builder()
				.publishingHouses(publishingHouses.stream()
						.map(publishingHouse -> GetPublishingHousesResponse.PublishingHouse.builder()
								.id(publishingHouse.getId())
								.name(publishingHouse.getName())
								.build())
						.toList())
				.build();
	}
}
