package in.nishikant_patil.expensetracker.service;

import android.content.ContentResolver;
import android.database.Cursor;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

import in.nishikant_patil.expensetracker.constants.MessageCursorConstants;
import in.nishikant_patil.expensetracker.model.Message;
import in.nishikant_patil.expensetracker.model.MessageType;
import in.nishikant_patil.expensetracker.processor.ExpenseProcessor;

/**
 * Created by Nishikant on 7/12/2015.
 */
public class MessageProvider {

    private static final String[] SMS_FIELDS = new String[]{"_id", "thread_id", "address", "person", "date",
                                                            "protocol", "read", "status", "type", "reply_path_present",
                                                            "subject", "body", "service_center", "locked"};

    private Cursor messageCursor;
    private ContentResolver contentResolver;

    public MessageProvider(ContentResolver contentResolver){
        this.contentResolver = contentResolver;
    }

    public List<Message> getMessages(MessageType messageType){
        List<Message> messages = new ArrayList<>();
        try {
            this.getMessagesFromSMSProvider(messageType).hydrateMessageList(messages);
        } finally {
            if(null!=messageCursor && !messageCursor.isClosed()){
                messageCursor.close();
            }
        }
        return messages;
    }

    private MessageProvider getMessagesFromSMSProvider(MessageType messageType){
        Uri messageUri = Uri.parse("content://sms/" + messageType.getName());
        messageCursor = contentResolver.query(messageUri, SMS_FIELDS, null, null, null);
        return this;
    }

    private MessageProvider hydrateMessageList(List<Message> messages){
        while(messageCursor.moveToNext()){
            Message message = new Message();
            message.setId(messageCursor.getString(MessageCursorConstants.ID));
            message.setAddress(messageCursor.getString(MessageCursorConstants.ADDRESS));
            message.setContent(messageCursor.getString(MessageCursorConstants.BODY));
            if(ExpenseProcessor.process(message)) {
                messages.add(message);
            }
        }
        return this;
    }
}
