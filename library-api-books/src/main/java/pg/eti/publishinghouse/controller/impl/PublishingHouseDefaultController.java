package pg.eti.publishinghouse.controller.impl;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import pg.eti.publishinghouse.dto.PatchPublishingHouseRequest;
import pg.eti.publishinghouse.dto.PutPublishingHouseRequest;
import pg.eti.publishinghouse.function.RequestToPublishingHouseFunction;
import pg.eti.publishinghouse.function.UpdatePublishingHouseWithRequestFunction;
import pg.eti.publishinghouse.controller.api.PublishingHouseController;
import pg.eti.publishinghouse.service.api.PublishingHouseService;
import pg.eti.publishinghouse.service.exception.PublishingHouseServiceException;

import java.util.UUID;

@RestController
@Log
public class PublishingHouseDefaultController implements PublishingHouseController {

	private final PublishingHouseService service;

	private final RequestToPublishingHouseFunction requestToPublishingHouse;

	private final UpdatePublishingHouseWithRequestFunction updatePublishingHouseWithRequest;

	@Autowired
	public PublishingHouseDefaultController(
			PublishingHouseService service,
			RequestToPublishingHouseFunction requestToPublishingHouse,
			UpdatePublishingHouseWithRequestFunction updatePublishingHouseWithRequest) {
		this.service = service;
		this.requestToPublishingHouse = requestToPublishingHouse;
		this.updatePublishingHouseWithRequest = updatePublishingHouseWithRequest;
	}

	@Override
	public void putPublishingHouse(UUID id, PutPublishingHouseRequest request) {
		try {
			service.create(requestToPublishingHouse.apply(id, request));
		} catch (PublishingHouseServiceException exception) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
		}
	}

	@Override
	public void patchPublishingHouse(UUID id, PatchPublishingHouseRequest request) {
		service.find(id)
				.ifPresentOrElse(
						publishingHouse -> {
							try {
								service.update(updatePublishingHouseWithRequest.apply(publishingHouse, request));
							} catch (PublishingHouseServiceException error) {
								throw new ResponseStatusException(HttpStatus.BAD_REQUEST, error.getMessage());
							}
						},
						() -> {
							throw new ResponseStatusException(HttpStatus.NOT_FOUND);
						}
				);
	}

	@Override
	public void deletePublishingHouse(UUID id) {
		service.find(id)
				.ifPresentOrElse(
						publishingHouse -> service.delete(id),
						() -> {
							throw new ResponseStatusException(HttpStatus.NOT_FOUND);
						});
	}
}
