package Room;

import java.io.Serializable;

/**
 * Created by MdRafid on 11/30/2015.
 */
public class Person implements Serializable {
    private String name;
    private String gender;
    private int personPresentX;
    private int personPresentY;
    private int destinationX;
    private int detinationY;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPersonPresentX() {
        return personPresentX;
    }

    public void setPersonPresentX(int personPresentX) {
        this.personPresentX = personPresentX;
    }

    public int getPersonPresentY() {
        return personPresentY;
    }

    public void setPersonPresentY(int personPresentY) {
        this.personPresentY = personPresentY;
    }

    public int getDestinationX() {
        return destinationX;
    }

    public void setDestinationX(int destinationX) {
        this.destinationX = destinationX;
    }

    public int getDetinationY() {
        return detinationY;
    }

    public void setDetinationY(int detinationY) {
        this.detinationY = detinationY;
    }
}
