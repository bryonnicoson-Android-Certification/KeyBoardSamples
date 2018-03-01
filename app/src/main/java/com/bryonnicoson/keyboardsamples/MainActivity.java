package com.bryonnicoson.keyboardsamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView mTextViewPhone;
    private String mSpinnerLabel = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewPhone = findViewById(R.id.textView_phone);

        // Create the spinner.
        Spinner spinner = findViewById(R.id.spinner_main);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        // Create ArrayAdapter using string array and default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    public void showText(View view) {
        EditText editText = findViewById(R.id.editText_main);
        if (editText != null) {
            String showString = (editText.getText().toString() + " - " + mSpinnerLabel);
            mTextViewPhone.setText(showString);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mSpinnerLabel = parent.getItemAtPosition(position).toString();
        showText(view);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.d(TAG, "onNothingSelected: ");
    }
}
