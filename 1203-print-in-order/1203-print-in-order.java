class Foo {
    Lock lock;
    Condition firstRunCondition;
    Condition secondRunCondition;
    boolean firstRun;
    boolean secondRun;
    public Foo() {
        lock = new ReentrantLock();
        firstRunCondition = lock.newCondition();
        secondRunCondition = lock.newCondition();
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        // printFirst.run() outputs "first". Do not change or remove this line.
        firstRun = true;
        printFirst.run();
        firstRunCondition.signal();
        lock.unlock();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        // printSecond.run() outputs "second". Do not change or remove this line.
        while(!firstRun){
            firstRunCondition.await();
        }
        secondRun = true;
        printSecond.run();
        secondRunCondition.signal();
        lock.unlock();
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        while(!secondRun){
            secondRunCondition.await();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        lock.unlock();
    }
}