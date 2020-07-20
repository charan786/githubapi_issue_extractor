package testissues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import issueManager.Issue;
import issueManager.User;

public class IssueTest {

    Issue issue1 = new Issue();
    Issue issue2 = new Issue();
    User u1 = new User();
    User u2 = new User();

    @Before
    public void set() {
        issue1.setId(123);
        issue1.setNumber(10);
        issue1.setState(true);
        issue1.setBody("iss");
        issue1.setTitle("null");
        issue1.setAssignee(u1);
        issue1.setUser(u1);
        issue1.setClosedat(null);
        issue1.setCreatedat(null);
        // issue1.setCreatedat( "02/17/2018");

        issue2.setId(123);
        issue2.setState(true);
        issue2.setBody("iss");
        issue2.setTitle("nu");
        issue2.setAssignee(u1);
        issue2.setUser(u1);
        issue2.setClosedat(null);
        issue2.setCreatedat(null);

        u1.setLogin("sampath");
        u2.setLogin("sampath");
    }

    @Test
    public void testIssueEquals() {

        assertTrue(issue1.equals(issue2));
        assertTrue(issue1.equals(issue1));

        int m = issue1.getNumber();
        assertEquals(m, issue1.getNumber());

    }

    @Test
    public void testUserEquals()

    {
        assertTrue(u1.equals(u2));
    }

    @Test
    public void testUserHashCode()

    {
        assertTrue(u1.hashCode() == u2.hashCode());
    }

    @Test
    public void testIssueHashCode() throws Exception

    {
        assertTrue(issue1.hashCode() == issue2.hashCode());
        // IssueExporter.main(null);
    }

    @Test
    public void testToString() throws IOException {

        issue1.setId(123);
        issue1.setNumber(10);
        issue1.setState(true);
        issue1.setBody("iss");

        System.out.println(issue1.toString());

        assertEquals(
                "IssueMain [number=10, id=123, state=true, title=null, body=iss, createdat=null, closedat=null, user=User [login=sampath, id=null], assignee=User [login=sampath, id=null]]",
                issue1.toString());
        // assertEquals(str, issue1.toString());

    }

    @Test
    public void testEqualsTo() {

        issue1.setId(42);
        issue2.setId(42);
        assertEquals(0, issue1.compareTo(issue2));
        assertTrue(issue1.equals(issue2));

    }

    @Test
    public void testGreater() {
        issue1.setId(47);
        issue2.setId(42);
        assertEquals(1, issue1.compareTo(issue2));

    }

    @Test
    public void testLessThan() {

        issue1.setId(38);
        issue2.setId(42);
        assertEquals(-1, issue1.compareTo(issue2));

    }

}
