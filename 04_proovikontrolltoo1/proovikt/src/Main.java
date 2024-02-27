import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        double num1 = 8;
        double num2 = 5;
        double num3 = 7;

        double average = calculateAverage(num1, num2, num3);
        System.out.println("Aritmeetiline keskmine: " + average);

        List<Double> numbers = new ArrayList<>();
        numbers.add(4.0);
        numbers.add(1.0);
        numbers.add(3.0);
        numbers.add(5.0);
        List<Double> average2 = calculateSlidingAverage(numbers);
        System.out.println("Libisev keskmine: " + average2);

        Average average1 = new Average(numbers);
        List<Double> slidingAverage2 = average1.getNumbersAverage();
        System.out.println(slidingAverage2);
        average1.addNumber(10.0);
        List<Double> slidingAverage3 = average1.getNumbersAverage();
        System.out.println(slidingAverage3);

        //-----------------------------------------------------------

        List<Double> xCoords = new ArrayList<>();
        List<Double> yCoords = new ArrayList<>();
        Triangle coords1 = new Triangle();
        coords1.addCoords(5,7);
        coords1.addCoords(7,7);
        coords1.addCoords(-2,4);
        coords1.printOutCoords();
    }

    public static double calculateAverage(double num1, double num2, double num3) {
        return (num1 + num2 + num3) / 3.0;
    }

    public static List<Double> calculateSlidingAverage(List<Double> numbers) {
        List<Double> numbersAverage = new ArrayList<>();
        for (int i = 0; i < numbers.size() - 2; i++) {
            double sum = numbers.get(i) + numbers.get(i + 1) + numbers.get(i + 2);
            double slidingAverage = sum / 3;
            numbersAverage.add(slidingAverage);
        }
        return numbersAverage;
    }

}