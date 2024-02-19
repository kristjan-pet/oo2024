public class Main {
    public static void main(String[] args) {

        double price1 = calculateTotalPrice(12);
        double price2 = calculateTotalPrice(25);
        System.out.println(price1);
        System.out.println(price2);

        int apply1 = applyTotalPrice(false, 2);
        int apply2 = applyTotalPrice(true, 2);
        System.out.println(apply1);
        System.out.println(apply2);

        sumForCycle(5);
        sumForCycle(3);
        
    }
    
    private static double calculateTotalPrice(int price) {
        return Math.round(price + (price * 0.1)) + 0.09;
    }

    private static int applyTotalPrice(boolean apply, int price) {
        if (apply == true) {
            return price + 12;
        } else {
            return price;
        }
    }

    private static void sumForCycle(long number) {
        long new_number = number;
        for (int i = 0; i < number; i++) {
            new_number = new_number + 2;
        }
        System.out.println(new_number);
    }
}