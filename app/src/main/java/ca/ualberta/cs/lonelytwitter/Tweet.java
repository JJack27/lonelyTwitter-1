/*
 * Tweet
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

import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a tweet.
 *
 * @author Yizhou Zhao
 * @version 1.0
 * @see NormalTweet
 * @see ImportantTweet
 * @since 1.0
 */
public abstract class Tweet {

    /**
     * A String object stores the message of tweet objects
     */
    private String message;
    /**
     * A Date object stores the date of tweet objects
     */
    private Date date;

    /**
     * Constructs a tweet object
     * @param message tweet message
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * Constructs a tweet object
     * @param message tweet message
     * @param date  tweet date
     */
    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    public abstract Boolean isImportant();

    /**
     * Sets the message for a tweet object
     *
     * @param message tweet message
     * @throws TweetTooLongException throws when tweet is longer than 140 characters
     */
    public void setMessage(String message) throws TweetTooLongException{
        if (message.length() > 140){
            throw new TweetTooLongException();
        } else {
            this.message = message;
        }
    }

    /**
     * Get message from Tweet object
     * @return message of tweet object
     */
    public String getMessage(){
        return this.message;
    }

    /**
     * Get date of Tweet object
     * @return date of tweet object
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * Set the date of a tweet object
     * @param date The date of tweet object
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Return a string for tweet object so that it's printable
     * @return the string contains date and message of a tweet object
     */
    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }
}

