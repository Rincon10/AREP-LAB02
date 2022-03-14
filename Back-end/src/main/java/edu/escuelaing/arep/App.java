package edu.escuelaing.arep;

import org.eclipse.jetty.http.HttpStatus;

import static spark.Spark.*;

/**
 * Spark Application
 */
public class App {
    private static String defaultPath = "/";
    private static String getPath = "/messages";
    private static String postPath = "/messages:message";
    private static String helloPath = "/hello";

    /**
     * Method that set the instances of the controllers of our API
     */
    protected static void setControllers() {
        get(getPath, (req, res) -> {
            res.type("application/json");
            return null;

        });

        post(postPath, (req, res) -> {
            System.out.println(req.params(":message"));
            return req.params(":message");
        });


    }

    /**
     * Main method, that start our Spark application
     *
     * @param args
     */
    public static void main(String[] args) {
        //Setting the portNumber
        port(getPort());
        //staticFileLocation("/public");

        //After-filters are evaluated after each request, and can read the request and read/modify the response:
        //CORS
        after((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET,POST");
        });

        // This only if we wanna have the front in resources
//        get(defaultPath, (req, res) -> {
//            res.redirect("/index.html");
//            return "";
//        });

        get(helloPath, (req, res) -> "Hello, world from spark.");


        //Our API is gonna be on the base path, /api/v1
        path("/api/v1", () -> {
            //Setting the  Controllers of our API
            setControllers();

            //Using Exceptions
            exception(Exception.class, (exception, request, response) -> {
                response.status(HttpStatus.BAD_REQUEST_400);
//                response.body(cSvcimpl.transformToError(exception.getMessage()).toString());
            });
        });
    }

    /***
     * Method that returns the port number to use in our App
     * @return int, port number
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't se  (i.e. on localhost)
    }


}
