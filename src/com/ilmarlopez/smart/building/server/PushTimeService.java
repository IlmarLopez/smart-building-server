package com.ilmarlopez.smart.building.server;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.websocket.Session;

/**
 *
 * @author developer
 */
public class PushTimeService implements Runnable {

    private static PushTimeService instance;
    private static Map<String, Session> sMap = new HashMap<String, Session>();
    
    private PushTimeService() {}
    
    public static void add(Session s) {
        sMap.put(s.getId(), s);
    }
    
    public static void initialize() {
        if (instance == null) {
            instance = new PushTimeService();
            new Thread(instance).start();
        }
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1*1000);
                
                for (String key : sMap.keySet()) {
                    Session s = sMap.get(key);
                    
                    if (s.isOpen()) {
                        Date d = new Date(System.currentTimeMillis());
                        s.getBasicRemote().sendText(d.toString());
                    } else {
                        sMap.remove(key);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

