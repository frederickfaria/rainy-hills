package com.crxmarkets.rainyhills.controller;

import com.crxmarkets.rainyhills.service.CoreService;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * Main servlet who get surface input sent by user in jsp and trigger the service to calculate the volume.
 *
 * Created by ffaria on 5/8/17.
 */
@WebServlet(urlPatterns = "/calculate")
public class MainServlet extends HttpServlet {

    static Logger logger = Logger.getLogger(MainServlet.class);

    @EJB
    private CoreService coreService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String inputValues = req.getParameter("inputValues");

            logger.info("From: " + req.getRemoteAddr() + ". Received request with values = " + inputValues);

            long[] parsedValues = Arrays.stream(inputValues.split(" "))
                    .map(String::trim).mapToLong(Long::parseLong).toArray();

            if(parsedValues.length < 3){
                logger.warn("From: " + req.getRemoteAddr() + ". The values entered do not represents a valid surface");
                req.setAttribute("error", "The values entered do not represents a valid surface, minimum input should be 1 0 1");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
            else {
                long volume = coreService.fillWater(parsedValues);

                if(volume == 0){
                    logger.warn("From: " + req.getRemoteAddr() + ". The surface do not contains any hole");
                    req.setAttribute("error", "You entered surface without any hole, enter a new one keeping a hole");
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                }
                else {
                    logger.info("From: " + req.getRemoteAddr() + ". Calculation successfully processed, answer: " + volume);
                    req.setAttribute("answer", "Volume = " + volume);
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                }
            }
        } catch (EJBException e) {
            if(e.getCause() instanceof ArithmeticException && e.getCause().getMessage().contains("exceeds Long.MAX_VALUE")){
                logger.error("From: " + req.getRemoteAddr() + ". " + e.getMessage());
                req.setAttribute("error", "Volume exceeded maximum value that is 9223372036854775806");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
            else {
                logger.error("From: " + req.getRemoteAddr() + ". An unhandled error occurred");
                req.setAttribute("error", "An unhandled error occurred, please contact the administrator");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } catch (NumberFormatException e) {
            logger.error("From: " + req.getRemoteAddr() + ". Maximum value allowed is 2^64-1");
            req.setAttribute("error", "Invalid number entered, Maximum allowed value is 9223372036854775806");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (Exception e) {
            logger.error("From: " + req.getRemoteAddr() + ". An unhandled error occurred", e);
            req.setAttribute("error", "An unhandled error occurred, please contact the administrator");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("From: " + req.getRemoteAddr() + ". Received request.");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
