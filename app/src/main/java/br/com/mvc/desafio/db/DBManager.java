package br.com.mvc.desafio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    private DBHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
//        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String id, String userId, String text, String title) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DBHelper.USERID, id);
        contentValue.put(DBHelper._ID, userId);
        contentValue.put(DBHelper.TEXT, text);
        contentValue.put(DBHelper.TITLE, title);
        database.insert(DBHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DBHelper._ID, DBHelper.USERID, DBHelper._ID, DBHelper.TITLE, DBHelper.TEXT };
        Cursor cursor = database.query(DBHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(String id, String userId, String text, String title ) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.USERID, userId);
        contentValues.put(DBHelper.TEXT, text);
        contentValues.put(DBHelper.TITLE, title);
        int i = database.update(DBHelper.TABLE_NAME, contentValues, DBHelper._ID + " = " + id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DBHelper.TABLE_NAME, DBHelper._ID + "=" + _id, null);
    }

}