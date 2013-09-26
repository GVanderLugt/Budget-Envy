package com.example.budgetenvy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "envelopesDB";

    //Envelopes table name
    private static final String TABLE_ENVELOPES = "envelopes";

    //Envelopes Table Columns Names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_BUDGET = "budget";
    private static final String KEY_BALANCE = "balance";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ENVELOPES_TABLE = "CREATE TABLE " + TABLE_ENVELOPES + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT," + KEY_BUDGET + " TEXT,"
                + KEY_BALANCE + " TEXT" + ")";
        db.execSQL(CREATE_ENVELOPES_TABLE);
    }

    //Upgrading Database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ENVELOPES);

        //Create tables again
        onCreate(db);
    }

    //Adding new envelope
    public void addEnvelope(Envelope envelope) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, envelope.getName()); //Envelope Name
        values.put(KEY_BUDGET, envelope.getBudget()); //Envelope Budget
        values.put(KEY_BALANCE, envelope.getBalance()); //Envelope Balance

        //Inserting Row
        db.insert(TABLE_ENVELOPES, null, values);
        db.close(); //Closing database connection
    }

    //Getting single envelope
    public Envelope getEnvelope(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_ENVELOPES, new String[]{KEY_ID,
                KEY_NAME, KEY_BUDGET, KEY_BALANCE}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Envelope envelope = new Envelope(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Integer.parseInt(cursor.getString(2)),
                Integer.parseInt(cursor.getString(3)));

        //Return Envelope
        return envelope;
    }

    //Getting All Envelopes
    public List<Envelope> getAllEnvelopes() {
        List<Envelope> envelopeList = new ArrayList<Envelope>();

        //Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ENVELOPES;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //Loop through all rows and add to list
        if (cursor.moveToFirst()) {
            do {
                Envelope envelope = new Envelope();
                envelope.setID(Integer.parseInt(cursor.getString(0)));
                envelope.setName(cursor.getString(1));
                envelope.setBudget(Integer.parseInt(cursor.getString(2)));
                envelope.setBalance(Integer.parseInt(cursor.getString(3)));

                //Add envelope to list
                envelopeList.add(envelope);
            }
            while (cursor.moveToNext());
        }
        //Return Envelope List
        return envelopeList;
    }

    //Getting envelopes count
    public int getEnvelopeCount() {
        String countQuery = "SELECT  * FROM " + TABLE_ENVELOPES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        //Return Count
        return cursor.getCount();
    }

    //Updating single Envelope
    public int updateEnvelope(Envelope envelope) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, envelope.getName());
        values.put(KEY_BUDGET, envelope.getBudget());
        values.put(KEY_BALANCE, envelope.getBalance());

        //Updating Row
        return db.update(TABLE_ENVELOPES, values, KEY_ID + " = ?",
                new String[]{String.valueOf(envelope.getID())});
    }

    //Deleting single envelope
    public void deleteEnvelope(Envelope envelope) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_ENVELOPES, KEY_ID + " = ?",
                new String[]{String.valueOf(envelope.getID())});
        db.close();
    }

}
