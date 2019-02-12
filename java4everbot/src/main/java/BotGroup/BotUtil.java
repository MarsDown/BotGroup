package BotGroup;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.GetUserProfilePhotos;
import org.telegram.telegrambots.meta.api.methods.groupadministration.KickChatMember;
import org.telegram.telegrambots.meta.api.methods.groupadministration.RestrictChatMember;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.UserProfilePhotos;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import BotGroup.Enum.ActionType;

public class BotUtil {

    public static ActionType getActionTypeUser(Message message){

        if(message==null)
            return ActionType.UNKNOWN;

        if(message.getNewChatMembers()!=null)
            return ActionType.JOIN;

        if(message.getLeftChatMember()!=null)
            return ActionType.LEFT;

        return ActionType.UNKNOWN;
    }

    public static boolean userHasPhoto(UserProfilePhotos userProfilePhotos) throws TelegramApiException {

        if(userProfilePhotos!=null && userProfilePhotos.getTotalCount()!=0)
            return true;

        return false;
    }

    public static GetUserProfilePhotos getUserProfilePhotosInstance(User user){
        GetUserProfilePhotos getUserProfilePhotosRequest = new GetUserProfilePhotos();
        getUserProfilePhotosRequest.setUserId(user.getId());
        getUserProfilePhotosRequest.setOffset(1);
        getUserProfilePhotosRequest.setLimit(1);

        return getUserProfilePhotosRequest;
    }


    public static KickChatMember getKickChatMemberInstance(Chat chat,User user,Integer untilDate){
        KickChatMember kickChatMember = new KickChatMember();
        kickChatMember.setChatId(chat.getId());
        kickChatMember.setUserId(user.getId());

        if(untilDate!=null)
            kickChatMember.setUntilDate(untilDate);

        return kickChatMember;
    }

    public static RestrictChatMember getRestrictChatMemberInstance(Chat chat,User user,Integer untilDate) {

        RestrictChatMember request = new RestrictChatMember();

        request.setCanAddWebPagePreviews(false);
        request.setCanSendMediaMessages(false);
        request.setCanSendMessages(false);
        request.setCanSendOtherMessages(false);
        request.setChatId(chat.getId());
        request.setUserId(user.getId());

        if(untilDate!=null)
            request.setUntilDate(untilDate);

        return request;

    }

    public static SendMessage getSendMessageRequestInstance(Message message,String text)
    {
        SendMessage sendMessageRequest = new SendMessage();
        sendMessageRequest.setReplyToMessageId(message.getMessageId());
        sendMessageRequest.setChatId(message.getChatId());
        sendMessageRequest.setText(text);

        return sendMessageRequest;
    }



}
