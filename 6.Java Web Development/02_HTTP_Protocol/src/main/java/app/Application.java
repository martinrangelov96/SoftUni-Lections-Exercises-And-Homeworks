package main.java.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Application {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        List<String> validUrls = getValidUrls();
        List<String> request = getRequest();

        String method = getMethod(request.get(0));
        String url = getUrl(request.get(0));

        Map<String, String> headers = getHeaders(request);
        Map<String, String> bodyParameters = getBodyParams(request);

        StringBuilder response = new StringBuilder();
        if (!validUrls.contains(url)) {
            response.append("HTTP/1.1 404 Not Found").append(System.lineSeparator());

            getResponseHeaders(headers, response);

            response.append(System.lineSeparator());
            response.append("The requested functionality was not found.");

            System.out.println(response.toString());
        } else if (!headers.containsKey("Authorization")) {
            response.append("HTTP/1.1 401 Unauthorized").append(System.lineSeparator());

            getResponseHeaders(headers, response);

            response.append(System.lineSeparator());
            response.append("You are not authorized to access the requested functionality.");

            System.out.println(response.toString());
        } else if (method.equals("POST") && bodyParameters.isEmpty()) {
            response.append("HTTP/1.1 400 Bad Request").append(System.lineSeparator());

            getResponseHeaders(headers, response);

            response.append(System.lineSeparator());
            response.append("There was an error with the requested functionality due to malformed request.");

            System.out.println(response.toString());
        } else {
            response.append("HTTP/1.1 200 OK").append(System.lineSeparator());

            getResponseHeaders(headers,response);

            response.append(System.lineSeparator());

            String first = "";
            String second = "";
            String third = "";
            int count = 0;
            for (Map.Entry<String, String> kvp : bodyParameters.entrySet()) {

                switch (count) {
                    case 0:
                        first = kvp.getValue();
                        break;
                    case 1:
                        second = String.format("%s – %s", kvp.getKey(), kvp.getValue());
                        break;
                    case 2:
                        third = String.format("%s – %s", kvp.getKey(), kvp.getValue());
                        break;
                }

                count++;
            }

            String responseBody = String.format("Greetings %s! You have successfully created %s with %s, %s.",
                    new String(Base64.getDecoder().decode(headers.get("Authorization").split("\\s+")[1])),
                    first, second, third
                    );

            response.append(responseBody);

            System.out.println(response.toString());
        }

    }

    private static void getResponseHeaders(Map<String, String> headers, StringBuilder response) {
        for (Map.Entry<String, String> kvp : headers.entrySet()) {
            if (kvp.getKey().equals("Date")
                    || kvp.getKey().equals("Host")
                    || kvp.getKey().equals("Content-Type")) {
                response.append(String.format("%s: %s",
                        kvp.getKey(), kvp.getValue())).append(System.lineSeparator());
            }
        }
    }

    private static List<String> getValidUrls() throws IOException {
        return Arrays.asList(reader.readLine().split("\\s+"));
    }

    private static List<String> getRequest() throws IOException {
        List<String> request = new ArrayList<>();

        String line = null;

        while ((line = reader.readLine()) != null && line.length() > 0) {
            request.add(line);
        }

        request.add(System.lineSeparator());
        if ((line = reader.readLine()) != null && line.length() > 0) {
            request.add(line);
        }
        return request;
    }

    private static String getMethod(String line) {
        return line.split("\\s+")[0];
    }

    private static String getUrl(String line) {
        return line.split("\\s+")[1];
    }

    private static Map<String, String> getHeaders(List<String> request) {
        Map<String, String> headers = new LinkedHashMap<>();

        request.stream()
                .skip(1)
                .filter(h -> h.contains(": "))
                .map(h -> h.split(": "))
                .forEach(headerKvp -> {
                    headers.put(headerKvp[0], headerKvp[1]);
                });

        return headers;
    }

    private static Map<String, String> getBodyParams(List<String> request) {
        Map<String, String> bodyParameters = new LinkedHashMap<>();

        if (request.get(request.size() - 1).equals(System.lineSeparator())) {
            return bodyParameters;
        }

        Arrays.stream(request.get(request.size() - 1)
                .split("&"))
                .map(bp -> bp.split("="))
                .forEach(bpKvp -> {
                    bodyParameters.put(bpKvp[0], bpKvp[1]);
                });

        return bodyParameters;
    }
}
