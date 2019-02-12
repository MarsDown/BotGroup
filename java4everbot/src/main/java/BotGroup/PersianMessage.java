package BotGroup;

public class PersianMessage {


    public static String getWelcomeMessageToGroup(String groupName,Boolean oneMoreUser)
    {
        StringBuilder message = new StringBuilder();

        if(oneMoreUser)
            message.append("سلام دوستان عزیز");
        else
            message.append("سلام دوست عزیز");

                message.append("\n")
                .append("به گروه "+groupName+" خوش امدید")
                .append("\n")
                .append("صفحه پروفایل گروه:")
                .append("\uD83D\uDC47ویکی گروه\uD83D\uDC47")
                .append("این پیام صرفا جنبه خوش آمد گویی دارد و جهت جلوگیری از اسپم به زودی حذف خواهد شد");

        return message.toString();
    }

    public static String getWarningMessage(){
        return "شما محدود شدین چون پروفایلتون مشکوک است. در صورت ربات نبودن به یکی از ادمین ها پیام بدین!";
    }

}

