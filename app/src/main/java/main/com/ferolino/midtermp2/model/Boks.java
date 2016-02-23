package main.com.ferolino.midtermp2.model;

/**
 * Created by Christian on 2/23/2016.
 */
public class Boks {
    private String title;
    private String isRead;
    public Boks() {

    }
    public Boks(String title, String isRead) {
        this.title = title;
        this.isRead = isRead;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }
}
