public class Timer extends Thread{
    int i = 0;
    @Override
    public void run() {
        while(true) {
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
