package BotGroup;

import org.telegram.telegrambots.meta.api.methods.GetUserProfilePhotos;
import org.telegram.telegrambots.meta.api.methods.groupadministration.KickChatMember;
import org.telegram.telegrambots.meta.api.methods.groupadministration.RestrictChatMember;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.UserProfilePhotos;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramGatewayMock implements TelegramGateway {

    public Message sendMessage(SendMessage sendMessage) {

        Message message = new Message();
        return message;
    }

    public UserProfilePhotos getUserProfilePhotos(GetUserProfilePhotos getUserProfilePhotos) {

        UserProfilePhotos userProfilePhotos = new UserProfilePhotos();

        return userProfilePhotos;
    }

    public void restrictChatMember(RestrictChatMember restrictChatMember) {

    }

    public void kickChatMember(KickChatMember kickChatMember) throws TelegramApiException {

    }
}
