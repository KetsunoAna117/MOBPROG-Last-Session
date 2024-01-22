package id.ac.binus.session12;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import id.ac.binus.session12.model.Mahasiswa;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, "mahasiswa", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table person (" +
                "nim string primary key," +
                "nama string," +
                "email string," +
                "phone string," +
                "alamat string)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Boolean isInsertedDataPerson(String nim, String nama, String email, String phone, String alamat){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues content = new ContentValues();
        content.put("nim", nim);
        content.put("nama", nama);
        content.put("email", email);
        content.put("phone", phone);
        content.put("alamat", alamat);

        long hasil = db.insert("person", null, content);
        if(hasil == -1){
            return false;
        }
        return true;
    }

    public Boolean isDeletedDataPerson(Mahasiswa person){
        SQLiteDatabase db = getWritableDatabase();
        int result = db.delete("person", "nim=? AND nama=? AND email=? AND phone=? AND alamat=?",
                new String[]{person.getNim(), person.getName(), person.getEmail(), person.getPhone(), person.getAlamat()});
        return result > 0;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM person", null);
        return cursor;
    }
}
