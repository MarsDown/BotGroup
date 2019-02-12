package BotGroup;

import org.telegram.telegrambots.meta.api.methods.GetUserProfilePhotos;
import org.telegram.telegrambots.meta.api.methods.groupadministration.KickChatMember;
import org.telegram.telegrambots.meta.api.methods.groupadministration.RestrictChatMember;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.UserProfilePhotos;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface TelegramGateway {

    public Message sendMessage(SendMessage sendMessage) throws TelegramApiException;

    public UserProfilePhotos getUserProfilePhotos(GetUserProfilePhotos getUserProfilePhotos) throws TelegramApiException;

    public void restrictChatMember(RestrictChatMember restrictChatMember) throws TelegramApiException;

    public void kickChatMember(KickChatMember kickChatMember) throws TelegramApiException;
}
