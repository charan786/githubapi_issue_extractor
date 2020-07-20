package issueManager;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class IssueExporter {

    private static PrintWriter output;

    public static void main(String[] args) throws Exception {
        IssueExporter iexporter = new IssueExporter();
        IssueExporter.issueGenerator();

    }

    private static void issueGenerator() throws Exception {

        PrintWriter output = new PrintWriter(new FileWriter("Issues.txt"));

        System.out.println("Enter the GitHub User name");
        Scanner s = new Scanner(System.in);
        String username = s.nextLine();
        System.out.println("Enter the Password");
        Scanner sc2 = new Scanner(System.in);
        String password = s.nextLine();

        GitHubRestClient client = new GitHubRestClient();

        String json = client.requestIssues(username, password, "open");
        String json1 = client.requestIssues(username, password, "closed");

        IssueParser parser = new IssueParser();

        /*
         * Issue issue1 = new Issue(); Issue issue2 = new Issue(); Issue issue3
         * = new Issue();
         */

        List<Issue> closedissues = parser.parseIssues(json1);
        List<Issue> openissues = parser.parseIssues(json);
        openissues.addAll(closedissues);
        Collections.sort(openissues);

        output.println(openissues);

        System.out.println("the size is" + openissues.size());

        output.close();

    }

}
