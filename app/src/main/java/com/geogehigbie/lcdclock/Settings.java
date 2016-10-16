package com.geogehigbie.lcdclock;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

/**
 * Created by geogehigbie on 9/19/16.
 */

public class Settings extends AppCompatActivity {

    String[] colorNames;
    String[] colorsHex;
    int[] colorsArray;
    public int selectedColorInt;

    String[] timeZones;
    String timeZoneSelected;
    public int subtractedTimeZone;

    public boolean is24;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        Bundle extras = getIntent().getExtras();
        extraFinder(extras);

        createColorSpinner();
        createTimeZoneSpinner();

        switchSetttings();
    }

    public void extraFinder(Bundle bundle){
        if (bundle != null) {
            selectedColorInt = bundle.getInt("selectedColor");
            subtractedTimeZone = bundle.getInt("subtractedTimeZone");
            is24 = bundle.getBoolean("is24");
        }
    }


    public void switchSetttings(){
        Switch on24Switch2 = (Switch) findViewById(R.id.swicth24);

        if(is24){
            on24Switch2.setChecked(true);
        }
        else{
            on24Switch2.setChecked(false);
        }


        on24Switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    is24 = true;
                } else {
                    is24 = false;
                }
            }
        });

    }


    public void createColorSpinner() {

        colorNames = new String[]{"Clock Color", "Default", "Green", "Red", "Blue", "Dark Green"};

        colorsHex = new String[]{"#1c80d7", "#1c80d7", "#07F53E", "#FE0000", "#436EF3", "#359B5D"};
        colorsArray = new int[colorsHex.length];

        for (int i = 0; i < colorsHex.length; i++) {
            colorsArray[i] = Color.parseColor(colorsHex[i]);
        }

        Spinner settingsColorSpinner = (Spinner) findViewById(R.id.settingsColorChooser);

        ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, colorNames);

        settingsColorSpinner.setAdapter(colorAdapter);

        int spinnerPosition;

        //sets position of spinner from previous selection
        if(selectedColorInt == colorsArray[0] || selectedColorInt == colorsArray[1]){
            spinnerPosition = colorAdapter.getPosition(colorNames[1]);
            settingsColorSpinner.setSelection(spinnerPosition);
        }
        else if(selectedColorInt == colorsArray[2]){
            spinnerPosition = colorAdapter.getPosition(colorNames[2]);
            settingsColorSpinner.setSelection(spinnerPosition);
        }
        else if(selectedColorInt == colorsArray[3]){
            spinnerPosition = colorAdapter.getPosition(colorNames[3]);
            settingsColorSpinner.setSelection(spinnerPosition);
        }
        else if(selectedColorInt == colorsArray[4]){
            spinnerPosition = colorAdapter.getPosition(colorNames[4]);
            settingsColorSpinner.setSelection(spinnerPosition);
        }
        else if(selectedColorInt == colorsArray[5]){
            spinnerPosition = colorAdapter.getPosition(colorNames[5]);
            settingsColorSpinner.setSelection(spinnerPosition);
        }

        //sets on click listener for the spinner
        settingsColorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedColor = parent.getItemAtPosition(position).toString();
                if (selectedColor.equals(colorNames[1])) {
                    selectedColorInt = colorsArray[1];

                } else if (selectedColor.equals(colorNames[2])) {
                    selectedColorInt = colorsArray[2];

                } else if (selectedColor.equals(colorNames[3])) {
                    selectedColorInt = colorsArray[3];

                } else if (selectedColor.equals(colorNames[4])) {
                    selectedColorInt = colorsArray[4];

                } else if (selectedColor.equals(colorNames[5])) {
                    selectedColorInt = colorsArray[5];

                } else if (selectedColor.equals(colorNames[0])) {
                   // changeColors(colorsArray[0]);
                    selectedColorInt = colorsArray[0];

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



    public void createTimeZoneSpinner() {

        timeZones = new String[]{"Time Zone", "Default", "Eastern", "Central", "Mountain", "Pacific"};

        Spinner settingsTimeZoneSpinner = (Spinner) findViewById(R.id.settingsTimeZone);

        ArrayAdapter<String> timeZoneAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, timeZones);

        settingsTimeZoneSpinner.setAdapter(timeZoneAdapter);

        int spinnnerPosition;
        //sets default selection of spinner
        if(subtractedTimeZone == 0){
            spinnnerPosition = timeZoneAdapter.getPosition(timeZones[2]);
            settingsTimeZoneSpinner.setSelection(spinnnerPosition);
        }
        else if(subtractedTimeZone == 1){
            spinnnerPosition = timeZoneAdapter.getPosition(timeZones[3]);
            settingsTimeZoneSpinner.setSelection(spinnnerPosition);
        }
        else if(subtractedTimeZone == 2){
            spinnnerPosition = timeZoneAdapter.getPosition(timeZones[4]);
            settingsTimeZoneSpinner.setSelection(spinnnerPosition);
        }
        else if(subtractedTimeZone == 3){
            spinnnerPosition = timeZoneAdapter.getPosition(timeZones[5]);
            settingsTimeZoneSpinner.setSelection(spinnnerPosition);
        }

        settingsTimeZoneSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedTimeZone = parent.getItemAtPosition(position).toString();
                if (selectedTimeZone.equals(timeZones[0])) {
                    timeZoneSelected = timeZones[0];
                    subtractedTimeZone = 0;

                } else if (selectedTimeZone.equals(timeZones[2])) {
                    timeZoneSelected = timeZones[2];
                    subtractedTimeZone = 0;

                } else if (selectedTimeZone.equals(timeZones[3])) {
                    timeZoneSelected = timeZones[3];
                    subtractedTimeZone = 1;

                } else if (selectedTimeZone.equals(timeZones[4])) {
                    timeZoneSelected = timeZones[4];
                    subtractedTimeZone = 2;

                } else if (selectedTimeZone.equals(timeZones[5])) {
                    timeZoneSelected = timeZones[5];
                    subtractedTimeZone = 3;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }



    public void onClickSettings2(View view){
        Intent returnIntent = new Intent(this, MainActivity.class);

        returnIntent.putExtra("selectedColor", selectedColorInt);
        returnIntent.putExtra("subtractedTimeZone", subtractedTimeZone);
        returnIntent.putExtra("is24", is24);

        setResult(RESULT_OK, returnIntent);
        finish();
    }


}



