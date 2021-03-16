package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText mInputNote;
    private Button mBtnSaveNote;
    private SharedPreferences myNoteSharedPref;
    private static String NOTE_TEXT = "note_text";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initViews();
        getDateFromSharedPref();
    }
    private void init(){
        mInputNote = findViewById(R.id.input_note);
        mBtnSaveNote = findViewById(R.id.btn_save_note);
    }
    private void initViews() {

        myNoteSharedPref = getSharedPreferences(String.valueOf(R.string.name), MODE_PRIVATE);
        mBtnSaveNote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences.Editor myEditor = myNoteSharedPref.edit();
                    String noteTxt = mInputNote.getText().toString();
                    myEditor.putString(NOTE_TEXT, noteTxt);
                    myEditor.apply();
                    Toast.makeText(MainActivity.this,R.string.saved_info , Toast.LENGTH_LONG).show();
                }
            });
    }
    private void getDateFromSharedPref(){
        String noteTxt = myNoteSharedPref.getString(NOTE_TEXT, "");
        mInputNote.setText(noteTxt);
    }
}