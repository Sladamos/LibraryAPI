package pg.eti.book.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pg.eti.book.dto.GetBookResponse;
import pg.eti.book.dto.GetBooksResponse;
import pg.eti.book.dto.PatchBookRequest;
import pg.eti.book.dto.PutBookRequest;

import java.util.UUID;

public interface BookController {

	@GetMapping("api/books")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	GetBooksResponse getBooks();

	@GetMapping("api/books/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	GetBookResponse getBook(
			@PathVariable("id")
			UUID id
	);

	@PutMapping("api/books/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	void putBook(
			@PathVariable("id")
			UUID id,
			@RequestBody
			PutBookRequest request
	);

	@PostMapping("api/books")
	@ResponseStatus(HttpStatus.CREATED)
	void createBook(
			@RequestBody
			PostBookRequest request
	);

	@PatchMapping("/api/books/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void patchBook(
			@PathVariable("id")
			UUID id,
			@RequestBody
			PatchBookRequest request
	);


	@DeleteMapping("api/books/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteBook(
			@PathVariable("id")
			UUID id
	);
}
