public class Login {
    private String username;
    private String password;

    public Login(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    // Getter
    public String getUsername() { return username; }

    // Setter
    public void setUsername(String username) {
        if (username != null && !username.trim().isEmpty()) {
            this.username = username;
        } else {
            System.out.println("Username tidak boleh kosong.");
            this.username = "-";
        }
    }

    public void setPassword(String password) {
        if (password != null && !password.trim().isEmpty()) {
            this.password = password;
        } else {
            System.out.println("Password tidak boleh kosong.");
            this.password = "-";
        }
    }

    public boolean login() {
        return username.equals("mayday") && password.equals("mayday123");
    }
}