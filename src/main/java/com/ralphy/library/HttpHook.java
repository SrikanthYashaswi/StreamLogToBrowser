package com.ralphy.library;

import com.ralphy.controller.ConcurrentServer;
import com.ralphy.logtail.Hook;

import java.io.IOException;

public class HttpHook implements Hook {

    final ConcurrentServer server;

    public HttpHook(ConcurrentServer server)
    {
        this.server = server;
    }

    @Override
    public void send(String line) {
        try{
            server.stream(line);
        }
        catch(IOException c)
        {
            c.printStackTrace();
        }
    }
}
