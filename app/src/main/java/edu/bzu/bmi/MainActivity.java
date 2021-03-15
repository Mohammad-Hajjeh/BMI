package edu.bzu.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtMass;
    EditText edtHeight;
    TextView txtres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtMass=findViewById(R.id.edtMass);
        edtHeight=findViewById(R.id.edtHeight);
        txtres=findViewById(R.id.txtres);

    }

    public void calculateBMI(View view) {
        double result;
        double m,h;
        String mass = edtMass.getText().toString().trim();
        String height =edtHeight.getText().toString().trim();
        String res;
        String resn;
        if(!mass.isEmpty()&&!height.isEmpty())
        {
        m=Double.parseDouble(mass);
        h=Double.parseDouble(height);
        result=(m)/(h*h);
        res=String.valueOf(result);
        if(result<18.5)
            resn="Underweight";
        else  if(result>=18.5 && result<=24.9)
            resn="Normal Weight";
        else
            resn="Overweight";
        txtres.setText("The BMI Is: "+res+"\n"+"The Weight Status Is: "+resn);
        }
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}