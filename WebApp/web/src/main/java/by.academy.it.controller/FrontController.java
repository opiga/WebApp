package by.academy.it.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import by.academy.it.services.*;

@WebServlet(urlPatterns = "/do", name = "FrontController")
public class FrontController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action = Actions.defineFrom(req);
        Action nexAction = action.execute(req, resp);
//        Action nexAction = action.execute(req,null);
        if (nexAction == null) {
            RequestDispatcher r =
                    getServletContext().
                            getRequestDispatcher(action.getJsp());
            r.forward(req, resp);
        } else
            resp.sendRedirect("do?command=" + nexAction);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action = Actions.defineFrom(req);
        Action nexAction = action.execute(req, resp);
        if (nexAction == null) {
            RequestDispatcher r =
                    getServletContext().
                            getRequestDispatcher(action.getJsp()); //определяется джп страница
            r.forward(req, resp);//перенаправляется управление на эту страницу
        } else
            resp.sendRedirect("do?command=" + nexAction);
    }
}