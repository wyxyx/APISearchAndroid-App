package com.mobile_computing;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context) {
        super(context, "FavoriteDatabase", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //type is "TEXT"
        String query = "CREATE TABLE "+"Favorites"+"("+"BookID"+" TEXT)";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void addBook(String BookID)
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = "INSERT INTO Favorites(BookID) VALUES("+BookID+");";//String.format("INSERT INTO Favorites(BookID) VALUES('%s');",BookID);
        db.execSQL(query);
    }
    public void deleteBook(String BookID)
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = "DELETE FROM Favorites WHERE BookID="+BookID+";";//String.format("DELETE FROM Favorites WHERE BookID='%s';",BookID);
        db.execSQL(query);
    }
    public boolean isFavorite(String BookID)
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM Favorites WHERE BookID="+BookID+";";//String.format("SELECT * FROM Favorites WHERE BookID='%s';",BookID);
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.getCount()<=0)
        {
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }
}
