package pg.eti.publishinghouse.function;

import org.springframework.stereotype.Component;
import pg.eti.publishinghouse.dto.PatchPublishingHouseRequest;
import pg.eti.publishinghouse.entity.PublishingHouse;

import java.util.function.BiFunction;

@Component
public class UpdatePublishingHouseWithRequestFunction implements BiFunction<PublishingHouse,
		PatchPublishingHouseRequest, PublishingHouse> {

	@Override
	public PublishingHouse apply(PublishingHouse entity, PatchPublishingHouseRequest patchPublishingHouseRequest) {
		return PublishingHouse.builder()
				.id(entity.getId())
				.creationYear(patchPublishingHouseRequest.getCreationYear() == null ?
						entity.getCreationYear() : patchPublishingHouseRequest.getCreationYear())
				.name(patchPublishingHouseRequest.getName() == null ?
						entity.getName() : patchPublishingHouseRequest.getName())
				.build();
	}
}
