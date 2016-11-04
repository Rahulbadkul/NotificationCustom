package karman.com.notificationcustom;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
//        Button b1 = (Button) findViewById (R.id.button1);
//        b1.setOnClickListener (new View.OnClickListener () {
//            @Override
//            public void onClick (View v) {
//                startService (v);
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater ().inflate (R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        int id = item.getItemId ();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected (item);
    }

    public void startService (View v) {
        Log.d ("hello", "karman");
        Intent serviceIntent = new Intent (MainActivity.this, NotificationService.class);
        serviceIntent.setAction (Constants.ACTION.STARTFOREGROUND_ACTION);
        startService (serviceIntent);

    }
}
