package br.com.mvc.desafio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "POSTS";

    // Table columns
    public static final String USERID = "_userid";

    private Context context;
    public static final String _ID = "_id";
    public static final String TITLE = "title";
    public static final String  TEXT = "text";

    // Database Information
    static final String DB_NAME = "Posts.db";

    // database version
    static final int DB_VERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "("
            + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + USERID + " INTEGER, "
            + TITLE + " TEXT, "
            + TEXT + " TEXT);";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addRetrofitResponse(String userId, String title, String text) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(USERID, "userId");
        cv.put(TEXT, "text");
        cv.put(TITLE, "title");

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1 ){
            Toast.makeText(context, "Failed", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "Success", Toast.LENGTH_LONG).show();
        }
    }
}
