package edu.escuelaing.arep.services.impl;

import edu.escuelaing.arep.services.IHttpConnectionService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Iván Camilo Rincón Saavedra
 * @version 1.0 3/19/2022
 * @project Back-end
 */
public class HttpConnectionService implements IHttpConnectionService {
    private HttpURLConnection con;
    private URL url;
    private static final String USER_AGENT = "Mozilla/5.0";

    public HttpConnectionService() {
    }

    public HttpConnectionService(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String startConnection(String method, String jsonInputString) throws IOException {
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(method);
        con.setRequestProperty("User-Agent", USER_AGENT);

        if (method.equals("GET")) return getResponse();
        return postPetition(jsonInputString);
    }


    @Override
    public String getResponse() throws IOException {
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("*****************************************************************************");
        System.out.println("GET Response Code :: " + responseCode + "on petition" + url.getPath());

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            System.out.println("starting GET petition on " + url.getPath());
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            return response.toString();
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE from url" + url.getPath() + "\n");
        System.out.println("*****************************************************************************");
        return null;
    }

    @Override
    public String postPetition(String jsonInputString) throws IOException {
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("*****************************************************************************");
        System.out.println("POST Response Code :: " + responseCode + "on petition" + url.getPath());

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            System.out.println("starting POST petition on " + url.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = input.readLine()) != null) {
                response.append(inputLine);
            }
            input.close();

            // print result
            return response.toString();
        } else {
            System.out.println("POST request not worked");
        }
        System.out.println("POST DONE from url" + url.getPath() + "\n");
        System.out.println("*****************************************************************************");
        return null;
    }
}
