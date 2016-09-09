package com.br.android.android.simple.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: carneiroal
 * Date: 07/03/14
 * Time: 14:00
 * To change this template use File | Settings | File Templates.
 */
public class MainActivity extends Activity implements View.OnClickListener {
    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    TextView tvResult;

    String operator = "";

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find the elements
        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        tvResult = (TextView) findViewById(R.id.tvResult);

        // set a listener
        btnAdd.setOnClickListener((View.OnClickListener) this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        // TODO Auto-generated method stub
        float num1 = 0;
        float num2 = 0;
        float result = 0;

        // check if the fields are empty
        if (TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty(etNum2.getText().toString())) {
            return;
        }

        // read EditText and fill variables with numbers
        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        // defines the button that has been clicked and performs the corresponding operation
        // write operation into oper, we will use it later for output
        switch (view.getId()) {
            case R.id.btnAdd:
                operator = "+";
                result = num1 + num2;
                break;
            case R.id.btnSub:
                operator = "-";
                result = num1 - num2;
                break;
            case R.id.btnMult:
                operator = "*";
                result = num1 * num2;
                break;
            case R.id.btnDiv:
                operator = "/";
                result = num1 / num2;
                break;
            default:
                break;
        }

        // form the output line
        tvResult.setText(num1 + " " + operator + " " + num2 + " = " + result);
    }
}