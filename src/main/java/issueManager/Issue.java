package issueManager;

import java.util.Date;

public class Issue implements Comparable<Issue> {

    private int number;
    private int id;
    private boolean state;
    private String title;
    private String body;
    User user = new User();
    User assignee = new User();
    private Date closedAt;
    private Date createdAt;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Issue other = (Issue) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    public Issue() {
        super();
    }

    @Override
    public String toString() {
        return "IssueMain [number=" + number + ", id=" + id + ", state=" + state
                + ", title=" + title + ", body=" + body + ", createdat="
                + createdAt + ", closedat=" + closedAt + ", user=" + user
                + ", assignee=" + assignee + "]";
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Date getCreatedat() {
        return null;
    }

    public void setCreatedat(Date createdat) {
        this.createdAt = createdat;
    }

    public Date getClosedat() {
        return null;
    }

    public void setClosedat(Date closedat) {
        this.closedAt = closedat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public int compareTo(Issue o) {
        int x = 0;

        if (this.id > o.id) {
            x = 1;
        }
        else if (this.id < o.id) {
            x = -1;
        }
        else {
            x = 0;
        }
        return x;
    }

}
