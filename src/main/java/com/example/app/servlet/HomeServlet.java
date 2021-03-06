package com.example.app.servlet;

import com.example.app.dao.CarDao;
import com.example.app.dao.DaoFactory;
import com.example.app.model.Car;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.example.app.servlet.HomeServlet.URL;

@WebServlet(urlPatterns = {"/home", URL})
public class HomeServlet extends HttpServlet {

    public static final String URL = "/list-car";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarDao carDao = DaoFactory.getCarDao();
        List<Car> carList = carDao.findAll();

        req.setAttribute("carList", carList);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/carlist.jsp");
        rd.forward(req, resp);
    }
}
