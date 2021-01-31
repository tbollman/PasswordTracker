import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManager {
    private final File accountsFile = new File("accounts.txt");
    public List<Account> accounts;
    public String username;

    public AccountManager() {
        username = "";
        accounts = new ArrayList<>();
    }
    public boolean checkFirstTime() {
        boolean firstTime = true;
        try {
            Scanner fileReader = new Scanner(accountsFile);
            if(fileReader.hasNextLine()) {
                String[] temp = fileReader.nextLine().split(" ");
                username = temp[0];
                accounts.add(new Account(temp[0],temp[1]));
                firstTime = false;
            }
        }
        catch(FileNotFoundException e) {
            try {
                accountsFile.createNewFile();
                System.out.println("File Created!");
            }
            catch(IOException g) {
                g.printStackTrace();
            }
        }
        return firstTime;
    }
    public void readAccounts() {
        try {
            Scanner fileReader = new Scanner(accountsFile);
            while (fileReader.hasNextLine()) {
                String[] first = fileReader.nextLine().split(" ");
                accounts.add(new Account(first[0], first[1]));
            }
            fileReader.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeAccounts() {
        try {
            FileWriter fileWriter = new FileWriter(accountsFile);
            for(Account a : accounts) {
                fileWriter.write(a.getAccount() + " " + a.getPassword() + "\n");
            }
            fileWriter.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() { return this.username; }
    public void setUsername(String un) { this.username = un; }
}
