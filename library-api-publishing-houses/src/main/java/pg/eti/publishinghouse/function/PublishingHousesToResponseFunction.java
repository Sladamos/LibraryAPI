package pg.eti.publishinghouse.function;

import org.springframework.stereotype.Component;
import pg.eti.publishinghouse.dto.GetPublishingHousesResponse;
import pg.eti.publishinghouse.entity.PublishingHouse;

import java.util.List;
import java.util.function.Function;

@Component
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
