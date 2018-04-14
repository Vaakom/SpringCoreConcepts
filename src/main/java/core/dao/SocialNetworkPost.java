package core.dao;


import core.annotations.InjectRandomText;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
@Scope("prototype")
public class SocialNetworkPost {

    private DataFactory dataFactory = new DataFactory();

    private String userName;

    private String location;

    private Date date;

    private String title;

    @InjectRandomText(minLength = 10, maxLength = 100)
    private String text;

    @PostConstruct
    public void init(){
        userName = dataFactory.getFirstName();
        title = dataFactory.getRandomWord();
        location = dataFactory.getCity();
        date = dataFactory.getDate(new Date(), -7, 0);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
