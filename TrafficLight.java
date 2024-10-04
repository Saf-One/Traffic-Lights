import java.lang.Thread;
import java.util.Scanner;


public class TrafficLight {
    private int time;
    private boolean work = true;
    private boolean running;

    public TrafficLight() {
        this.time = (int) (System.currentTimeMillis() / 1000) % 60;
    }

    public void traffic() {
        if (work == true){
        System.out.print("\r");
        if (time >= 0 && time <= 25) {
            System.out.print("Light is Red");
        } else if (time >= 26 && time <= 30) {
            System.out.print("Light is Yellow");
        } else if (time >= 31 && time <= 55) {
            System.out.print("Light is Green");
        } else if (time >= 56 && time <= 59) {
            System.out.print("Light is Yellow");
        } else {
            System.out.print("Invalid time");
        }
        System.out.flush();
    } else {
            System.out.print("\r");
            System.out.print("Light is Stopped");
            System.out.flush();
        }
    }
    public void adminSwitch(){
        work = !work;
        if(work == true){
            System.out.println("Lights are running");
        } else {
            System.out.println("Lights are Stopped");
        }
    }
    public void updateTime() {
        time = (time + 1) % 60;
    }

    public void runTraffic() {
        Thread trafficThread = new Thread(() -> {
            running = true;
            while (running == true) {
                traffic();
                updateTime();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                if (!work) {
                    break;
                }
            }
        });
        trafficThread.start();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 0 to stop the traffic light simulation");
        int input = scanner.nextInt();
        while (input != 0) {
            System.out.println("Press 0 to stop the traffic light simulation");
            input = scanner.nextInt();
        }
        running = false;
    }
}