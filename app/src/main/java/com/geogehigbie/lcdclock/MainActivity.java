package com.geogehigbie.lcdclock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Date today = new Date();
    private SimpleDateFormat simpleDay = new SimpleDateFormat("EEEE");
    private String dayOfWeek = simpleDay.format(today);

    private Calendar cal = Calendar.getInstance();
    private int month = cal.get(Calendar.MONTH);
    private int dateOfMonth = cal.get(Calendar.DAY_OF_MONTH);

    private int hour = cal.get(Calendar.HOUR_OF_DAY);
    private int minute = cal.get(Calendar.MINUTE);
    private int second = cal.get(Calendar.SECOND);
    private int millisec = cal.get(Calendar.MILLISECOND);
    private int second2 = second %2;
    public boolean is24 = false;  // used to set to 24 hour time or 12 hour time

    public int selectedColorNum;

    private int hour1;
    private int hour2;
    private int minute1;
    private int minute2;

    private String AMPM;
    private TextView updatedAMPM;


    private DigitView hr1;
    private DigitView hr2;
    private DigitView min1;
    private DigitView min2;
    private Separator separator;

    private int subtractedTimeZone = 0;

    public int selectedColorInt;
    public int subtractedTimeZoneInt;
    public boolean is24bool;

    private TextView monthAndDayText;
    private TextView dayText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        selectedColorNum = ContextCompat.getColor(this, R.color.LCDBlue);

        if(savedInstanceState != null){
            subtractedTimeZone = savedInstanceState.getInt("subtractedTimeZone");
            hour = savedInstanceState.getInt("hour");
            AMPM = savedInstanceState.getString("AMPM");
            hour1 = savedInstanceState.getInt("hour1");
            hour2 = savedInstanceState.getInt("hour2");
            minute1 = savedInstanceState.getInt("minute1");
            minute2 = savedInstanceState.getInt("minute2");
            selectedColorNum = savedInstanceState.getInt("selectedColorNum");
            is24 = savedInstanceState.getBoolean("is24");
           // AMPM = savedInstanceState.getString("AMPM");
        }

        displayDayOfWeek(dayOfWeek);
        displayMonthAndDay(month, dateOfMonth);
        displayAMPM();
        blinkingSeparator();

        twentyFourHourShift();
        addSettingsIcon();
        changeColors();

        runHandler1();
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("subtractedTimeZone", subtractedTimeZone);
        savedInstanceState.putInt("hour", hour);
        savedInstanceState.putInt("hour1", hour1);
        savedInstanceState.putInt("hour2", hour2);
        savedInstanceState.putInt("minute1", minute1);
        savedInstanceState.putInt("minute2", minute2);
        savedInstanceState.putInt("selectedColorNum", selectedColorNum);
        savedInstanceState.putBoolean("is24", is24);
        savedInstanceState.putString("AMPM", AMPM);
    }


    public void addSettingsIcon(){

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.screen1);
        final ImageView settingsImage = (ImageView) findViewById(R.id.hiddenSettingsIcon);
        relativeLayout.setOnClickListener(new RelativeLayout.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(settingsImage.getVisibility() == View.VISIBLE) {
                    settingsImage.setVisibility(View.GONE);
                }
                else {
                    settingsImage.setVisibility(View.VISIBLE);
                }
            }
        });

    }


    public void runHandler1() {
        Handler handler1 = new Handler();
        Runnable runnable1 = new Runnable() {
            public void run() {

                today = new Date();
                cal = Calendar.getInstance();

                hour = cal.get(Calendar.HOUR_OF_DAY) - subtractedTimeZone;
                minute = cal.get(Calendar.MINUTE);
                second = cal.get(Calendar.SECOND);
                millisec = cal.get(Calendar.MILLISECOND);
                second2 = second %2;

                Log.d("HANDLER", "Time: Sec " + second);
                Log.d("HANDLER", "Time: Sec2 " + second2);


                displayAMPM();
                twentyFourHourShift();
                addSettingsIcon();
                changeColors();

                blinkingSeparator();
                second2 = second;

                runHandler1();
            }
        };

        handler1.postDelayed(runnable1, 500);
    }

//        Runnable runnable2 = new Runnable() {
//            @Override
//            public void run() {
//
//                int second2 = cal.get(Calendar.SECOND);
//
//                Log.d("HANDLER", "Time: Sec2 " + second2);
//            }
//        };
//        handler1.postDelayed(runnable2, 2000);
//    }

//    public void runHandler2(){
//        Handler handler2 = new Handler();
//        Runnable runnable2 = new Runnable(){
//            public void run(){
//
//                int second2 = cal.get(Calendar.SECOND);
//
//                Log.d("HANDLER2", "Time: Sec2 " + second2 );
//                runHandler2();
//            }
//        };
//        handler2.postDelayed(runnable2, 2000);
//    }

    public void displayDayOfWeek(String day){
        day = day + ",";
        dayText = (TextView) this.findViewById(R.id.dayOfWeek);
        dayText.setText(day);
    }

    public void displayMonthAndDay(int monthInt, int dayDate){
        String monthString;
        String dayDateString = String.valueOf(dayDate);

        switch (monthInt){
            case 0:
                monthString = "January";
                break;

            case 1:
                monthString = "February";
                break;

            case 2:
                monthString = "March";
                break;

            case 3:
                monthString = "April";
                break;

            case 4:
                monthString = "May";
                break;

            case 5:
                monthString = "June";
                break;

            case 6:
                monthString = "July";
                break;

            case 7:
                monthString = "August";
                break;

            case 8:
                monthString = "September";
                break;

            case 9:
                monthString = "October";
                break;

            case 10:
                monthString = "November";
                break;

            case 11:
                monthString = "December";
                break;

            default:
                monthString = "No Month";
        }
        String monthAndDayString = monthString + " " + dayDateString;

        monthAndDayText = (TextView) this.findViewById(R.id.month);
        monthAndDayText.setText(monthAndDayString);

    }


    public void displayAMPM() {

        if (hour < 12 ) {
            AMPM = "AM";
        }
        else{
            AMPM = "PM";
        }

        if(is24 == true){
            AMPM = "";
        }

        updatedAMPM = (TextView) findViewById(R.id.ampm);
        updatedAMPM.setText(AMPM);
    }


    public void twentyFourHourShift() {

        if (!is24 && hour > 12) {
            hour = hour - 12;
        }

        hour1 = Integer.parseInt(Integer.toString(hour).substring(0, 1));
        hour2 = (hour % 10);

        if (hour < 10) {
            hour1 = -1;
        }

        if (minute < 10) {
            minute1 = 0;
            minute2 = minute;
        } else {
            minute1 = Integer.parseInt(Integer.toString(minute).substring(0, 1));
            minute2 = minute % 10;
        }

        //special case
        if(hour == 0 && is24 == false){
            hour1 = 1;
            hour2 = 2;
        }


        hr1 = (DigitView) this.findViewById(R.id.hr1);
        hr2 = (DigitView) this.findViewById(R.id.hr2);
        min1 = (DigitView) this.findViewById(R.id.min1);
        min2 = (DigitView) this.findViewById(R.id.min2);

        hr1.display(hour1);
        hr2.display(hour2);
        min1.display(minute1);
        min2.display(minute2);
    }


    public void blinkingSeparator() {
        separator = (Separator) this.findViewById(R.id.sep);
        separator.display(second2);
    }

    public void changeColors() {
        hr1.LCDColor = selectedColorNum;
        hr2.LCDColor = selectedColorNum;
        min1.LCDColor = selectedColorNum;
        min2.LCDColor = selectedColorNum;
        separator.LCDColor = selectedColorNum;
        updatedAMPM.setTextColor(selectedColorNum);
        dayText.setTextColor(selectedColorNum);
        monthAndDayText.setTextColor(selectedColorNum);

    }


    public void onClickSettings(View view){
        Intent intentSettings = new Intent(this, Settings.class);
        intentSettings.putExtra("selectedColor", selectedColorNum);
        intentSettings.putExtra("subtractedTimeZone", subtractedTimeZone);
        intentSettings.putExtra("is24", is24);
        startActivityForResult(intentSettings, 1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode ==1){
            if(resultCode == Activity.RESULT_OK){
                selectedColorInt = data.getIntExtra("selectedColor", selectedColorInt);
                subtractedTimeZoneInt = data.getIntExtra("subtractedTimeZone", subtractedTimeZone);
                is24bool = data.getBooleanExtra("is24", is24);
            }
        }
        //changes variables which change functions called in handler
        subtractedTimeZone = subtractedTimeZoneInt;
        selectedColorNum = selectedColorInt;
        is24 = is24bool;
    }


}

