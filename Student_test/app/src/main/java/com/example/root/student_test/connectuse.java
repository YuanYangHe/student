package com.example.root.student_test;

import android.app.Application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class connectuse extends Application {
    private Socket soc;
    private BufferedReader brt;
    private BufferedWriter bwt;
    public  void init()
    {
        try {
            this.soc = new Socket("192.168.100.2",509);
            brt=new BufferedReader(new InputStreamReader(soc.getInputStream(), "UTF-8"));
            bwt = new BufferedWriter(new OutputStreamWriter(soc.getOutputStream(), "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Socket getSocket() {
        return soc;
    }

    public BufferedWriter getwrite()
    {
        return bwt;
    }

    public BufferedReader getread()
    {
        return brt;
    }



}