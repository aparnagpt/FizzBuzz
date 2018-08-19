package aparnagpt.FizzBuzz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FizzBuzzApplicationTests {
    @Autowired
    private MockMvc mvc;

    @Test
    public void numberDivisibleBy3ReturnsFizz() throws Exception {
        mvc.perform(get("/api/fizzbuzz?numbers=96"))
                .andExpect(status().isOk())
                .andExpect(content().string("Fizz"));
    }

    @Test
    public void numberDivisibleBy5ReturnsBuzz() throws Exception {
        mvc.perform(get("/api/fizzbuzz?numbers=40"))
                .andExpect(status().isOk())
                .andExpect(content().string("Buzz"));
    }

    @Test
    public void numberDivisibleBy3And5ReturnsFizzBuzz() throws Exception {
        mvc.perform(get("/api/fizzbuzz?numbers=75"))
                .andExpect(status().isOk())
                .andExpect(content().string("FizzBuzz"));
    }

    @Test
    public void numberNotDivisibleBy3And5ReturnsNumber() throws Exception {
        mvc.perform(get("/api/fizzbuzz?numbers=91"))
                .andExpect(status().isOk())
                .andExpect(content().string("91"));
    }

    @Test
    public void multipleNumbersReturnsCommaSeparatedResult() throws Exception {
        mvc.perform(get("/api/fizzbuzz?numbers=96,40,75,91"))
                .andExpect(status().isOk())
                .andExpect(content().string("Fizz, Buzz, FizzBuzz, 91"));
    }

    @Test
    public void emptyInputReturnsBadRequest() throws Exception {
        mvc.perform(get("/api/fizzbuzz?numbers="))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Invalid input"));
    }

    @Test
    public void largeInputReturnsBadRequest() throws Exception {
        mvc.perform(get("/api/fizzbuzz?numbers=1000000000"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Invalid input"));
    }

    @Test
    public void invalidInputReturnsBadRequest() throws Exception {
        mvc.perform(get("/api/fizzbuzz?numbers=three"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Invalid input"));
    }
}
