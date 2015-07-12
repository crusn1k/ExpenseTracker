package in.nishikant_patil.expensetracker.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

import in.nishikant_patil.expensetracker.R;
import in.nishikant_patil.expensetracker.adapter.MessageAdapter;
import in.nishikant_patil.expensetracker.model.Message;
import in.nishikant_patil.expensetracker.enums.MessageType;
import in.nishikant_patil.expensetracker.service.MessageProvider;


public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    private void init() {
        ListView messageListView = (ListView)findViewById(R.id.messageList);
        MessageProvider provider = new MessageProvider(getContentResolver());
        List<Message> messageList = provider.getMessages(MessageType.RECEIVED);
        MessageAdapter messageAdapter = new MessageAdapter(this, messageList);
        messageListView.setAdapter(messageAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
