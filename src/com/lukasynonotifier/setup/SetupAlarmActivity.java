package com.lukasynonotifier.setup;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lukasynonotifier.alarms.AbstractAlarmActivity;
import com.lukasynonotifier.alarms.CalendarActivity;
import com.lukasynonotifier.alarms.ElapsedTimeActivity;
import com.lukasynonotifier.events.ColorTransition;
/**
 * 
 * @author Lukas
 *TODO:
 *make activity for registered alarms
 */
public class SetupAlarmActivity extends Activity {
	public static final String TARGET_NUMBER = "number";
	public static final String TARGET_MESSAGE = "message";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final LinearLayout lay = (LinearLayout) findViewById(R.id.LinearColorLay);
		ColorTransition.start(lay);
	}

	public void createElapsedAlarm(View v) {
		EditText numb = (EditText) findViewById(R.id.number2sent);
		EditText mess = (EditText) findViewById(R.id.message2sent);

		Intent intent = new Intent();
		intent.setClass(this, ElapsedTimeActivity.class);
		intent.putExtra(TARGET_NUMBER, numb.getText().toString());
		intent.putExtra(TARGET_MESSAGE, mess.getText().toString());

		startActivity(intent);
	}

	public void createCalendarAlarm(View v) {
		EditText numb = (EditText) findViewById(R.id.number2sent);
		EditText mess = (EditText) findViewById(R.id.message2sent);

		Intent intent = new Intent();
		intent.setClass(this, CalendarActivity.class);
		intent.putExtra(TARGET_NUMBER, numb.getText().toString());
		intent.putExtra(TARGET_MESSAGE, mess.getText().toString());

		startActivity(intent);
	}

	public void cancelAlarms(View view) {
		TextView txt = (TextView) findViewById(R.id.logger323);
		String numb = "";
		int howMuch = CoreApplication.AlarmListLength();
		switch (howMuch % 10) {
		case 2:
		case 3:
		case 4:
			numb = howMuch + " elementy";
			break;
		default:
			numb = howMuch + " element�w";
		}
		txt.setText("Anulowano "+numb);
		CoreApplication.cancelAlarms();
	}
}
