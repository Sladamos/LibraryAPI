package pg.eti.book.function;

import org.springframework.stereotype.Component;
import pg.eti.book.dto.PatchPublishingHouseRequest;
import pg.eti.book.entity.PublishingHouse;

import java.util.function.BiFunction;

@Component
public class UpdatePublishingHouseWithRequestFunction implements BiFunction<PublishingHouse,
		PatchPublishingHouseRequest, PublishingHouse> {

	@Override
	public PublishingHouse apply(PublishingHouse entity, PatchPublishingHouseRequest patchPublishingHouseRequest) {
		return PublishingHouse.builder()
				.id(entity.getId())
				.books(entity.getBooks())
				.creationYear(patchPublishingHouseRequest.getCreationYear() == null ?
						entity.getCreationYear() : patchPublishingHouseRequest.getCreationYear())
				.name(patchPublishingHouseRequest.getName() == null ?
						entity.getName() : patchPublishingHouseRequest.getName())
				.build();
	}
}
