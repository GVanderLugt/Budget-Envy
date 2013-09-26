//EnvelopeEditActivity
package com.example.budgetenvy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//import com.example.budgetenvy.MainActivity;
//import com.example.budgetenvy.R;
/*
public class EnvelopeEditActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envelopeedit);

        //Retrieve envelope data
        Intent i = getIntent();
        Bundle data = i.getExtras();

        final int envelopeIndex = data.getInt("envelopeIndex");

        final Envelope envelope = MainActivity.envelopeList.get(envelopeIndex);

        //Set envelope name
        final EditText nameEditText = (EditText) findViewById(R.id.envelopeName);
        nameEditText.setText(envelope.getName(), TextView.BufferType.EDITABLE);

        //Set envelope budget
        final EditText budgetEditText = (EditText) findViewById(R.id.txtBudget);
        budgetEditText.setText(String.valueOf(envelope.getBudget()), TextView.BufferType.EDITABLE);

        //Set envelope balance
        final TextView balanceTextView = (TextView) findViewById(R.id.envelopeBalance);
        balanceTextView.setText("Balance: " + envelope.getBalance());

        //Set up onClickListener for btnDeposit
        Button btnDeposit = (Button) findViewById(R.id.btnDeposit);
        btnDeposit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                System.out.println("You pressed btnDeposit");

                //Get input from user
                EditText depositEditText = (EditText) findViewById(R.id.txtDeposit);
                int depositAmount = Integer.parseInt(depositEditText.getText().toString());

                //Add to the envelope balance
                envelope.setBalance(envelope.getBalance() + depositAmount);

                //Set activity balance
                balanceTextView.setText("Balance: " + envelope.getBalance());
            }
        });

        //Set up onClickListener for btnWithdraw
        Button btnWithdraw = (Button) findViewById(R.id.btnWithdraw);
        btnWithdraw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                System.out.println("You pressed btnWithdraw");

                //Get input from user
                EditText withdrawEditText = (EditText) findViewById(R.id.txtWithdraw);
                int withdrawAmount = Integer.parseInt(withdrawEditText.getText().toString());

                //Subtract from envelope balance
                envelope.setBalance(envelope.getBalance() - withdrawAmount);

                //Set activity balance
                balanceTextView.setText("Balance: " + envelope.getBalance());
            }
        });

        //Set up onClickListener for btnSaveEnvelope
        Button btnSaveEnvelope = (Button) findViewById(R.id.btnSaveEnvelope);
        btnSaveEnvelope.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                System.out.println("You pressed btnSaveEnvelope");

                //Get data from activity
                String envelopeName = nameEditText.getText().toString();
                int envelopeBudget = Integer.parseInt(budgetEditText.getText().toString());

                //Set envelope data
                envelope.setName(envelopeName);
                envelope.setBudget(envelopeBudget);

                System.out.println(envelopeBudget);


                //Return data to MainActivity and close current activity
                Intent returnIntent = new Intent();
                returnIntent.putExtra("envelopeIndex", envelopeIndex);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

        // TODO Auto-generated method stub
    }

}
*/
