//MainActivity
package com.example.budgetenvy;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

//import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import android.content.Intent;

//import com.example.budgetenvy.Envelope;
//import com.example.budgetenvy.EnvelopeEditActivity;

public class MainActivity extends Activity {
    //Create an array list to store envelopes
    public static ArrayList<Envelope> envelopeList = new ArrayList<Envelope>();

    //Create an array list to store buttons
    public static ArrayList<Button> btnList = new ArrayList<Button>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
        //Load envelopeList
        try{
            FileInputStream fIn = new FileInputStream("envelope.txt");
            ObjectInputStream obIn = new ObjectInputStream(fIn);
            envelopeList = (ArrayList<Envelope>)obIn.readObject();
            System.out.println("Loading Envelopes");
            obIn.close();
        }
        catch(IOException f){
            System.out.println(f.getMessage());
        }
        catch(ClassNotFoundException c){
            System.out.println(c.getMessage());
        }

        // Load btnList
        try{
            FileInputStream fIn = new FileInputStream("btn.txt");
            ObjectInputStream obIn = new ObjectInputStream(fIn);
            btnList = (ArrayList<Button>)obIn.readObject();
            System.out.println("Loading Buttons");
            obIn.close();
        }
        catch(IOException f){
            System.out.println(f.getMessage());
        }
        catch(ClassNotFoundException c){
            System.out.println(c.getMessage());
        }
        */

        //Display Buttons
        int i;
        for (i = 0; i < btnList.size(); i++) {
            //btnList.get(i)(MainActivity.this);
            //Button btnEnvelope = btnList.get(i);
            //btnEnvelope(MainActivity.this);
            Button btnEnvelope = new Button(MainActivity.this);
            btnEnvelope = btnList.get(i);
        }

        //Set up onClickListener for btnAddEnvelope
        Button btnAddEnvelope = (Button) findViewById(R.id.btnAddEnvelope);
        btnAddEnvelope.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Create a new button
                Button btnEnvelope = new Button(MainActivity.this);
                btnEnvelope.setText("New Envelope");

                //Add button to btnList
                btnList.add(btnEnvelope);

                //Create an envelope and add it to envelopeList
                envelopeList.add(new Envelope());

                //Set up onClickListener for new button
                btnEnvelope.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View button) {
                        //Create Intent for EnvelopeEditActivity
                        Intent editEnvelopeIntent = new Intent(MainActivity.this, EnvelopeEditActivity.class);

                        //Bundle Envelope Data
                        int btnIndex = btnList.indexOf(button);

                        Bundle envelopeData = new Bundle();
                        envelopeData.putInt("envelopeIndex", btnIndex);
                        editEnvelopeIntent.putExtras(envelopeData);

                        //Start activity for result
                        startActivityForResult(editEnvelopeIntent, 1);
                    }
                });

                //Declare envelopePanel and button parameters
                LinearLayout ll = (LinearLayout) findViewById(R.id.envelopePanel);
                LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

                //Add button to view
                ll.addView(btnEnvelope, lp);
            }
        });

        //Set up onClickListener for btnSaveBudget
        Button btnSaveBudget = (Button) findViewById(R.id.btnSaveBudget);
        btnSaveBudget.setOnClickListener(new View.OnClickListener() {
            public void onClick(View button) {
                //Save envelopeList to file
                try {
                    FileOutputStream fos = new FileOutputStream("envelope.txt");
                    ObjectOutputStream os = new ObjectOutputStream(fos);
                    os.writeObject(envelopeList);
                    os.close();
                } catch (IOException f) {
                    System.out.println(f.getMessage());
                }

                //Save btnList to file
                try {
                    FileOutputStream fos = new FileOutputStream("btn.txt");
                    ObjectOutputStream os = new ObjectOutputStream(fos);
                    os.writeObject(btnList);
                    os.close();
                } catch (IOException f) {
                    System.out.println(f.getMessage());
                }
            }
        });
    }

    //Manage returned data from envelopeEditActivity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            System.out.println("Stuff happens");
            //Get data from Envelope data
            int envelopeIndex = data.getIntExtra("envelopeIndex", 0);
            Envelope envelope = envelopeList.get(envelopeIndex);

            String envelopeName = envelope.getName();
            int envelopeBudget = envelope.getBudget();
            int envelopeBalance = envelope.getBalance();

            //Set button text
            Button button = btnList.get(envelopeIndex);
            button.setText(envelopeName + "\n" + envelopeBalance + "/" + envelopeBudget);
        }
        if (resultCode == RESULT_CANCELED) {
            System.out.println("Canceled");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
