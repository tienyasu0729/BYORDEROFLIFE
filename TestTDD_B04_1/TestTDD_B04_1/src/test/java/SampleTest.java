import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SampleTest {
    Sample s;
    @BeforeEach
    public void setUp()
    {
        s = new Sample();
    }
    @Test
    public void checkEven(){

        //Test 2 la so chan

        boolean kq = s.isEven(2);
        //Assert.assertEquals("check 2 is even",true, kq);
        Assert.assertTrue(kq);
    }

    @Test
    public  void checkPositiveNumber()
    {
       // Sample s = new Sample();
        boolean kq = s.isEven(-5);
        Assert.assertEquals(false, kq);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 0, 10, 4, 16, Integer.MAX_VALUE-1}) // six numbers
    void isOdd_ShouldReturnTrueForOddNumbers(int number) {
        //assertTrue(s.isEven(number));
        boolean kq = s.isEven(number);
        Assert.assertEquals(true, kq);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/even.csv",numLinesToSkip = 1)
    public void checkEvenFromCSVFile(String input, String expected){
        int number = Integer.parseInt(input); //chuyen string sang int
        boolean actual = s.isEven(number);
        boolean ex = Boolean.parseBoolean(expected);
        Assert.assertEquals(ex,actual);
    }


}
