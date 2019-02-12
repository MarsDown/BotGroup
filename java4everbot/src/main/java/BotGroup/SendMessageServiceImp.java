package BotGroup;

import BotGroup.Enum.SendMessageType;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class SendMessageServiceImp implements SendMessageService {

    private TelegramGateway telegramGateway;

    public SendMessageServiceImp(TelegramLongPollingBot bot){
        telegramGateway = TelegramGatewayFactory.getTelegramGateway(bot);
    }

    private void sendMessage(SendMessage sendMessage) throws TelegramApiException {
        Message message = telegramGateway.sendMessage(sendMessage);
    }

    public void sendMessage(Message message, String text) {

    }

    public void sendMessage(SendMessageType messageType, Message message, Boolean oneMoreUser) throws TelegramApiException {

        String messageText = "";
        if(SendMessageType.WELCOME_MESSAGE.equals(messageType))
            messageText = PersianMessage.getWelcomeMessageToGroup(message.getChat().getTitle(),oneMoreUser);

        if(SendMessageType.RESTRICT_MESSAGE.equals(messageType))
            messageText = PersianMessage.getWarningMessage();

        SendMessage sendMessageRequestInstance = BotUtil.getSendMessageRequestInstance(message, messageText);

        sendMessage(sendMessageRequestInstance);

    }
}
