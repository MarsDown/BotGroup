package BotGroup;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetUserProfilePhotos;
import org.telegram.telegrambots.meta.api.methods.groupadministration.KickChatMember;
import org.telegram.telegrambots.meta.api.methods.groupadministration.RestrictChatMember;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.UserProfilePhotos;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramGatewayImpl implements TelegramGateway {

    private TelegramLongPollingBot bot;

    public TelegramGatewayImpl(TelegramLongPollingBot bot){
        this.bot = bot;
    }

    public Message sendMessage(SendMessage sendMessage) throws TelegramApiException {
       return bot.execute(sendMessage);
    }

    public UserProfilePhotos getUserProfilePhotos(GetUserProfilePhotos getUserProfilePhotos) throws TelegramApiException {
        return bot.execute(getUserProfilePhotos);
    }

    public void restrictChatMember(RestrictChatMember restrictChatMember) throws TelegramApiException {
        Boolean execute = bot.execute(restrictChatMember);

    }

    public void kickChatMember(KickChatMember kickChatMember) throws TelegramApiException {
        Boolean execute = bot.execute(kickChatMember);
    }
}
