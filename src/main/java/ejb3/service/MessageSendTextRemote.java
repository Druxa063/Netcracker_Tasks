package ejb3.service;

import javax.ejb.Remote;

@Remote
public interface MessageSendTextRemote {

    void send(String text);
}
