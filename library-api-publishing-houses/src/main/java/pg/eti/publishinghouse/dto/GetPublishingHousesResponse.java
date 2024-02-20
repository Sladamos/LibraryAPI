package pg.eti.publishinghouse.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class GetPublishingHousesResponse {

	@Data
	@Builder
	public static class PublishingHouse {

		private UUID id;

		private String name;
	}

	@Singular
	private List<PublishingHouse> publishingHouses;
}
