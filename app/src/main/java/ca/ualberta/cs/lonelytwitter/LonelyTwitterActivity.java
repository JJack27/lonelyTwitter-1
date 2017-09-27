/*
 * LonelyTwitterActivity
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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * The class for the main activity
 * @author Yizhou Zhao
 * @since 1.0
 */
public class LonelyTwitterActivity extends Activity {
	/**
	 * A constant String object store the file name
	 */
	private static final String FILENAME = "file.sav";
	/**
	 * A String object store the text in the editText
	 */
	private EditText bodyText;
	/**
	 * A ListView object store the Tweet list
	 */
	private ListView oldTweetsList;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				NormalTweet newTweet = new NormalTweet("Hello");
				ImportantTweet newTweet2 = new ImportantTweet("hello", new Date());

				newTweet2.getDate();

				try {
					newTweet.setMessage("Goodbye");
				} catch (TweetTooLongException e){

				}
				Log.d("TWEET", newTweet.getMessage());


				ArrayList<Tweet> tweetList = new ArrayList<Tweet>();
				tweetList.add(newTweet);
				tweetList.add(newTweet2);

				saveInFile(text, new Date(System.currentTimeMillis()));
				//finish();

			}
		});
	}

	/**
	 * Call after onCreate(), will load a file that contains the tweet data.
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		String[] tweets = loadFromFile();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * Load the file that storing the tweet data, and return them by a String list.
	 * @return An String list that contains a list of tweets
	 */
	private String[] loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets.toArray(new String[tweets.size()]);
	}

	/**
	 * Save the user input and the time they click on the save button to the file.
	 * @param text the message of the tweet.
	 * @param date the date of the tweet.
	 */
	private void saveInFile(String text, Date date) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			fos.write(new String(date.toString() + " | " + text)
					.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}