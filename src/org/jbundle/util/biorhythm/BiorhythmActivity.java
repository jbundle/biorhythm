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

public class BiorhythmActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // capture our View elements
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

    }

    // the callback received when the user "sets" the date in the dialog
    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year, 
                                      int monthOfYear, int dayOfMonth) {
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
                }
            };
            
            @Override
            protected Dialog onCreateDialog(int id) {
                switch (id) {
                case DATE_DIALOG_ID:
                    // get the current date
                    Date birthdate = controller.getBirthdate();
                    Calendar c = Calendar.getInstance();
                    c.setTime(birthdate);
                    int mYear = c.get(Calendar.YEAR);
                    int mMonth = c.get(Calendar.MONTH);
                    int mDay = c.get(Calendar.DAY_OF_MONTH);

                    return new DatePickerDialog(this,
                                mDateSetListener,
                                mYear, mMonth, mDay);
                }
                return null;
            }
            
    private Controller controller = null;
    
    private Button mPickDate;

    static final int DATE_DIALOG_ID = 0;
}