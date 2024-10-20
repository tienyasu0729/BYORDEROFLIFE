public class UserAuth {
    private String username;
    private String password;
    private boolean status;

    public UserAuth(String username, String password, boolean status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public boolean checkLogin(String username, String password) {
        if (this.status && this.username.equals(username) && this.password.equals(password)) {
            return true;
        }
        return false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
