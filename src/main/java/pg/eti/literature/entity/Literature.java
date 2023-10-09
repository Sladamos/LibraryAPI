package pg.eti.literature.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.UUID;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
@Entity
@Table(name = "literatures")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Literature implements Serializable {

	@Id
	private UUID id;

	private String title;

	private Integer numberOfPages;
}
