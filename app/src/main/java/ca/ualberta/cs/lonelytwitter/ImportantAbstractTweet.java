package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by romansky on 1/12/16.
 */
public class ImportantAbstractTweet extends AbstractTweet implements Tweetable {
    public ImportantAbstractTweet(Date date, String message) {
        super(date, message);
    }

    public ImportantAbstractTweet(String message) {
        super(message);
    }

    //@Override
    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }

    public Date getDate() {
        return this.date;
    }

    public String getMessage() {
        return "!IMPORTANT! " + this.message;
    }
}
