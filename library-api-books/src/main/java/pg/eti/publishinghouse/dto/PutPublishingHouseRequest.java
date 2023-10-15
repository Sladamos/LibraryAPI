package pg.eti.publishinghouse.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PutPublishingHouseRequest {

	private String name;

	private Integer creationYear;
}
