import java.util.concurrent.Semaphore;

class Foo {
    // Semaphores to control execution order
    private Semaphore run2;
    private Semaphore run3;

    public Foo() {
        // Initialize with 0 permits, meaning threads will block immediately on acquire()
        run2 = new Semaphore(0);
        run3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        
        // Signal that first() has finished by releasing a permit for second()
        run2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // Block until first() releases a permit
        run2.acquire();
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        
        // Signal that second() has finished by releasing a permit for third()
        run3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // Block until second() releases a permit
        run3.acquire();
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}