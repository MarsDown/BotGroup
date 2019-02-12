package BotGroup;

import BotGroup.Enum.UserType;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.UserProfilePhotos;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface UserService {


    public UserProfilePhotos getUserProfilePhotos(User user) throws TelegramApiException;
    public UserType getUserType(User user) throws TelegramApiException;


}
