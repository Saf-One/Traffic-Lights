import java.util.Scanner;

public class Main {
    private static final String adminpass = "admin123";
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        Scanner sc = new Scanner(System.in);
        while(true){
        System.out.println("1 to enter Admin Option. \n2 to view Traffic Light\n0 to exit");
        int admin = sc.nextInt();
        sc.nextLine();
        if (admin==1){
            System.out.print("Enter Password: ");
            String pass = sc.nextLine();
            while(true){
            if (pass.equals(adminpass)){
                System.out.println("Press 1 to stop or start lights. Press 0 to return");
                int adminswitch = sc.nextInt();
                if (adminswitch==1){
                    trafficLight.adminSwitch();
                } else if (adminswitch == 0){
                    System.out.println("Returning");
                    break;
                } else{
                    System.out.println("Invalid");
                }
            }else {
                System.out.println("Incorrect password");
                break;
            }
            }
        } else if(admin==2){
            trafficLight.runTraffic();
        } else if (admin==0){
            break;
            }else{
            System.out.print("Invalid");
            break;
        }
        }
        }
    }
