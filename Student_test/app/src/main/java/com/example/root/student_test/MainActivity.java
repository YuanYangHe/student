package com.example.root.student_test;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
    connectthread abcc;
    public Socket soc;
    public BufferedReader brt;
    public BufferedWriter bwt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        abcc = new connectthread();
        abcc.start();

    }
    class connectthread extends Thread
    {
        connectuse connect = (connectuse)MainActivity.this.getApplication();
        @Override
        public void run() {
            try {
                connect.init();
                soc = connect.getSocket();
                brt = connect.getread();
                bwt = connect.getwrite();
                bwt.write("wxyz");
                bwt.write("test2");
                bwt.write("test_student");


            }catch (IOException e){

            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
