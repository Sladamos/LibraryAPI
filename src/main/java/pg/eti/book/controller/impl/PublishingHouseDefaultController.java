package pg.eti.book.controller.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pg.eti.book.controller.api.PublishingHouseController;
import pg.eti.book.dto.*;
import pg.eti.book.function.PublishingHouseToResponseFunction;
import pg.eti.book.function.PublishingHousesToResponseFunction;
import pg.eti.book.function.RequestToPublishingHouseFunction;
import pg.eti.book.service.api.PublishingHouseService;
import pg.eti.book.service.exception.PublishingHouseServiceException;

import java.util.UUID;

@RestController
@Log
public class PublishingHouseDefaultController implements PublishingHouseController {

	private final PublishingHouseService service;

	private final PublishingHousesToResponseFunction publishingHousesToResponse;

	private final PublishingHouseToResponseFunction publishingHouseToResponse;

	private final RequestToPublishingHouseFunction requestToPublishingHouse;

	@Autowired
	public PublishingHouseDefaultController(
			PublishingHouseService service,
			PublishingHousesToResponseFunction publishingHousesToResponse,
			PublishingHouseToResponseFunction publishingHouseToResponse,
			RequestToPublishingHouseFunction requestToPublishingHouse) {
		this.service = service;
		this.publishingHousesToResponse = publishingHousesToResponse;
		this.publishingHouseToResponse = publishingHouseToResponse;
		this.requestToPublishingHouse = requestToPublishingHouse;
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
		try {
			service.create(requestToPublishingHouse.apply(id, request));
		} catch (PublishingHouseServiceException exception) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
		}
	}

	@Override
	public void patchPublishingHouse(UUID id, PatchPublishingHouseRequest request) {

	}

	@Override
	public void deletePublishingHouse(UUID id) {

	}
}
