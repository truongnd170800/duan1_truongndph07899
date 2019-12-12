package com.example.duan1_truongndph07899.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.duan1_truongndph07899.R;

import java.util.Locale;

public class hocnghe extends Activity implements TextToSpeech.OnInitListener {
    ImageView giupdo,menuchinh;

    private int MY_DATA_CHECK_CODE = 0;
    private TextToSpeech tts;
    private EditText ptext;
    private Button b;

//hs
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hocnghe);

        giupdo=(ImageView)findViewById(R.id.hinhgiupdo);
        menuchinh=(ImageView)findViewById(R.id.hinhbackmenu);


        ptext = (EditText) findViewById(R.id.noidungvanban);
        b = (Button) findViewById(R.id.buttondoc);
        tts = new TextToSpeech(this, this);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts.speak(ptext.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });


//        b.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                String text = text.getText().toString();
//                if (text!=null && text.length()>0) {
//                    Toast.makeText(hocnghe.this, "Saying: " + text, Toast.LENGTH_LONG).show();
//                    tts.speak(text, TextToSpeech.QUEUE_ADD, null);
//                }
//            }
//        });

//        Intent checkIntent = new Intent();
//        checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
//        startActivityForResult(checkIntent, MY_DATA_CHECK_CODE);


        menuchinh.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                finish();
                Intent i=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });


    }


//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == MY_DATA_CHECK_CODE) {
//            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
//                // success, create the TTS instance
//                tts = new TextToSpeech(this, this);
//            }
//            else {
//                // missing data, install it
//                Intent installIntent = new Intent();
//                installIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
//                startActivity(installIntent);
//            }
//        }
//
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onDestroy(){
        if (tts != null){
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    public void onInit(int status) {
        if (status != TextToSpeech.ERROR){
                tts.setLanguage(Locale.US);
    }

    }


}
