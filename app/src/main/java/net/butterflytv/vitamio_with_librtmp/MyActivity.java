package net.butterflytv.vitamio_with_librtmp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import io.vov.vitamio.widget.VideoView;


public class MyActivity extends Activity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my);

        if (!io.vov.vitamio.LibsChecker.checkVitamioLibs(this))
            return;

        videoView = (VideoView) findViewById(R.id.vitamio_player);

        // you may need to add " live=1" at the end of uri if it is live in red5 server
        videoView.setVideoPath("rtmp://54.194.98.151/ButterFly_Red5/1416128155176.flv");

        // also try -> rtmp://31.204.128.140/live/brlive_0028
        // buffering may take some time
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
