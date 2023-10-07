package pg.eti.parallel;

import java.util.concurrent.TimeUnit;

public interface ParallelTaskExecutioner {
    void submit(Runnable task);
    void shutdown();
    void awaitTermination(long termination, TimeUnit timeUnit);
}
