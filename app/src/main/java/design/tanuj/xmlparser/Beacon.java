package design.tanuj.xmlparser;

/**
 * Created by Tanuj Saraf on 6/11/2017.
 */

public class Beacon {

    private String Name;
    private String IP;

    public String getName(){
        return Name;
    }

    public void setName(String Name){
        this.Name=Name;
    }

    public String getIP(){
        return IP;
    }

    public void setIP(String IP){
        this.IP=IP;
    }


    @Override

    public String toString(){
        return " IP = "+IP+"\n Name = "+Name;
    }

}
