package pg.eti.publishinghouse.function;

import org.springframework.stereotype.Component;
import pg.eti.publishinghouse.dto.GetPublishingHouseResponse;
import pg.eti.publishinghouse.entity.PublishingHouse;

import java.util.function.Function;

@Component
public class PublishingHouseToResponseFunction implements Function<PublishingHouse, GetPublishingHouseResponse> {

	@Override
	public GetPublishingHouseResponse apply(PublishingHouse publishingHouse) {
		return GetPublishingHouseResponse.builder()
				.id(publishingHouse.getId())
				.name(publishingHouse.getName())
				.creationYear(publishingHouse.getCreationYear())
				.build();
	}
}
