package BotGroup;

import BotGroup.Enum.SendMessageType;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface SendMessageService {

    void sendMessage(Message message,String text);

    void sendMessage(SendMessageType messageType, Message message, Boolean oneMoreUser) throws TelegramApiException;
}
