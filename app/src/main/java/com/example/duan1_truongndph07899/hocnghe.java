package com.example.duan1_truongndph07899;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.HashMap;

public class hocnghe extends Activity implements TextToSpeech.OnInitListener {
    ImageView giupdo,menuchinh;
    Button docvanban;
    private int MY_DATA_CHECK_CODE = 0;
    private TextToSpeech tts;
    private EditText inputText;
    private Button speakButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hocnghe);

        giupdo=(ImageView)findViewById(R.id.hinhgiupdo);
        menuchinh=(ImageView)findViewById(R.id.hinhbackmenu);
        docvanban=(Button)findViewById(R.id.buttondoc);
        inputText = (EditText) findViewById(R.id.noidungvanban);
        speakButton = (Button) findViewById(R.id.buttondoc);


        speakButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text = inputText.getText().toString();
                if (text!=null && text.length()>0) {
                    Toast.makeText(hocnghe.this, "Saying: " + text, Toast.LENGTH_LONG).show();
                    tts.speak(text, TextToSpeech.QUEUE_ADD, null);
                }
            }
        });

        Intent checkIntent = new Intent();
        checkIntent.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(checkIntent, MY_DATA_CHECK_CODE);


        menuchinh.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                finish();
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });


    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                // success, create the TTS instance
                tts = new TextToSpeech(this, this);
            }
            else {
                // missing data, install it
                Intent installIntent = new Intent();
                installIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installIntent);
            }
        }

    }

    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            Toast.makeText(hocnghe.this,
                    "Text-To-Speech engine is initialized", Toast.LENGTH_LONG).show();
        }
        else if (status == TextToSpeech.ERROR) {
            Toast.makeText(hocnghe.this,
                    "Error occurred while initializing Text-To-Speech engine", Toast.LENGTH_LONG).show();
        }
    }


}
