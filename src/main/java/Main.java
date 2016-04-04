import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import java.net.URI;
import java.net.URISyntaxException;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;
import org.json.JSONObject;
import com.google.gson.Gson;

public class Main {

  public static void main(String[] args) {

    Gson gson = new Gson();

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    new FlowerController(new FlowerService());

    get("/about", (req, res) -> {

          Connection connection = null;
          // res.type("application/xml"); //Return as XML

          Map<String, Object> attributes = new HashMap<>();
          try {


              String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
              xml += "<About>";

                  xml += "<Branch>";
                  xml += "<Name>Orchid Flower</Name>";
                  xml += "<Profession>Retailer</Profession>";
                  xml += "<Since>2016</Since>";
                  xml += "<Country>United States</Country>";
                  xml += "<State>Pennsylvania</State>";
                  xml += "<City>Pittsburgh</City>";
                  xml += "<OpenHour>9am-8pm</OpenHour>";
                  xml += "<Phone>111-222-3333</Phone>";
                  xml += "<Email>huz26@pitt.edu</Email>";
                  xml += "<Address>4200 Fifth Ave</Address>";
                  xml += "</Branch>";

              xml += "</About>";
              res.type("text/xml");
              return xml;

          } catch (Exception e) {
              attributes.put("message", "There was an error: " + e);
              return attributes;
          } finally {
              if (connection != null) try{connection.close();} catch(SQLException e){}
          }
      });

    get("/hello", (req, res) -> "Hello World");
    get("/a", (req, res) -> "This is a");
    //post("/b", (req, res) -> "This is b");


    get("/aboutus", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "about.ftl");
        }, new FreeMarkerEngine());

    get("/showflower", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            return new ModelAndView(attributes, "showflower.ftl");
        }, new FreeMarkerEngine());

    post("/login", (req, res) -> {
              Map<String, Object> data = new HashMap<>();
              data.put("username", "Colin");
              data.put("password","aaa");
              return data;
          }, gson::toJson);

    post("/register", (req, res) -> {
           Connection connection = null;
              try {
                  connection = DatabaseUrl.extract().getConnection();
                  JSONObject obj = new JSONObject(req.body());
                  String username = obj.getString("username");
                  String password = obj.getString("password");

                  String sql = "INSERT INTO User(username, email, password) VALUES ('"
                                + username + "','" + password + "')";

                  connection = DatabaseUrl.extract().getConnection();
                  Statement stmt = connection.createStatement();
                  stmt.executeUpdate("CREATE TABLE IF NOT EXISTS User");
                  stmt.executeUpdate(sql);

                 return req.body();
                } catch (Exception e) {
                  return e.getMessage();
                } finally {

                }
              });

    get("/db", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
          output.add( "Read from DB: " + rs.getTimestamp("tick"));
        }

        attributes.put("results", output);
        return new ModelAndView(attributes, "db.ftl");
      } catch (Exception e) {
        attributes.put("message", "There was an error: " + e);
        return new ModelAndView(attributes, "error.ftl");
      } finally {
        if (connection != null) try{connection.close();} catch(SQLException e){}
      }
    }, new FreeMarkerEngine());

  }

}
