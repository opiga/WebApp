package by.academy.it.services;

import by.academy.it.dao.*;
import by.academy.it.services.*;
import by.academy.it.pojos.Order;
import by.academy.it.pojos.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Asus on 31.10.2016.
 */
public class CmdIndex extends Action {

    //    private String debugOut(List<Order> orders) {
//        StringBuilder out=new StringBuilder();
//        for (Order ord:orders){
//            out.append(ord.toString()).append("<br>");
//        }
//        return out.toString();
//    }
//
//    @Override
//    Action execute(HttpServletRequest req,HttpServletResponse resp) {
//        DAO by.academy.it.dao=DAO.getDAO();
//        req.setAttribute("ads","<hr>"+debugOut(by.academy.it.dao.order.getAll(""))+"<hr>");
//        return null;
//    }
    @Override
    public Action execute(HttpServletRequest req, HttpServletResponse resp) {
        Order order = new Order();
        User user = new User();
//    Role roles=new Role();
        HttpSession session = req.getSession();
        User amd = (User) session.getAttribute("user");
        if (amd == null) {
            return Actions.LOGIN.action;
        }
        else {
            req.setAttribute(Messages.msgMessage, amd.getID());
            DAO dao = DAO.getDAO();
//            if (Form.isPost(req)) {

//                try {
//                    order.setId(Form.getInt(req, "ID"));
//                    order.setFio(Form.getString(req, "fio", Patterns.LOGIN));
//                    order.setPassport(Form.getString(req, "passport", Patterns.LOGIN));
//                    order.setPhone(Form.getInt(req, "phone"));
//                    order.setCategory(Form.getString(req, "category", Patterns.LOGIN));
//                    order.setPayment(Form.getString(req, "payment", Patterns.LOGIN));
////                    order.setArrive(Form.getLong(req, "arrive"));
////                    order.setLeave(Form.getLong(req, "leavee"));
////                    order.setFK_status(Form.getInt(req, "fk_status"));
////                if (order.getFK_user()==idUser) {
////                    by.academy.it.dao.user.update(user);
////                }
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                    req.setAttribute(Messages.msgMessage, e.getMessage());
//                }
//            }
//        req.setAttribute("orders", by.academy.it.dao.order.getAll("WHERE fk_user='25'"));}
            req.setAttribute("orders", dao.order.getAll("WHERE FK_user="+ amd.getID()));
        }
        return null;

    }
}
