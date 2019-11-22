package com.example.duan1_truongndph07899;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class playvideo extends Activity {
    VideoView vv;
    ImageView giupdo,menuchinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playvideo);

        vv=(VideoView)findViewById(R.id.videoView1);
        giupdo=(ImageView)findViewById(R.id.hinhgiupdo);
        menuchinh=(ImageView)findViewById(R.id.hinhbackmenu);



        vv.setMediaController(new MediaController(this));

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video4);
        vv.setVideoURI(video);

        menuchinh.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                Intent i=new Intent(getApplicationContext(),xemvideo.class);
                startActivity(i);

            }
        });
    }


}
