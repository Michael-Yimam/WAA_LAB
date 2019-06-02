package mum.edu.servlet;

import mum.edu.model.GeneratedNumbers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class RandomNumberServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        Random random = new Random();
        GeneratedNumbers generatedNumbers = new GeneratedNumbers();

        generatedNumbers.setControl(random.nextInt(21));
        generatedNumbers.setFirst(random.nextInt(21));
        generatedNumbers.setSecond(random.nextInt(21));
        generatedNumbers.setThird(random.nextInt(21));

        request.setAttribute("randomNumbers", generatedNumbers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Random.jsp");
        dispatcher.forward(request, response);

    }

}
