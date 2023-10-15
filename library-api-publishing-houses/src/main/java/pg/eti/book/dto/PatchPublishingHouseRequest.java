package pg.eti.book.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatchPublishingHouseRequest {

	private String name;

	private Integer creationYear;
}
