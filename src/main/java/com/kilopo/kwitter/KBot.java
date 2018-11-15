package com.kilopo.kwitter;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;

public class KBot extends TelegramLongPollingBot {
    private static final String BOT_NAME = "yahz_bot";
    private static final String BOT_TOKEN = "659773170:AAG-H37w4EhaLIAqVpskAQgSky7R7MhUZyI";
    private String newMessageText;

    @Override
    public void onUpdateReceived(Update update) {
        hzShoDelat(update);
    }

    private void hzShoDelat(Update update) {
        String[] separators = {" ", ".", "/", ",", "|", "_"};
        String[] lastChars = {"і", "у", "ю", "ї"};
        String text = update.getMessage().getText();
        String lastChar = text.substring(text.length() - 1);

        if (Arrays.stream(separators).noneMatch(text::contains)
                && Arrays.stream(lastChars).anyMatch(lastChar::contains)
        ) {
            newMessageText = text + " пезда, я не знаю шо дєлать.";
            sendMessage(newMessageText, update);
        }
    }


    private void sendMessage(String text, Update update) {
        SendMessage message = new SendMessage();

        message.setChatId(update.getMessage().getChatId());
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return BOT_NAME;
    }

    public String getBotToken() {
        return BOT_TOKEN;
    }
}
