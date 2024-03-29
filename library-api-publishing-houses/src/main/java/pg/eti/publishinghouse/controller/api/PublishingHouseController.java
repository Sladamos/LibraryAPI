package pg.eti.publishinghouse.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pg.eti.publishinghouse.dto.GetPublishingHouseResponse;
import pg.eti.publishinghouse.dto.GetPublishingHousesResponse;
import pg.eti.publishinghouse.dto.PatchPublishingHouseRequest;
import pg.eti.publishinghouse.dto.PutPublishingHouseRequest;

import java.util.UUID;

public interface PublishingHouseController {

	@GetMapping("api/publishing-houses")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	GetPublishingHousesResponse getPublishingHouses();

	@GetMapping("api/publishing-houses/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	GetPublishingHouseResponse getPublishingHouse(
			@PathVariable("id")
			UUID id
	);

	@PutMapping("api/publishing-houses/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	void putPublishingHouse(
			@PathVariable("id")
			UUID id,
			@RequestBody
			PutPublishingHouseRequest request
	);

	@PatchMapping("/api/publishing-houses/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void patchPublishingHouse(
			@PathVariable("id")
			UUID id,
			@RequestBody
			PatchPublishingHouseRequest request
	);


	@DeleteMapping("api/publishing-houses/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deletePublishingHouse(
			@PathVariable("id")
			UUID id
	);
}
