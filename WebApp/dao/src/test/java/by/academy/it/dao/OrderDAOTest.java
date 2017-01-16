package by.academy.it.dao;

import by.academy.it.pojos.Order;
import junit.framework.TestCase;

/**
 * Created by Asus on 16.01.2017.
 */
public class OrderDAOTest extends TestCase {
    private OrderDAO ordDao;

    public void testRead() throws Exception {




    }

    public void testCreate() throws Exception {
        Order ord=new Order();
        ord.setFio("test");
        ord.setPassport("MP2569888");
        ord.setPhone(123656666);
        ord.setCategory("econom");
        ord.setArrive(889632);
        ord.setLeave(889636);
        ord.setPayment("cash");

        ord.setFK_status(1);



    }

    public void testUpdate() throws Exception {

    }

    public void testDelete() throws Exception {

    }
}