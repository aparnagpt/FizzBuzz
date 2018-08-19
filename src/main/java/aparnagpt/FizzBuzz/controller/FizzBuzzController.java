package aparnagpt.FizzBuzz.controller;

import aparnagpt.FizzBuzz.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FizzBuzzController {
    @Autowired
    private FizzBuzzService fizzBuzzService;

    @GetMapping("fizzbuzz")
    public ResponseEntity<String> doFizzBuzz(@RequestParam List<String> numbers) {
        if (numbers.isEmpty() || !numbers.stream().allMatch(num -> num.matches("^[1-9][0-9]{0,8}$"))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input");
        }
        return ResponseEntity.ok(fizzBuzzService.doFizzBuzz(numbers));
    }
}
