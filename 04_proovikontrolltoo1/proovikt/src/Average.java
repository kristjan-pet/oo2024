import java.util.ArrayList;
import java.util.List;

public class Average {
    List<Double> numbers = new ArrayList<>(); //eksemplar
    List<Double> numbersAverage = new ArrayList<>();
    public Average(List<Double> numbersStart) {
        numbers = numbersStart;
        calculateSlidingAverage();
    }

    public void addNumber(Double number) {
        Double last = numbers.get(numbers.size()-1);
        Double preLast = numbers.get(numbers.size()-2);
        Double average = (last + preLast + number) / 3;
        numbersAverage.add(average);
        numbers.add(number);
    }

    public List<Double> getNumbersAverage() {
        return numbersAverage;
    }

    private List<Double> calculateSlidingAverage() {

        for (int i = 0; i < numbers.size() - 2; i++) {
            double sum = numbers.get(i) + numbers.get(i + 1) + numbers.get(i + 2);
            double slidingAverage = sum / 3;
            numbersAverage.add(slidingAverage);
        }
        return numbersAverage;
    }
}
