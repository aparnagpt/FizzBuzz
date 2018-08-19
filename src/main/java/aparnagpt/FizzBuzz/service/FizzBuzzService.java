package aparnagpt.FizzBuzz.service;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FizzBuzzService {
    public String doFizzBuzz(List<String> numbers) {
        return numbers.stream()
                .map(Integer::parseInt)
                .map(FizzBuzzService::doFizzBuzz)
                .collect(Collectors.joining(", "));
    }

    private static String doFizzBuzz(int number) {
        String result = "";
        result += number % 3 == 0 ? "Fizz" : "";
        result += number % 5 == 0 ? "Buzz" : "";
        return result.isEmpty() ? String.valueOf(number) : result;
    }
}
