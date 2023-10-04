package pg.eti.literature.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Literature {

	private String title;

	private int numberOfPages;
}
