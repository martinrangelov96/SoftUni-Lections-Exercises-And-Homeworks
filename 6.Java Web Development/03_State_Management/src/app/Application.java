package app;

import app.http.HttpRequest;
import app.http.HttpRequestImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    private static BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        List<String> validUrs = getValidUrls();
        String request = getRequest();

        HttpRequest httpRequest = new HttpRequestImpl(request);

        httpRequest.getCookies().forEach(cookie -> {
            System.out.println(String.format("%s <-> %s", cookie.getKey(), cookie.getValue()));
        });
    }

    private static List<String> getValidUrls() throws IOException {
        List<String> validUrls = new ArrayList<>();
        Arrays.stream(bufferedReader.readLine().split("\\s+"))
                .forEach(url -> validUrls.add(url));

        return validUrls;
    }

    private static String getRequest() throws IOException {
        StringBuilder request = new StringBuilder();

        String line;
        while ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
            request.append(line).append(System.lineSeparator());
        }

        request.append(System.lineSeparator());
        if ((line = bufferedReader.readLine()) != null && !line.isEmpty()) {
            request.append(line);
        }

        return request.toString();
    }

    private static boolean urlIsValid(List<String> validUrs, HttpRequest httpRequest) {
        if (validUrs.contains(httpRequest.getRequestUrl())) {
            return true;
        }

        return false;
    }
}
