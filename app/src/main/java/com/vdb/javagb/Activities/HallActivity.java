package com.vdb.javagb.Activities;

import android.Manifest;
import android.app.Activity;
import android.app.SearchManager;

import android.content.Context;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;

import android.os.Environment;
import android.os.Bundle;

import android.provider.DocumentsContract;
import android.provider.OpenableColumns;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.SearchView;
import android.support.v7.widget.Toolbar;

import android.util.Log;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.vdb.javagb.R;

import java.io.File;
import java.net.URI;

import Entity.Instruction;
import Entity.OpCode;
import Entity.Operator;

public class HallActivity extends AppCompatActivity {
    private String pathRom;
    private String filename;
    private ManageGBDB gbdb;
    private TextView txtViewHall;
    private static final int READ_REQUEST_CODE = 42;
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 21;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall);

        Toolbar appToolbar = (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(appToolbar);
        getSupportActionBar().setTitle("JavaGB");

        gbdb = new ManageGBDB(this);
        txtViewHall = (TextView)findViewById(R.id.textViewScreen);

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
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tool_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    private void showData(){
        gbdb.open();
        for (OpCode opCode : gbdb.getDataOpCode().getAll()){
            Log.i("OpCode", opCode.getRow());
        }

        for (Instruction instruction : gbdb.getDataInstruction().getAll()){
            Log.i("Instruction", instruction.getRow());
        }

        for (Operator operator : gbdb.getDataOperator().getAll()){
            Log.i("Operator", operator.getRow());
        }
        gbdb.close();
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
        // Here, thisActivity is the current activity
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
}
