import java.util.LinkedList;
import java.util.Scanner;

class ROICalculator {
    public static void main(String[] args) {
        LinkedList<Equipment> equipmentList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter equipment details for piece " + (i + 1));
            System.out.print("Brand: "); //CISCO
            String brand = scanner.nextLine();
            System.out.print("Gain: "); //$1200.00
            double gain = scanner.nextDouble();
            System.out.print("Cost: "); //$3965.99
            double cost = scanner.nextDouble();
    
            scanner.nextLine();

            Equipment equipment = new Equipment(brand, gain, cost);
            equipmentList.add(equipment);
        }
        int n = equipmentList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (equipmentList.get(j).roi < equipmentList.get(j + 1).roi) {
                    Equipment temp = equipmentList.get(j);
                    equipmentList.set(j, equipmentList.get(j + 1));
                    equipmentList.set(j + 1, temp);
                }
            }
        }
        System.out.println("Equipment sorted by ROI (best to least):");
        for (Equipment equipment : equipmentList) {
            System.out.println(equipment);
        }
        
        scanner.close(); 
    }
}
class Equipment {
    String brand;
    double gain;
    double cost;
    double roi;

    Equipment(String brand, double gain, double cost) {
        this.brand = brand;
        this.gain = gain;
        this.cost = cost;
        this.roi = (gain - cost) / cost;
    }

    public String toString() {
        return "Brand: " + brand + ", Gain: $" + gain + ", Cost: $" + cost + ", ROI: " + roi;
    }
}

 