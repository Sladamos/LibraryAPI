package pg.eti.publishinghouse.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GetPublishingHouseResponse {

	private UUID id;

	private String name;

	private Integer creationYear;
}
