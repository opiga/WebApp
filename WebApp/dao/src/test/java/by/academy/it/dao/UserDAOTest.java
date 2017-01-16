package by.academy.it.dao;

import by.academy.it.pojos.User;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Asus on 16.01.2017.
 */
public class UserDAOTest extends TestCase {
    private UserDAO usrDao=new UserDAO();
    User usr=new User("login","pass","email",1);
    int id = usr.getID();

    @Test
    public void testRead() throws Exception {
        //System.out.println(id);
        assertNotNull(usrDao.read(25));
        return;
    }

    @BeforeClass
    public void testCreate() throws Exception {
        User usr=new User("login","pass","email",1);
        usrDao.create(usr);
        Assert.assertNotNull(id);
        Assert.assertEquals("login", usr.getLogin());
        Assert.assertEquals("pass", usr.getPass());
        Assert.assertEquals("email", usr.getEmail());
        Assert.assertEquals(1, usr.getFK_role());

        return;
    }

    @Test
    public void testUpdate() throws Exception {
        User usr3=new User(id,"newlogin","newpass","newemail",1);
        assertNotNull(usrDao.update(usr3));
        return;
    }

    @AfterClass
    public void testDelete() throws Exception {
        assertNotNull(usrDao.update(usr));
        return;
    }
}