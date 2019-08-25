package com.ralphy.application;

import com.ralphy.controller.ConcurrentServer;

import com.ralphy.logtail.Tailer;
import com.ralphy.library.HttpHook;
import java.io.IOException;

public class Streamer
{
    public static void main(String rg[]) throws IOException
    {
        String filepath = "/Users/log/development.log";

        ConcurrentServer server = new ConcurrentServer(9000);

        Thread serverThread = new Thread(server);
        serverThread.start();

        Thread thread = new Thread(new Tailer(filepath, new HttpHook(server)));
        thread.start();
    }

}
