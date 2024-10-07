import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserAuthTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/user_auth_data.csv", numLinesToSkip = 1)
    void testCheckLogin(String username, String password, boolean status, boolean expected) {
        UserAuth userAuth = new UserAuth(username, password, status);
        boolean result = userAuth.checkLogin(username, password);
        assertEquals(expected, result);
    }
}
