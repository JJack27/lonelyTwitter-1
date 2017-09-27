/*
 * ImportantTweet
 *
 * Version 1.0
 *
 * September 26, 2017
 *
 * Copyright 2017 Team 4, CMPUT 301, University of Alberta. All rights reserved.
 * You may use, distribute, or modify this code under terms and conditirions of the Code of Student Behaviour at University of Alberta.
 * You may find a copy of the license in this project. Otherwise, please contact yizhou4@ualberta.ca.
 */
package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Subclass of Tweet, represents an important Tweet.
 * @author Yizhou Zhao
 * @see Tweet
 * @since 1.0
 */
public class ImportantTweet extends Tweet implements Tweetable {
    /**
     * Construct a ImportantTweet object
     * @param message
     */
    public ImportantTweet(String message){
        super(message);
    }

    /**
     * Construct a ImportantTweet object
     * @param message
     * @param date
     */
    public ImportantTweet(String message, Date date) {
        super(message, date);
    }

    /**
     * Indicate if this tweet is important or not.
     * @return true, means this is an important tweet.
     */
    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }
}
