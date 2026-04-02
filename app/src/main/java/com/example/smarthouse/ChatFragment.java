package com.example.smarthouse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

public class ChatFragment extends Fragment {

    private LinearLayout chatContainer;
    private EditText messageInput;
    private Button sendButton;
    private NestedScrollView scrollView;
    private ChatBotHelper chatBot;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // ИСПОЛЬЗУЕМ fragment_chat.xml
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        // Если у вас файл называется fragment_3.xml, то используйте R.layout.fragment_3

        chatContainer = view.findViewById(R.id.chat_container);
        messageInput = view.findViewById(R.id.message_input);
        sendButton = view.findViewById(R.id.send_button);
        scrollView = view.findViewById(R.id.scroll_view);

        chatBot = new ChatBotHelper();
        addBotMessage("Привет! Меня зовут Ростик.\n" +
                "Я твой виртуальный помощник.");

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        return view;
    }

    private void sendMessage() {
        String userMessage = messageInput.getText().toString().trim();
        if (!userMessage.isEmpty()) {
            addUserMessage(userMessage);
            messageInput.setText("");
            String botResponse = chatBot.getResponse(userMessage);
            addBotMessage(botResponse);
        }
    }

    private void addUserMessage(String message) {
        View messageView = getLayoutInflater().inflate(R.layout.message_user, chatContainer, false);
        TextView messageText = messageView.findViewById(R.id.message_text);
        messageText.setText(message);
        chatContainer.addView(messageView);
        scrollToBottom();
    }

    private void addBotMessage(String message) {
        View messageView = getLayoutInflater().inflate(R.layout.message_bot, chatContainer, false);
        TextView messageText = messageView.findViewById(R.id.message_text);
        messageText.setText(message);
        chatContainer.addView(messageView);
        scrollToBottom();
    }

    private void scrollToBottom() {
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}