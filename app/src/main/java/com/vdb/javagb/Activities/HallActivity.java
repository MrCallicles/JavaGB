package com.vdb.javagb.Activities;

import android.Manifest;
import android.app.Activity;

import android.content.Context;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;

import android.os.Build;
import android.os.Environment;
import android.os.Bundle;

import android.provider.DocumentsContract;
import android.provider.OpenableColumns;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

import android.util.Log;

import android.view.Menu;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.vdb.javagb.R;

import java.io.File;

public class HallActivity extends AppCompatActivity {
    private String pathRom;
    private String filename;
    private TextView txtViewHall;
    private static final int READ_REQUEST_CODE = 42;
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 21;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall);

        Toolbar appToolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(appToolbar);
        getSupportActionBar().setTitle("JavaGB");

        txtViewHall = findViewById(R.id.textViewScreen);

        //showData();

        String path = Environment.getExternalStorageDirectory().toString();

        ImageButton imageButtonDebug = (ImageButton)findViewById(R.id.imageButtonDebug);
        imageButtonDebug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (pathRom.isEmpty())return;
                Intent intent = new Intent(HallActivity.this, DebuggerActivity.class);
                intent.putExtra("pathRom", pathRom);
                startActivity(intent);
            }
        });

        Button imageButtonFile = (Button)findViewById(R.id.imageButtonFile);
        imageButtonFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent resultData) {

        if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {

            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();
                String mimeType = getContentResolver().getType(uri);

                Cursor returnCursor = getContentResolver().query(uri, null, null, null, null);
                int nameIndex = returnCursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                int sizeIndex = returnCursor.getColumnIndex(OpenableColumns.SIZE);
                returnCursor.moveToFirst();
                filename = returnCursor.getString(nameIndex);
                filename = filename.replace('(', '"');
                filename = filename.replace(')', '"');
                filename = filename.replace(".gb", "");
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];


                if ("primary".equalsIgnoreCase(type)) {
                    pathRom = Environment.getExternalStorageDirectory() + "/" + split[1];
                }
                String size = Long.toString(returnCursor.getLong(sizeIndex));

                Log.i("Uri", "Uri: " + uri.toString());
                //pathRom = resultData.getDataString();
                File f = new File(pathRom);

                txtViewHall.setText(getString(R.string.text_screen));
                txtViewHall.setText(txtViewHall.getText()+"\n\n\n"+filename);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tool_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_map) {
            popupWindow();
        }

        return super.onOptionsItemSelected(item);
    }

    public void performFileSearch() {

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        intent.setType("application/octet-stream");

        try {
            startActivityForResult(intent, READ_REQUEST_CODE);
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getApplicationContext(), "No suitable File Manager was found.", Toast.LENGTH_SHORT).show();
        }
    }

    private void checkPermission(){
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(this, "Permission missing",
                    Toast.LENGTH_SHORT)
                    .show();
            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                Snackbar.make(txtViewHall, "Accès requis",
                        Snackbar.LENGTH_INDEFINITE).setAction("ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Request the permission
                        ActivityCompat.requestPermissions(HallActivity.this,
                                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                    }
                }).show();
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);

                // MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            Toast.makeText(this, "Permission granted",
                    Toast.LENGTH_SHORT)
                    .show();
            performFileSearch();
        }
    }

    private void popupWindow(){
        final LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.popup_maps, null);
        final PopupWindow popupWindow = new PopupWindow(linearLayout, LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT, true);

        if(Build.VERSION.SDK_INT>=21){
            popupWindow.setAnimationStyle(R.style.AnimationPopup);
            popupWindow.setElevation(5.0f);
        }

        final EditText editTextLatitude = linearLayout.findViewById(R.id.edtLatitude);
        final EditText editTextLongitude = linearLayout.findViewById(R.id.edtLongitude);

        ImageButton buttonLocate = (ImageButton) linearLayout.findViewById(R.id.imageButtonLocate);
        buttonLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HallActivity.this, MapsActivity.class);
                intent.putExtra("latitude", Integer.parseInt(editTextLatitude.getText().toString()));
                intent.putExtra("longitude", Integer.parseInt(editTextLongitude.getText().toString()));
                popupWindow.dismiss();
                startActivity(intent);
            }
        });

        popupWindow.showAtLocation(findViewById(R.id.app_toolbar), Gravity.CENTER,0,0);
    }

    protected int dp2px(int dp, Context context){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
