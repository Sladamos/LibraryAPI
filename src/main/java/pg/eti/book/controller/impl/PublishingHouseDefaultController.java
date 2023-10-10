package pg.eti.book.controller.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pg.eti.book.controller.api.PublishingHouseController;
import pg.eti.book.dto.GetPublishingHouseResponse;
import pg.eti.book.dto.GetPublishingHousesResponse;
import pg.eti.book.dto.PatchPublishingHouseRequest;
import pg.eti.book.dto.PutPublishingHouseRequest;
import pg.eti.book.function.PublishingHouseToResponseFunction;
import pg.eti.book.function.PublishingHousesToResponseFunction;
import pg.eti.book.service.api.PublishingHouseService;

import java.util.UUID;

@RestController
@Log
public class PublishingHouseDefaultController implements PublishingHouseController {

	private final PublishingHouseService service;

	private final PublishingHousesToResponseFunction publishingHousesToResponse;

	private final PublishingHouseToResponseFunction publishingHouseToResponse;

	@Autowired
	public PublishingHouseDefaultController(PublishingHouseService service, PublishingHousesToResponseFunction publishingHousesToResponse, PublishingHouseToResponseFunction publishingHouseToResponse) {
		this.service = service;
		this.publishingHousesToResponse = publishingHousesToResponse;
		this.publishingHouseToResponse = publishingHouseToResponse;
	}

	@Override
	public GetPublishingHousesResponse getPublishingHouses() {
		return publishingHousesToResponse.apply(service.findAll());
	}

	@Override
	public GetPublishingHouseResponse getPublishingHouse(UUID id) {
		return service.find(id)
				.map(publishingHouseToResponse)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@Override
	public void putPublishingHouse(UUID id, PutPublishingHouseRequest request) {

	}

	@Override
	public void patchPublishingHouse(UUID id, PatchPublishingHouseRequest request) {

	}

	@Override
	public void deletePublishingHouse(UUID id) {

	}
}
