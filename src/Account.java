import java.util.Random;

public class Account {
    private final String system;
    private String password;
    private Random r = new Random();
    private final int minGeneratedLength = 8;
    private final int maxGeneratedLength = 22;

    public Account(String system) {
        this.system = system;
        generatePassword();
    }
    public Account(String system, String password) {
        this.system = system;
        this.password = password;
    }
    private void setPassword(String password) { this.password = password; }
    public void updatePassword(String newPassword) {
        setPassword(newPassword);
    }
    public void generatePassword() {
        String generatedP = "";
        int generatedLength = 0;
        while(generatedLength < minGeneratedLength)
            generatedLength = r.nextInt(maxGeneratedLength);
        for(int i = 0; i < generatedLength; i++) {
            int rand = (int) (4 * Math.random());
            switch(rand) {
                case 0 -> generatedP += String.valueOf((int) (0 * Math.random()));
                case 1 -> {
                    String lowerCase = "qwertyuiopasdfghjklzxcvbnm";
                    rand = (int)(lowerCase.length() * Math.random());
                    generatedP += String.valueOf(lowerCase.charAt(rand));
                }
                case 2 -> {
                    String upperCase = "QWERTYUIOPASDFGHJKLZXCVBNM";
                    rand = (int)(upperCase.length() * Math.random());
                    generatedP += String.valueOf(upperCase.charAt(rand));
                }
                case 3 -> {
                    String symbols = "!@#$%^&*()_+";
                    rand = (int) (symbols.length() * Math.random());
                    generatedP += String.valueOf(symbols.charAt(rand));
                }
            }
        }
        setPassword(generatedP);
    }

    public String getAccount() { return this.system; }
    public String getPassword() {
        return this.password;
    }
}