package pg.eti.book.function;

import org.springframework.stereotype.Component;
import pg.eti.book.dto.GetPublishingHouseResponse;
import pg.eti.book.entity.PublishingHouse;

import java.util.function.Function;

@Component
public class PublishingHouseToResponseFunction implements Function<PublishingHouse, GetPublishingHouseResponse> {

	@Override
	public GetPublishingHouseResponse apply(PublishingHouse publishingHouse) {
		return GetPublishingHouseResponse.builder()
				.id(publishingHouse.getId())
				.name(publishingHouse.getName())
				.build();
	}
}
