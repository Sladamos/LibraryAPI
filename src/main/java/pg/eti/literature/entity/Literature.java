package pg.eti.literature.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import pg.eti.literature.api.InvulnerableInformer;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public abstract class Literature implements InvulnerableInformer {

	private String title;

	private int numberOfPages;
}
