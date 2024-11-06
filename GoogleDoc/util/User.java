package designGoogleDoc.util;

public class User {
         public int userId;
         public String userName;
        public int getUserId() {
            return userId;
        }
        public String getUsername() {
            return userName;
        }
        public void setUserId(int userId) {
            this.userId = userId;
        }
        public void setUserName(String userName) {
            this.userName = userName;
        }
        public User(String userName) {
            this.userName = userName;
        }
}
