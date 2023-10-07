package pg.eti.book.function.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import pg.eti.book.entity.PublishingHouse;

@AllArgsConstructor
@Builder
public class SelfPrintablePublishingHouseTask implements PublishingHouseTask {

    private final int numberOfIterations;

    private final int maxDelayInMilliseconds;

    @Override
    public void accept(PublishingHouse publishingHouse) {
        for(int i = 0; i < numberOfIterations; i++) {
            System.out.println(publishingHouse);
            double delay = Math.random() * maxDelayInMilliseconds;
            try {
                Thread.sleep((long) delay);
                System.out.println("Iteration ended, I am" + publishingHouse.getInvulnerableInfo());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
