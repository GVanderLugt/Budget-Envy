//EnvelopeEdit
package com.example.budgetenvy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//import com.example.budgetenvy.R;

public class EnvelopeEdit extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envelopeedit);

        //Retrieve envelope data
        Intent i = getIntent();
        Bundle data = i.getExtras();

        String envelopeName = data.getString("envelopeName");
        int envelopeBudget = data.getInt("envelopeBudget");
        int envelopeBalance = data.getInt("envelopeBalance");
        final int envelopeIndex = data.getInt("envelopeIndex");

        //Set envelope name
        final EditText nameEditText = (EditText) findViewById(R.id.envelopeName);
        nameEditText.setText(envelopeName, TextView.BufferType.EDITABLE);

        //Set envelope budget
        final EditText budgetEditText = (EditText) findViewById(R.id.txtBudget);
        budgetEditText.setText(String.valueOf(envelopeBudget), TextView.BufferType.EDITABLE);

        //Set envelope balance
        final TextView balanceTextView = (TextView) findViewById(R.id.envelopeBalance);
        balanceTextView.setText("Balance: " + envelopeBalance);

        //Set up onClickListener for btnDeposit
        Button btnDeposit = (Button) findViewById(R.id.btnDeposit);
        btnDeposit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                System.out.println("You pressed btnDeposit");
            }
        });

        //Set up onClickListener for btnWithdraw
        Button btnWithdraw = (Button) findViewById(R.id.btnWithdraw);
        btnWithdraw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                System.out.println("You pressed btnWithdraw");
            }
        });

        //Set up onClickListener for btnSaveEnvelope
        Button btnSaveEnvelope = (Button) findViewById(R.id.btnSaveEnvelope);

        final int balance = envelopeBalance;

        btnSaveEnvelope.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                System.out.println("You pressed btnSaveEnvelope");

                //Get data from activity
                String envelopeName = nameEditText.getText().toString();
                String envelopeBudget = budgetEditText.getText().toString();

                System.out.println(envelopeBudget);

                //Return data to MainActivity and close current activity
                Intent returnIntent = new Intent();
                returnIntent.putExtra("envelopeName", envelopeName);
                returnIntent.putExtra("envelopeBudget", envelopeBudget);
                returnIntent.putExtra("envelopeBalance", balance);
                returnIntent.putExtra("envelopeIndex", envelopeIndex);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

        // TODO Auto-generated method stub
    }

}
