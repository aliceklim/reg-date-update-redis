import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
public class RedisTest {

    private static final int SLEEP = 1;
    private static final SimpleDateFormat DF = new SimpleDateFormat("HH:mm:ss");
    private static ArrayList<User> users;

    private void updateRegDate(){
        int user_id = new Random().nextInt(20);
        for (int i = 0; i < 20; i++){
            User user = users.get(i);
            if (user.getUserId() == user_id){
                user.setRegistrationDate(new Date());
            }
        }
    }

    private static void log(int displayedUser) {
        String log = String.format("[%s] На главной странице показываем пользователя: %d", DF.format(new Date()), displayedUser);
        System.out.println(log);
    }

    public static void main(String[] args) throws InterruptedException {
        RedisStorage redis = new RedisStorage();
        redis.init();
        for (int i = 0; i < 20; i++){
            User user = new User(i, new Date());
            users.add(user);
            redis.logUserRegistration(user.getUserId(), user.getRegistrationDate());
        }
        for(;;) {
            Thread.sleep(SLEEP);
            for ( int i = 0; i < 20; i ++){
                log(i);
            }
        }
    }
}


