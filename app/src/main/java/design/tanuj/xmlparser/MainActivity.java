package design.tanuj.xmlparser;


import android.os.Bundle;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    ListView listView = (ListView) findViewById(R.id.listView1);

    List<Beacon> BeaconList = null;


     try {
        XmlParserHandler parser = new XmlParserHandler();
        InputStream is=getAssets().open("BeaconList.xml");
        BeaconList = parser.parse(is);

        ArrayAdapter<Beacon> adapter =new ArrayAdapter<Beacon>
                (this,android.R.layout.simple_list_item_1, BeaconList);
        listView.setAdapter(adapter);

    } catch (IOException e) {e.printStackTrace();}

}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

}



