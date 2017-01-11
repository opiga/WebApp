package by.academy.it.services;

import by.academy.it.dao.DAO;
import by.academy.it.pojos.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

public class CmdLogin extends Action {
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) {
        User user = new User();

        if (Form.isPost(req)) {
            try {
                user.setLogin(Form.getString(req, "Login", Patterns.LOGIN));
                user.setPass(req.getParameter("Password"));
            } catch (Exception e) {
                req.setAttribute(Messages.msgError, "NO VALID FIELDS");
                return null;
            }
            DAO dao = DAO.getDAO();
            List<User> users = dao.user.getAll(
                    String.format(Locale.ENGLISH, "WHERE login='%s' AND pass='%s'",
                            user.getLogin(),
                            user.getPass()
                    ));
            System.out.println(users);
            if (users.size() > 0) {
                user = users.get(0);
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                session.setAttribute("userLogin", user.getLogin());

                Cookie cookie = new Cookie("user", user.getLogin());
                Cookie cookie2 = new Cookie("pass", MD5.md5Custom(user.getPass()));

                cookie.setMaxAge(60);
                cookie2.setMaxAge(60);
                resp.addCookie(cookie);
                resp.addCookie(cookie2);

//              session.setMaxInactiveInterval(30);
                return Actions.SHOWUSERS.action;

            } else
                req.setAttribute(Messages.msgError, "NO SUCH USER");
        }
        return null;
    }

}
