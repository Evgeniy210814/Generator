package Generator;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Evgeniy
 */
public class GetRequest {
    public int status;
    public String responseCodeLog;
    public String sendGetClick(String url,String ip,String agent) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        if(!agent.isEmpty()){
            con.setRequestProperty("User-Agent", agent);
            
        }
        if(!ip.isEmpty()){
            con.setRequestProperty("X-Forwarded-For", ip);
        }
        if(!agent.isEmpty()&&!ip.isEmpty()){
            con.setRequestProperty("User-Agent", agent);
            con.setRequestProperty("X-Forwarded-For", ip);
        }
        status = con.getResponseCode();
        //System.out.println("\nSending 'GET' request to URL : " + url);
        //System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        String[] subStr = response.toString().split("\""); // Разделения строки str с помощью метода split()
        // Вывод результата на экран
        //System.out.println(subStr[3]);
        //System.out.println(response.toString());
        responseCodeLog=response.toString();
        System.out.println(subStr[3]);
        return subStr[3];
        

    }
    public String sendGetConversion(String click_id) throws Exception {
        sleep(1500);
        URL obj = new URL(click_id);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");



        int responseCode = con.getResponseCode();
        //System.out.println("\nSending 'GET' request to URL : " + url);
        //System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        responseCodeLog=response.toString();
        //System.out.println(response.toString());
        return response.toString();

    }
    public void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//    public static void main(String[] args) throws Exception {
//        //GetRequest request = new GetRequest();
//        //request.sendGetClick("https://staging.g2afse.com/click?pid=2&offer_id=1&format=json");
//        //request.sendGetConversion("https://offers-staging.affise.com/postback?clickid="+request.sendGetClick("https://staging.g2afse.com/click?pid=2&offer_id=1&format=json"));
//
//
//    }
    
}
