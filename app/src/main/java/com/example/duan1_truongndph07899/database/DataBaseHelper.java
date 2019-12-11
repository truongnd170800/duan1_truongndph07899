package com.example.duan1_truongndph07899.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static String DB_PATH = "";
    private static String DB_NAME = "msqllite.db";
    private String TAG = "TAG";
    private SQLiteDatabase myDataBase;
    private final Context myContext;


    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
        if (Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/database/";
        } else {
            DB_PATH = "/data/data" + context.getPackageName() + "/database/";
        }
        this.myContext = context;

    }

    public void checkAndCopyDatabase(){
        boolean dbExist = checkDataBase();
        if(dbExist){
            Log.d(TAG, "database already exist!");
        }else{
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                Log.d(TAG,"Error copying database");
            }
        }
    }
    private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;
        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        }catch(SQLiteException e){
        }
        if(checkDB != null) checkDB.close();
        return checkDB != null ? true : false;
    }
    private void copyDataBase() throws IOException{
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void createDataBase(){
        boolean mDataBaseExist = checkDataBases();
        if (!mDataBaseExist){
            this.getReadableDatabase();
            this.close();
            try {
                copyDataBases();
                Log.e("TAG","createDataBase database created");
            } catch (IOException e) {
                return;
//                throw new Error("ErrorCopyingDataBase");
            }
        }
    }
    private SQLiteDatabase mDataBase;

    public boolean openDataBase(int i)throws SQLException{
        String mPath = DB_PATH + DB_NAME;

        mDataBase = SQLiteDatabase.openDatabase(mPath,null,SQLiteDatabase.OPEN_READONLY);
        return mDataBase != null;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }
    //kiem tra database neu ton tai thi thong bao database san dang su dung
    //neu khong thi copy database vao duong dan "DB_PATH+DB_NAME"
    private boolean checkDataBases(){
        File dbfile = new File(DB_PATH +DB_NAME);
        return dbfile.exists();
    }

    private void copyDataBases() throws IOException{
        InputStream mInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_NAME +DB_PATH;
        OutputStream mOutPut = new FileOutputStream(outFileName);
        byte [] mBuffer = new byte[1042];
        int mLength;
        while ((mLength = mInput.read(mBuffer))>0){
            mOutPut.write(mBuffer, 0, mLength);
        }
        mOutPut.flush();
        mOutPut.close();
        mInput.close();
    }
    public void openDataBase() throws SQLException{
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    public void ExeSQLData(String sql) throws SQLException{
        myDataBase.execSQL(sql);
    }

    public Cursor QueryData(String query) throws SQLException{
        return myDataBase.rawQuery(query, null);
    }
//    public void getAll(){
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        String SQL =
//    }
}