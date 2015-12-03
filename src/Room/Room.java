package Room;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by MdRafid on 11/30/2015.
 */
public class Room implements Serializable {
    private ArrayList<Person>clientList = new ArrayList<>();
    private String roomName;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    private Person getClientFromList(int i)
    {
        return clientList.get(i);
    }

    private void setClientInList(Person client, int index)
    {
        clientList.add(index,client);

    }

    private int getClientIndex(Person client)
    {
        return clientList.indexOf(client);
    }
}
