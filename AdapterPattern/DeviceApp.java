package AdapterPattern;
import java.util.Scanner;

public class DeviceApp {

    public static void main(String[] args){

        Laptop laptop = new Laptop();
        PowerOutlet lt = new LaptopAdapter(laptop);

        Refrigerator  refrigerator  = new Refrigerator();
        PowerOutlet rf = new RefrigeratorAdapter(refrigerator);

        SmartphoneCharger  smartphoneCharger = new SmartphoneCharger();
        PowerOutlet sp = new SmartphoneAdapter(smartphoneCharger);

        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO DEVICE MANAGEMENT APP! \n");

        while (true) {
            System.out.println("Please select a device: ");
            System.out.println("1. Laptop ");
            System.out.println("2. Refrigerator ");
            System.out.println("3. Smartphone Charger ");
            System.out.println("4. Exit ");

            System.out.print("\nEnter your choice: ");
            System.out.print("");

            int choice = scanner.nextInt();

            
            switch (choice) {
                case 1:
                    System.out.println(lt.plugIn());
                    System.out.println("");
                    break;

                case 2:
                    System.out.println(rf.plugIn());
                    System.out.println("");
                    break;

                case 3:
                    System.out.println(sp.plugIn());
                    System.out.println("");
                    break;

                case 4:
                    System.out.println("\nExiting the program...");
                    System.out.println("");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nInvalid choice. Please select a number between 1 and 3.\n");
            }
        }
    }
}



        