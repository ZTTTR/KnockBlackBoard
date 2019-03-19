package com.watchingy.websocket;


import com.alibaba.fastjson.JSON;
import com.watchingy.model.Chatter;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/webSocket/onClass/{classId}")
public class OnClassWebSocket {

    private static int onlineCount = 0;
    private static ConcurrentHashMap<Integer, Set> onClassWebSockets = new ConcurrentHashMap<>();
    private Session session;

    @OnOpen
    public void onOpen(Session session,@PathParam("classId") int classId) {
        this.session = session;

        if(!onClassWebSockets.containsKey(classId)){
            Set<OnClassWebSocket> set = Collections.newSetFromMap(new ConcurrentHashMap<OnClassWebSocket, Boolean>());
            onClassWebSockets.put(classId, set);
        }

        Set<OnClassWebSocket> set = onClassWebSockets.get(classId);  //加入set中
        set.add(this);
        //addOnlineCount();           //在线数加1
        //System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
    }

    @OnClose
    public void onClose(@PathParam("classId") int classId) {
        Set set = onClassWebSockets.get(classId);
        set.remove(this); //从set中删除
        //subOnlineCount();           //在线数减1
        //System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }


    @OnMessage
    public void onMessage(String getChatter, Session session, @PathParam("classId") int classId) {
        System.out.println("来自客户端的消息:" + getChatter);
        Chatter chatter = JSON.parseObject(getChatter, Chatter.class);

        //群发消息
        Set<OnClassWebSocket> set = onClassWebSockets.get(classId);
        for(OnClassWebSocket obj : set){
            try {
                obj.sendMessage(getChatter);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }

        /*
        for (ConcurrentHashMap.Entry<OnClassWebSocket,Integer> item : onClassWebSockets.entrySet()) {
            try {
                if (item.getValue().equals(chatter.getClassId()))
                    item.getKey().sendMessage(getChatter);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
        */
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }


    public void sendMessage(String message) throws IOException {
        //this.session.getBasicRemote().sendText(message);
        this.session.getAsyncRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        OnClassWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        OnClassWebSocket.onlineCount--;
    }
}
