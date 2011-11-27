package org.jbundle.util.biorhythm;

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class BiorhythmActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // capture our View elements
        mDateDisplay = (TextView) findViewById(R.id.dateDisplay);
        mPickDate = (Button) findViewById(R.id.pickDate);
        View view = (View) findViewById(R.id.view1);
        String birthdateText = view.getResource().getString("Birthdate");
        if (birthdateText != null)
            mPickDate.setText(birthdateText);
        
        controller = view.getController();
        
        SharedPreferences preferences = this.getPreferences(MODE_PRIVATE);
        ((LegendController)controller).setPreferences(preferences);
        
        // add a click listener to the button
        mPickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                showDialog(DATE_DIALOG_ID);
            }
        });

        // get the current date
        Date birthdate = controller.getBirthdate();
        Calendar c = Calendar.getInstance();
        c.setTime(birthdate);
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // display the current date (this method is below)
        updateDisplay();
    }

    // updates the date in the TextView
    private void updateDisplay() {
        mDateDisplay.setText(
            new StringBuilder()
                    // Month is 0 based so add 1
                    .append(mMonth + 1).append("-")
                    .append(mDay).append("-")
                    .append(mYear).append(" "));
    }
    
    // the callback received when the user "sets" the date in the dialog
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year, 
                                      int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    
                    Calendar c = Calendar.getInstance();
                    c.set(Calendar.YEAR, year);
                    c.set(Calendar.MONTH, monthOfYear);
                    c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    c.set(Calendar.HOUR_OF_DAY, 12);
                    c.set(Calendar.MINUTE, 0);
                    c.set(Calendar.SECOND, 0);
                    c.set(Calendar.MILLISECOND, 0);
                    Date dateBirth = c.getTime();
                    controller.setBirthdate(dateBirth);
                    
                    updateDisplay();
                }
            };
            
            @Override
            protected Dialog onCreateDialog(int id) {
                switch (id) {
                case DATE_DIALOG_ID:
                    return new DatePickerDialog(this,
                                mDateSetListener,
                                mYear, mMonth, mDay);
                }
                return null;
            }
            
    private Controller controller = null;
    private TextView mDateDisplay;
    
    private Button mPickDate;
    private int mYear;
    private int mMonth;
    private int mDay;

    static final int DATE_DIALOG_ID = 0;
}