package com.crxmarkets.rainyhills.controller;

import com.crxmarkets.rainyhills.service.CoreService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * Main servlet who get surface input sent by user in jsp and trigger the service to calculate the volume.
 *
 * Created by ffaria on 5/8/17.
 */
@WebServlet(urlPatterns = "/rainyHills")
public class MainServlet extends HttpServlet {

    @EJB
    private CoreService coreService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String inputValues = req.getParameter("inputValues");

        int[] parsedValues = Arrays.stream(inputValues.split(" "))
                .map(String::trim).mapToInt(Integer::parseInt).toArray();

        if(parsedValues.length < 3){
            req.setAttribute("error", "The values entered do not represents a valid surface, minimum input should be 1 0 1");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        else {
            int volume = coreService.fillWater(parsedValues);

            if(volume == 0){
                req.setAttribute("error", "You entered surface without any hole, enter a new one keeping a hole");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
            else {
                req.setAttribute("answer", "Volume = " + volume);
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
