package testissues;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
//import antlr.collections.List;

import org.junit.Before;
import org.junit.Test;

import issueManager.Issue;
import issueManager.IssueParser;
import issueManager.User;

public class IssueParserTest {

    private String str;

    @Before
    public void setup() throws Exception {

        BufferedReader bufferedReader = new BufferedReader(
                new FileReader("sample-output.txt"));

        StringBuilder stringBuffer = new StringBuilder();
        String line = bufferedReader.readLine();
        while (line != null) {
            stringBuffer.append(line).append("\n");
            line = bufferedReader.readLine();
        }
        str = stringBuffer.toString();
        System.out.println(stringBuffer);
    }

    @Test
    public void testparseIssues() {
        IssueParser issparser = new IssueParser();

        List<Issue> isp = issparser.parseIssues(str);
        Issue issue1 = isp.get(1);
        // IssueMain issue1 = (IssueMain) isp.get(1);
        User u1 = new User();

        u1.setLogin("sampath");
        u1.setId("25");

        // assertEquals(u1, issue1.getUser());

        // assertEquals(u1, issue1.getAssignee());
        // assertNotNull(isp);
        assertEquals(2, isp.size());
        // assertEquals("ISSUE1", issue1.getBody());
        assertEquals(294583003, issue1.getId());
        // assertEquals("issue 3", issue1.getTitle());

    }

}
