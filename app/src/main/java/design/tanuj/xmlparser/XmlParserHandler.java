package design.tanuj.xmlparser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 * Created by Tanuj Saraf on 6/11/2017.
 */

public class XmlParserHandler {


    private List<Beacon> BeaconList= new ArrayList<Beacon>();
    private Beacon beacon;
    private String text;

    public List<Beacon> getBeacons() {
        return BeaconList;
    }

    public List<Beacon> parse(InputStream is) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser  parser = factory.newPullParser();

            parser.setInput(is, null);

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("beacon")) {
                            // create a new instance of Host
                            beacon = new Beacon();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase("beacon")) {
                            // add Host object to list
                            BeaconList.add(beacon);
                        }else if (tagname.equalsIgnoreCase("name")) {
                            beacon.setName(text);
                        }  else if (tagname.equalsIgnoreCase("ip")) {
                            beacon.setName(text);
                        }

                        break;

                    default:

                        break;
                }
                eventType = parser.next();
            }

        } catch (XmlPullParserException e) {e.printStackTrace();}
        catch (IOException e) {e.printStackTrace();}

        return BeaconList;

}
    }
