import java.util.Date;

public class User {
    private int userId;
    private Date registrationDate;

    public User(int id, Date regDate){
        this.userId = id;
        this.registrationDate = regDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }



}

