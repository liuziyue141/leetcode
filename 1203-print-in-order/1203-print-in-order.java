class Foo {
    boolean firstRun;
    boolean secondRun;
    public Foo() {

    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstRun = true;
        this.notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        
        while(!firstRun){
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondRun = true;
        this.notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while(!secondRun){
            wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}