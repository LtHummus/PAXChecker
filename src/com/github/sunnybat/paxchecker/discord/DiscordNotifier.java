package com.github.sunnybat.paxchecker.discord;


import com.github.sunnybat.paxchecker.browser.Browser;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class DiscordNotifier {

    private final URL webhook;


    public DiscordNotifier(String webhookUrl) throws Exception {
        webhook = new URL(webhookUrl);

        //read the webhook data just to make sure this URL actually exists
        HttpURLConnection conn = Browser.setUpConnection(webhook);
        if (conn.getResponseCode() != 200) {
            throw new Exception("Could not read webhook stuff");
        }
    }

    public void postNotification(String message) throws Exception {
        JSONObject obj = new JSONObject();
        obj.put("content", message);
        String contentsToPost = obj.toJSONString();

        HttpURLConnection conn = Browser.setUpConnection(webhook);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);

        try (OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream())) {
            osw.write(contentsToPost);
            osw.flush();
        }

        int responseCode = conn.getResponseCode();

        if (responseCode != 200 && responseCode != 204) {
            throw new Exception("Error when posting to discord");
        }

        System.out.println("Sent message to discord");
    }
}
