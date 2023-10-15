package pg.eti.publishinghouse.initialize;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pg.eti.publishinghouse.entity.PublishingHouse;
import pg.eti.publishinghouse.service.api.PublishingHouseService;

import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {

	private final PublishingHouseService publishingHouseService;

	@Autowired
	public InitializeData(PublishingHouseService publishingHouseService) {
		this.publishingHouseService = publishingHouseService;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if(publishingHouseService.findAll().isEmpty()) {
			PublishingHouse insignisPublishingHouse = PublishingHouse.builder()
					.id(UUID.fromString("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76"))
					.name("Insignis")
					.creationYear(2007)
					.build();

			PublishingHouse siedmiorogPublishingHouse = PublishingHouse.builder()
					.id(UUID.fromString("5d1da2ae-6a14-4b6d-8b4f-d117867118d4"))
					.name("Siedmioróg")
					.creationYear(1990)
					.build();

			publishingHouseService.create(insignisPublishingHouse);
			publishingHouseService.create(siedmiorogPublishingHouse);
		}
	}
}
