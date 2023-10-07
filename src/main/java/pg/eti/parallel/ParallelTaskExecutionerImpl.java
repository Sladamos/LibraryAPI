package pg.eti.parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ParallelTaskExecutionerImpl implements ParallelTaskExecutioner {

    private final ForkJoinPool forkJoinPool = new ForkJoinPool();

    @Override
    public void submit(Runnable task) {
        forkJoinPool.submit(task);
    }

    @Override
    public void shutdown() {
        forkJoinPool.shutdown();
    }

    @Override
    public void awaitTermination(long termination, TimeUnit timeUnit) {
        try {
            forkJoinPool.awaitTermination(termination, timeUnit);
        } catch (InterruptedException ignored) {
        }
    }
}
