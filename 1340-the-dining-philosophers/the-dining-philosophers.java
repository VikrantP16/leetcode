import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class DiningPhilosophers {
    private final Semaphore[] forks;
    private final Semaphore maxDiners; // allow at most 4 philosophers to try eating at once

    public DiningPhilosophers() {
        forks = new Semaphore[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }
        maxDiners = new Semaphore(4);
    }

    public void wantsToEat(int philosopher,
                            Runnable pickLeftFork,
                            Runnable pickRightFork,
                            Runnable eat,
                            Runnable putLeftFork,
                            Runnable putRightFork) throws InterruptedException {
        int left = philosopher;
        int right = (philosopher + 1) % 5;

        maxDiners.acquire();
        try {
            forks[left].acquire();
            forks[right].acquire();

            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();

            forks[left].release();
            forks[right].release();
        } finally {
            maxDiners.release();
        }
    }
}