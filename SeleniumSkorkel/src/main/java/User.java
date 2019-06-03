public class User {

    private String UserName;
    private String Password;

    public User(String UserName, String Password) {

        this.UserName = UserName;
        this.Password = Password;

    }

    /**
     * @return the UserName
     */
    public String getUserName() {
        return UserName;
    }

    /**
     * @param UserName the UserName to set
     */
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "User [UserName=" + UserName
                + ", Password=" + Password + "]";
    }
}





