package com.vdb.javagb.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.vdb.javagb.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HallActivity extends AppCompatActivity {
    private String pathRom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall);

        ImageButton imageButtonDebug = (ImageButton)findViewById(R.id.imageButtonDebug);
        imageButtonDebug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HallActivity.this, DebuggerActivity.class);
                intent.putExtra("pathRom", pathRom);
                startActivity(intent);
            }
        });

        ImageButton imageButtonFile = (ImageButton)findViewById(R.id.imageButtonFile);
        imageButtonFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("text/plain");
                intent.addCategory(Intent.CATEGORY_OPENABLE);

                // special intent for Samsung file manager
                Intent sIntent = new Intent("com.sec.android.app.myfiles.PICK_DATA");
                // if you want any file type, you can skip next line
                sIntent.putExtra("CONTENT_TYPE", "*/*");
                sIntent.addCategory(Intent.CATEGORY_DEFAULT);

                Intent chooserIntent;
                if (getPackageManager().resolveActivity(sIntent, 0) != null){
                    // it is device with samsung file manager
                    chooserIntent = Intent.createChooser(sIntent, "Open file");
                    chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] { intent});
                }
                else {
                    chooserIntent = Intent.createChooser(intent, "Open file");
                }

                try {
                    startActivityForResult(chooserIntent, 22);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "No suitable File Manager was found.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null || requestCode != 22)return;
        Uri uri = data.getData();

        pathRom = data.getDataString();

        TextView textViewFile = (TextView)findViewById(R.id.textViewFile);
        textViewFile.setText(pathRom);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
