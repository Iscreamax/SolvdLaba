package inerfaces;

import iphone.Client;
import iphone.Message;

public interface ISendMessage {
    void sendMessage(Message message, Client firstClient, Client secondClient) throws Exception;

}
