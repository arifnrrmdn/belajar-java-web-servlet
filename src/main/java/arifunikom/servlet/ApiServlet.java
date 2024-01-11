package arifunikom.servlet;

import arifunikom.servlet.model.SayHelloRequest;
import arifunikom.servlet.util.JsonUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/api/say-hello")
public class ApiServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SayHelloRequest sayHelloRequest = JsonUtil.getObjectMapper().readValue(req.getReader(), SayHelloRequest.class);
        String sayHello = "Hello " + sayHelloRequest.getFirstName() + " " + sayHelloRequest.getLastName();

        Map<String, String> response = Map.of(
                "data", sayHello
        );

        String jsonResponse = JsonUtil.getObjectMapper().writeValueAsString(response);

        resp.setHeader("content-type", "application/json");
        resp.getWriter().println(jsonResponse);

    }
}
