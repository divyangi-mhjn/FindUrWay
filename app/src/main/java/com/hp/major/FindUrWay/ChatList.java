package com.hp.major.FindUrWay;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class ChatList extends ArrayAdapter<Chat> {
    private Activity context;
    List<Chat> chats;
    FirebaseUser user;
    String email1;
    int flag;
    TextView messageUser,messageTime,messageText;

    public ChatList(Activity context, List<Chat> chats) {
        super(context, R.layout.layout_chat_list, chats);
        this.context = context;
        this.chats = chats;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_chat_list, null, true);

        messageUser = (TextView) listViewItem.findViewById(R.id.message_user);
        messageTime = (TextView) listViewItem.findViewById(R.id.message_time);
        messageText = (TextView) listViewItem.findViewById(R.id.message_text);


        Chat chat = chats.get(position);
        user = FirebaseAuth.getInstance().getCurrentUser();
        email1 = user.getEmail();





            messageText.setText(chat.getMessageText());
        messageUser.setText(chat.getMessageUser());
        messageTime.setText(chat.getMessageTime());



            position++;



        return listViewItem;
    }
}
