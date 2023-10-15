package pg.eti.publishinghouse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@ToString
@Table(name = "publishing_houses")
public class PublishingHouse implements Serializable {

	@Id
	private UUID id;

	@Column(unique = true)
	private String name;

	private Integer creationYear;
}
