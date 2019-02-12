package BotGroup;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.*;

import java.util.List;

public class JavaBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {


    }

    public void onUpdatesReceived(List<Update> updates) {

        if(updates!=null) {

            MessageHandler.getInstance(this).onUpdatesReceived(updates);
        }

    }

    public String getBotUsername() {
        return "java4ever_bot";
    }

    public String getBotToken() {
        return "701446887:AAEjxoWWv3Go0wtTQoGOZJ7jeWqeaYfUZA0";
    }
}
