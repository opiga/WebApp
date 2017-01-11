package by.academy.it.services;

import by.academy.it.dao.*;
import by.academy.it.pojos.User;
import by.academy.it.services.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdUpdate extends Action {
    @Override
    public Action execute(HttpServletRequest req,HttpServletResponse resp) {
        User user = new User();
        try {
            user.setLogin(req.getParameter("Login"));
            user.setPass(Form.getString(req, "Password", Patterns.PASSWORD));
            user.setEmail(Form.getString(req, "Email", Patterns.EMAIL));
            user.setFK_role(2);

        } catch (Exception e) {
            req.setAttribute(Messages.msgError, "NO VALID FIELDS");
            return null;
        }
        DAO dao = DAO.getDAO();
        if (dao.user.update(user)) {
            req.setAttribute(Messages.msgMessage, "ORDER ADDED");
            return Actions.CREATEORDER.action;
        } else
            req.setAttribute(Messages.msgError, "FILL ERROR");
        return null;
    }
}
