package sell.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author totalo
 * 非Service
 * 非controller
 */
@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {

    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSockets.add(this);
        log.info("新的连接{}",webSockets.size());
    }
    @OnClose
    public void onClose(){
        webSockets.remove(this);
    }
    @OnMessage
    public void onMessage(String message){
        log.info("消息{}",message);
    }

    public void setMessage(String message){
        for (WebSocket webSocket : webSockets){
            log.info("发送消息{}",message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (IOException e) {

            }
        }
    }
}
