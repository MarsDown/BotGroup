package BotGroup;

import BotGroup.Enum.UserType;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetUserProfilePhotos;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.UserProfilePhotos;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class UserServiceImpl implements UserService {

    private TelegramGateway telegramGateway;

    public UserServiceImpl(TelegramLongPollingBot bot){
        this.telegramGateway = TelegramGatewayFactory.getTelegramGateway(bot);
    }

    public UserProfilePhotos getUserProfilePhotos(User user) throws TelegramApiException {

        GetUserProfilePhotos profilePhotos = BotUtil.getUserProfilePhotosInstance(user);
        return telegramGateway.getUserProfilePhotos(profilePhotos);
    }

    public UserType getUserType(User user) throws TelegramApiException {

        if(user.getBot())
           return UserType.BOT;

        if(user.getUserName() == null && !BotUtil.userHasPhoto(getUserProfilePhotos(user))){
           return UserType.SPAMER;
        }

        return UserType.NORMAL;

    }
}
