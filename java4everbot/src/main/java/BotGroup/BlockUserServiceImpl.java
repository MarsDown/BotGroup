package BotGroup;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.groupadministration.KickChatMember;
import org.telegram.telegrambots.meta.api.methods.groupadministration.RestrictChatMember;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BlockUserServiceImpl implements BlockUserService {

    private TelegramGateway telegramGateway;

    public BlockUserServiceImpl(TelegramLongPollingBot bot){
       telegramGateway = TelegramGatewayFactory.getTelegramGateway(bot);
    }

    public void kickUser(Chat chat, User user, Integer untilDate) throws TelegramApiException {


        KickChatMember kickChatMember = BotUtil.getKickChatMemberInstance(chat, user,untilDate);
        telegramGateway.kickChatMember(kickChatMember);


    }

    public void restrictUser(Chat chat, User user, Integer untilDate) throws TelegramApiException {
        RestrictChatMember restrictChatMember = BotUtil.getRestrictChatMemberInstance(chat, user,untilDate);
        telegramGateway.restrictChatMember(restrictChatMember);
    }
}
