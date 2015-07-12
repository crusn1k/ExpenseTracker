package in.nishikant_patil.expensetracker.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.nishikant_patil.expensetracker.R;
import in.nishikant_patil.expensetracker.model.Message;

/**
 * Created by Nishikant on 7/12/2015.
 */
public class MessageAdapter extends BaseAdapter {

    private List<Message> messages;
    private Activity activity;

    public MessageAdapter(Activity activity, List<Message> messages){
        this.activity = activity;
        this.setMessages(messages);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        if(null==messages){
            messages = new ArrayList<>();
        } else{
            this.messages = messages;
        }
    }


    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        if(messages.size() > (position)) {
            return messages.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(null==convertView){
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }
        TextView id = (TextView) convertView.findViewById(R.id.id);
        TextView address = (TextView) convertView.findViewById(R.id.address);
        TextView content = (TextView) convertView.findViewById(R.id.content);

        Message message = (Message)this.getItem(position);
        id.setText(message.getId());
        address.setText(message.getAddress());
        content.setText(message.getContent());

        return convertView;
    }
}
