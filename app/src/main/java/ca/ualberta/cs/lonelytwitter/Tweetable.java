/*
 * Tweetable
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
 * An interface that allow other class to get message and date from tweet objects
 * @author Yizhou Zhao
 * @since 1.0
 */
public interface Tweetable {
    /**
     * Allow other class to get message from a tweet object
     * @return String object contains the message of the tweet object.
     */
    String getMessage();

    /**
     * Allow other class to get date of a tweet object
     * @return Date object indicate the date of the tweet obeject.
     */
    Date getDate();
}
