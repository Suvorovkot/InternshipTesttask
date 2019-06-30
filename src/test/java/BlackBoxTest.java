import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class BlackBoxTest {

    User currentLoggedUser = new User(38, "Parrots");
    String correctRequest = "http://some_domain.com:8080/company/" + currentLoggedUser.getCompanyID().toString() + "/users?name=Parrots";
    String incorrectRequest = "http://some_domain.com:8080/company/1/users?name=Parrots";


    @Test
    void userAccessVerificationTest() throws IOException {
        HttpUriRequest request = new HttpGet(correctRequest);
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    void userNoAccessVerificationTest() throws IOException {
        HttpUriRequest request = new HttpGet(incorrectRequest);
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_FORBIDDEN);
    }
}
