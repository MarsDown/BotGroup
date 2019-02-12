package BotGroup;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface BlockUserService {

    public void kickUser(Chat chat, User user,Integer untilDate) throws TelegramApiException;
    public void restrictUser(Chat chat, User user,Integer untilDate) throws TelegramApiException;

}
