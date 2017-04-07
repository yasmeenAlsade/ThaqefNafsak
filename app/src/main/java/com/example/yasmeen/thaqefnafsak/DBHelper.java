package com.example.yasmeen.thaqefnafsak;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;


public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE = "my_db" ;
    private static final String TABLE = "Data" ;
    private static final String Info = "information" ;
    private static final String TABLE2 = "Data2" ;
    private static final String Questions = "questions" ;
    private static final String Answers ="answers" ;
    private static final String Right = "right";




    public DBHelper(Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {




        db.execSQL("create table if not exists "+TABLE+" (id integer primary key, "+Info+" text)");

        db.execSQL("insert into " + TABLE + "(information) values ('أطول سورة في القرآن الكريم هي سورة البقرة.');");
        db.execSQL("insert into " + TABLE + "(information) values ('أفضل وسيلة لتفسير القرآن الكريم هي تفسير القرآن بالقرآن.');");
        db.execSQL("insert into " + TABLE + "(information) values ('تقع مدينة الأبيض في السودان.');");
        db.execSQL("insert into " + TABLE + "(information) values ('أوسط أبواب الجنة هو الوالدين.');");
        db.execSQL("insert into " + TABLE + "(information) values ('ابتكرت لعبة تنس الطاولة في الهند.');");
        db.execSQL("insert into " + TABLE + "(information) values ('أول من جمع القرآن هو الإمام علي ابن أبي طالب.');");
        db.execSQL("insert into " + TABLE + "(information) values ('عطر العنبر يستخرج من أحشاء الحوت.');");
        db.execSQL("insert into " + TABLE + "(information) values ('الصحابي الذي اهتز لموته عرش الرحمن هو سعد ابن معاذ.');");
        db.execSQL("insert into " + TABLE + "(information) values ('تبلغ المسافة بين الأرض والشمس 150 مليون كم.');");
        db.execSQL("insert into " + TABLE + "(information) values ('سورة الملائكة هو اسم آخر لسورة فاطر.');");


        db.execSQL("create table if not exists "+TABLE2+" (id integer primary key, "+Questions+" text, " +Answers+" text, "+Right+" text)");




        db.execSQL("insert into " + TABLE2+ "(questions,answers,right) values ('ما هي أطول سورة في القرآن الكريم؟', 'الناس البقرة الكوثر مريم', 'البقرة');");
        db.execSQL("insert into " + TABLE2+ "(questions,answers,right) values ('ما هي أفضل وسيلة لتفسير القرآن الكريم؟', 'الأحاديث السنة القرآن الأقوال', 'القرآن');");
        db.execSQL("insert into " + TABLE2+ "(questions,answers,right) values ('أين تقع مدينة الأبيض', 'تونس السودان الجزائر موريتانيا', 'السودان');");
        db.execSQL("insert into " + TABLE2+ "(questions,answers,right) values ('ما هو أوسط أبواب الجنة؟', 'الوالدين الأبناء الأحفاد الأخوة', 'الوالدين');");
        db.execSQL("insert into " + TABLE2+ "(questions,answers,right) values ('أين ابتكرت لعبة تنس الطاولة؟', 'لندن روما الهند موسكو', 'الهند');");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<Data2> getAllData2(){
        SQLiteDatabase db = this.getReadableDatabase() ;
        ArrayList<Data2> arrayList = new ArrayList<>() ;

        try{
            Cursor cursor = db.rawQuery("select * from " + TABLE2, null) ;
            cursor.moveToFirst() ;

            while(cursor.isAfterLast()==false)
            {
                Data2 d = new Data2();
                d.setId(cursor.getInt(cursor.getColumnIndex("id"))) ;
                d.setQuestions(cursor.getString(cursor.getColumnIndex("questions")));
                d.setAnswers(cursor.getString(cursor.getColumnIndex("answers")));
                d.setRight(cursor.getString(cursor.getColumnIndex("right")));
                arrayList.add(d) ;
                cursor.moveToNext() ;
            }

            return arrayList ;

        }catch (Exception e)
        {
            return null ;
        }

    }

    public ArrayList<Data> getAllData(){
        SQLiteDatabase db = this.getReadableDatabase() ;
        ArrayList<Data> arrayList = new ArrayList<Data>() ;

        try{
            Cursor cursor = db.rawQuery("select * from " + TABLE, null) ;
            cursor.moveToFirst() ;

            while(cursor.isAfterLast()==false)
            {
                Data d = new Data();
                d.setId(cursor.getInt(cursor.getColumnIndex("id"))) ;
                d.setInfo(cursor.getString(cursor.getColumnIndex("information")));
                arrayList.add(d) ;
                cursor.moveToNext() ;
            }

            return arrayList ;

        }catch (Exception e)
        {
            return null ;
        }

    }

    public boolean insertContact(Data data){
        SQLiteDatabase db = this.getWritableDatabase() ;
        ContentValues contentValues = new ContentValues() ;
        try{
            contentValues.put(Info , data.getInfo());
            db.insert(TABLE , null ,contentValues) ;
            return true ;
        }catch(Exception ex)
        {
            return false ;
        }
    }
}
