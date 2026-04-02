package com.example.smarthouse;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ChatBotHelper {

    private Map<String, String[]> responseMap;
    private Random random;

    public ChatBotHelper() {
        random = new Random();
        initializeResponses();
    }

    private void initializeResponses() {
        responseMap = new HashMap<>();

        responseMap.put("привет", new String[]{
                "Здравствуй! Как я могу помочь?",
                "Привет! Чем могу быть полезен?",
                "Добрый день! Рад тебя видеть!"
        });

        responseMap.put("как дела", new String[]{
                "У меня всё отлично! А у тебя?",
                "Замечательно! Спасибо, что спросил(а)!",
                "Хорошо! Чем могу помочь?"
        });

        responseMap.put("кто ты", new String[]{
                "Я умный помощник в приложении РосТеремок!",
                "Я бот-помощник, созданный чтобы помогать тебе!"
        });

        responseMap.put("спасибо", new String[]{
                "Пожалуйста! Всегда рад помочь!",
                "Обращайся! Буду рад помочь снова!"
        });

        responseMap.put("ростикс", new String[]{
                "Я Ростик!",
                "Нет."
        });

        responseMap.put("кто ты", new String[]{
                "Я умный помощник в приложении Ростеремок!",
                "Я бот-помощник, созданный чтобы помогать тебе!"
        });
    }

    public String getResponse(String userMessage) {
        if (userMessage == null || userMessage.trim().isEmpty()) {
            return "Напиши что-нибудь, и я обязательно отвечу!";
        }

        String message = userMessage.toLowerCase().trim();

        for (Map.Entry<String, String[]> entry : responseMap.entrySet()) {
            if (message.contains(entry.getKey())) {
                String[] responses = entry.getValue();
                int index = random.nextInt(responses.length);
                return responses[index];
            }
        }

        return "Интересный вопрос! Я еще учусь, но обязательно найду ответ!";
    }
}