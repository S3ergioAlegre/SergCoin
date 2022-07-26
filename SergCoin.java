//These imports are all of the the packages I need
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SergCoin{

      JFrame frame;       
      JPanel Login;
      JPanel Account;
      JPanel Text;
      JLabel usernamelb;
      JLabel passwordlb;
      JLabel AccountLabel;
      JLabel tx;
      JTextField tf2;
      JPasswordField tf3;
      JTextField tf4;
      JButton LoginButton;
      JButton CreateButton;
      JButton BackButton;
      JButton Withdrawl;
      JButton Deposit;
      JButton Check;
      int count = 1; 
      String txtfile;
      File file;
      FileWriter fw;
      BufferedWriter writer;
      ImageIcon img;
    

//These variables are going to be used when creating an account and the user's accounts
String username = "";
String password = "";
String firstname = "";
String lastname = "";
String gmail = "";
String total = "";



public void Menu() throws IOException{
  File[] files = new File("/Users/sergi/OneDrive/Documents/Accounts").listFiles();
    frame = new JFrame("SergCoin");   
    img = new ImageIcon("C:/Users/sergi/OneDrive/Pictures/Smile.jpeg");//This is where the icon comes from
    frame.setIconImage(img.getImage());
    Login = new JPanel();
    Account = new JPanel();
    Text = new JPanel();
    usernamelb = new JLabel("Enter username:");
    passwordlb = new JLabel("Enter Password: ");
    AccountLabel = new JLabel("Create Account: ");
    tx = new JLabel("Login or Create New Account");
    //This is how the label gets its font
    usernamelb.setFont(new Font("Arial", Font.BOLD, 14));
    passwordlb.setFont(new Font("Arial", Font.BOLD, 14));
    tx.setFont(new Font("Calibri", Font.BOLD, 18));
    tf2 = new JTextField(10);
    //makes the text look password protected
    tf3 = new JPasswordField(10);
    LoginButton = new JButton("Enter");
    CreateButton = new JButton("Create");
    //Basically when the top right corner of x is pressed, the window (GUI) is closed
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(580,210);
        //makes sure that the frame cant be changed
        frame.setResizable(false);
        tf3.setEchoChar('$');
    Login.add(usernamelb);
        Login.add(tf2);
        Login.add(passwordlb);
        Login.add(tf3);
        Login.add(LoginButton);
        Account.add(AccountLabel);
        Account.add(CreateButton);
        Text.add(tx);

        LoginButton.addActionListener(new ActionListener(){//This is the start of what the login button does
            public void actionPerformed(ActionEvent e){
        String name = tf2.getText();//This is where the user enters their username
        String pass = new String(tf3.getPassword());//This is where the user enters their password
        try{
        if(files.length<1){//Checks wether there are files inside the directory
            System.out.println(files.length);
            usernamelb.setText("Invalid name");
            passwordlb.setText("Invalid password");
        }
      }
      catch(Exception e1){//This catches the specific error and gives this message
        System.out.println("There are no files yet...");
      }

        for(int i = 0;i<files.length;i++){//If there are files in the directory then the proccess below runs
          
          try {
            ///The first and second line of the text file is the username and password
            String username = Files.readAllLines(Paths.get("/Users/sergi/OneDrive/Documents/Accounts/"+files[i].getName())).get(0);
            String password = Files.readAllLines(Paths.get("/Users/sergi/OneDrive/Documents/Accounts/"+files[i].getName())).get(1);
            if(!username.equals(name)){//it checks the first element first, which is the reason why it says invalid name even though its not
                usernamelb.setText("Invalid name");
            }
            else if(!password.equals(pass)){
                passwordlb.setText("Invalid password");
            }
            else if(username.equals(name) && password.equals(pass)){
              
                frame.setVisible(false);
                System.out.print("true");
                //If there is an account that uses the username and password the user entered then it sets the location
                //of the file(account) to variable below
               txtfile = "/Users/sergi/OneDrive/Documents/Accounts/"+files[i].getName();//+".txt"
                Account();
                
            }
          } catch (Exception e1) {
            e1.printStackTrace();
            

          }
            
        }
        
    
    }//this is bracket that is at the end of the button bracket
});

CreateButton.addActionListener(new ActionListener(){// The start of the Create Button
    public void actionPerformed(ActionEvent e){
frame.setVisible(false);
try {
  CreateAccount();//Once pressed the CreateAccount method runs
} catch (IOException e1) {
  e1.printStackTrace();
}

    }
});//End of the Create Button
   frame.getContentPane().add(BorderLayout.WEST,Login);
    frame.getContentPane().add(BorderLayout.SOUTH,Account);
    frame.getContentPane().add(BorderLayout.NORTH, Text);
    frame.setVisible(true);
}
//======================================================================
public  void CreateAccount() throws IOException{
  File[] files = new File("/Users/sergi/OneDrive/Documents/Accounts").listFiles();
    frame = new JFrame("Creating Account...");
    img = new ImageIcon("C:/Users/sergi/OneDrive/Pictures/Smile.jpeg");
    frame.setIconImage(img.getImage());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(590,210);
        frame.setResizable(false);
        JPanel Username = new JPanel();
        JPanel Password = new JPanel();
        JPanel Button = new JPanel();//This button panel contains the back and the create button
        BackButton = new JButton("MENU");
        JButton create = new JButton("Next");
        usernamelb = new JLabel("<html>Create Username:<br/></html>");
        passwordlb = new JLabel("Create password:");
        usernamelb.setFont(new Font("Arial", Font.BOLD, 14));
        passwordlb.setFont(new Font("Arial", Font.BOLD, 14));

        tf2 = new JTextField(10);
        tf4 = new JTextField(10);
        
        Button.add(BackButton);
        Button.add(create);
        
        Username.add(usernamelb);
        Username.add(tf2);
        Password.add(passwordlb);
        Password.add(tf4);


create.addActionListener(new ActionListener(){//This is the start of the create button
    public void actionPerformed(ActionEvent e){
       
//There are a total of 6 things the user must enter
//This is also the order of of how it is going to be displayed in the text file
/*
- username
- password
- first name
- last name
- gmail
- amount total
*/
//Need to make an counter variable, starts from 1 to 3
//The username and password will be its own pair,just like firstname and last name, and gmail and account total
String name = tf2.getText();
String pass =  tf4.getText();

try {
//----------------------------
if(getCounter()==1){
    
int count = 1;
for(int i =0;i<files.length;i++){
  
//Checks wether the username has already been used by a different account
    String line = Files.readAllLines(Paths.get("/Users/sergi/OneDrive/Documents/Accounts/"+files[i].getName())).get(0);
    if(line.equals(name) || name.length()<1){//In here use the method of getting the name from the specific line
      usernamelb.setText("Invalid Name");
      count = 0;
      break;
    }
   
  
}
    
if(count == 1){  
    if(pass.length()>0){
        Counter();


        username = name;
        password = pass;
        name = "";
        pass = "";

        System.out.println("Username made: "+username);
        System.out.println("Password made: "+password);


       
    }
    else{
        passwordlb.setText("Invalid Password");
    }
    }
}//---------------------


//Start of counter 2
if(getCounter()==2){//Users gets asked about names
System.out.println("This is getCounter 2 now...");

usernamelb.setText("Enter Firstname: ");
passwordlb.setText("Enter Lastname: ");
tf2.setText("");
tf4.setText("");

//checks wehter the user added anything at all
if(name.length()!=0 && pass.length()!=0){

firstname = name;
lastname = pass;
System.out.println("Firstname made: "+firstname);
System.out.println("Lastname made: "+lastname);
Counter();
name = "";
pass = "";
 }
}

//start of counter 3
if(getCounter()==3){
    frame.setTitle("Creating Account ( Total needs to be over 100 ) ");
  int count = 1;
    System.out.println("works2");
    usernamelb.setText("Enter Gmail: ");
passwordlb.setText("Enter Total: $");
tf2.setText("");
tf4.setText("");

if(name.length()!=0 || pass.length()!=0){
if(name.indexOf("@")==-1){
    usernamelb.setText("Invalid Gmail: ");
  count= 0;
}

try{
  int num = Integer.parseInt(pass);
  if(num<100){ //Integer.parseInt basically converts string to an int
    passwordlb.setText("Invalid Total: ");
    count = 0;
  }

}
//If the user doesnt enter a number, then the following message is displayed
catch(NumberFormatException e1){
  passwordlb.setText("Invalid Total: ");
  count = 0;
}



if(count==1){//Once everything is done the following below runs
gmail = name;
total = pass;
System.out.println(gmail);
System.out.println(total);
Counter();

name = "";
pass = "";
create.setVisible(false);
tf2.setVisible(false);
tf4.setVisible(false);
passwordlb.setVisible(false);
usernamelb.setText("Thanks For Signing Up!!!");
usernamelb.setFont(new Font("Calibri", Font.BOLD, 40));

}
 
}

}


if(getCounter()==4){

file = new File("/Users/sergi/OneDrive/Documents/Accounts/"+username+".txt");
//All the information that the user has entered is written into the new text file, that file is basically his account
  fw = new FileWriter(file);
writer = new BufferedWriter(fw);
writer.write(username);
writer.newLine();
writer.write(password);
writer.newLine();
writer.write(firstname);
writer.newLine();
writer.write(lastname);
writer.newLine();
writer.write(gmail);
writer.newLine();
writer.write(total);
writer.close();
username = "";
password = "";
firstname = "";
lastname = "";
gmail = "";
total = "";



tf2.setText("");


}

//The end of the length for loop
}
catch (IOException e1) {
  e1.printStackTrace();
  System.out.print("Problem With File (Might be empty)");

}
    }
     
});//End of the create button


  
BackButton.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        ResetCounter();
        username = "";
        password = "";
        firstname = "";
        lastname = "";
        gmail = "";
        total = "";
        frame.dispose();
        try {
          Menu();
        } catch (IOException e1) {
          e1.printStackTrace();
        }

    }
});

    frame.getContentPane().add(BorderLayout.NORTH,Username);
    frame.getContentPane().add(BorderLayout.CENTER, Password);
    frame.getContentPane().add(BorderLayout.SOUTH, Button);
    
    frame.setVisible(true);

}
//=============================================================

public void Account() throws IOException{

frame = new JFrame("Your Account");
img = new ImageIcon("C:/Users/sergi/OneDrive/Pictures/Smile.jpeg");
    frame.setIconImage(img.getImage());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(590,210);
        frame.setResizable(false);

      JPanel Buttons = new JPanel();
      Text = new JPanel();
      JPanel BackButton = new JPanel();
      
      tx = new JLabel("<html>Name:   "+Files.readAllLines(Paths.get(txtfile)).get(2)+" "+Files.readAllLines(Paths.get(txtfile)).get(3)+"<br/>Gmail:   "+Files.readAllLines(Paths.get(txtfile)).get(4)+"<br/><br/>Select Your Transaction</html>");
      tx.setFont(new Font("Verdana", Font.PLAIN, 13));

      Withdrawl = new JButton("Withdrawl");
      Deposit = new JButton("Deposit");
      Check = new JButton("Check Balance");
      JButton Enter = new JButton("Enter");//This button is for the user to enter the amount they want to take out or put in
      JButton menu = new JButton("Menu");
      JButton Back = new JButton("Back");

      tf2 = new JTextField(10);
      tf4 = new JTextField(10);

      Buttons.add(Withdrawl);
      Buttons.add(Deposit);
      Buttons.add(Check);
      BackButton.add(menu);
      BackButton.add(Back);
      Buttons.add(tf2);
      Buttons.add(Enter);
      Text.add(tx);
      Back.setVisible(false);
    Enter.setVisible(false);
    tf2.setVisible(false);
    //These variables access each line of the user text file (account), since each line represents certian information
    username = Files.readAllLines(Paths.get(txtfile)).get(0);
        password = Files.readAllLines(Paths.get(txtfile)).get(1);
        firstname = Files.readAllLines(Paths.get(txtfile)).get(2);
        lastname = Files.readAllLines(Paths.get(txtfile)).get(3);
        gmail = Files.readAllLines(Paths.get(txtfile)).get(4);
        total = Files.readAllLines(Paths.get(txtfile)).get(5);

//The withdrawl, deposit, back and check button basically displays their screens. Doesn't do much

Withdrawl.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
    setCounter(1);
    Back.setVisible(true);
    Enter.setVisible(true);

    Withdrawl.setVisible(false);
    Deposit.setVisible(false);
    Check.setVisible(false);
    tx.setFont(new Font("Calibri", Font.BOLD, 20));
    tx.setText("Enter The Amount To Be Taken Out");
    tf2.setVisible(true);
    
  System.out.print("Withdrawl works");
    }
});
Deposit.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
    setCounter(2);
    Back.setVisible(true);
    Enter.setVisible(true);

    Withdrawl.setVisible(false);
    Deposit.setVisible(false);
    Check.setVisible(false);
    tx.setFont(new Font("Calibri", Font.BOLD, 20));

    tx.setText("Enter Amount To Be Added");
    tf2.setVisible(true);
  System.out.print("Deposit works");
      
    }
});
Check.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
    Back.setVisible(true);
    
    Withdrawl.setVisible(false);
    Deposit.setVisible(false);
    Check.setVisible(false);

try {
  if(Integer.parseInt(total)<=0){
    tx.setFont(new Font("Calibri", Font.BOLD, 20));
      tx.setText("<html>You Are Broke or In Debt: $"+total+"</html>"); 
  }
        else{
        
      tx.setFont(new Font("Calibri", Font.BOLD, 20));
      tx.setText("<html><pre>Your balance is: $"+total+"</pre></html>");
      //The <br/> is just a way to make a new line in JLabel
    System.out.print("Check works");
          }
} catch (NumberFormatException e1) {
  System.out.println("SOMETHINGS Not working");

}
    }
});

  
Back.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        tf2.setVisible(false);
        tf2.setText("");
        Back.setVisible(false);
        Enter.setVisible(false);
        Withdrawl.setVisible(true);
        Deposit.setVisible(true);
        Check.setVisible(true);
        tx.setText("<html>Name:   "+firstname+" "+lastname+"<br/>Gmail:   "+gmail+"<br/><br/>Select Your Transaction</html>");
        tx.setFont(new Font("Verdana", Font.PLAIN, 13));
    }
});
  
menu.addActionListener(new ActionListener(){//Once pressed, then the Menu method runs again
    public void actionPerformed(ActionEvent e){
    frame.dispose();
  try {
    Menu();
  } catch (IOException e1) {
    e1.printStackTrace();
  }
    }
});

Enter.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        String val = tf2.getText();////This will be used to subtract from the total they have
        try {

          file = new File("/Users/sergi/OneDrive/Documents/Accounts/"+username+".txt");///
    fw = new FileWriter(file);
  writer = new BufferedWriter(fw);
        } catch (IOException e2) {
          System.out.print("There's a problem with the file ( might be empty ) ");
        }
        
        try{

        if(getCounter()==1){///This whole getCounter == 1 if statment is for the withdrawl

        if(Integer.parseInt(val)>Integer.parseInt(total) || Integer.parseInt(val) == Integer.parseInt(total)){
          total= ""+ ((long)(Integer.parseInt(total)) - Integer.parseInt(val));
  val = "";
  tf2.setText("");
tx.setText("<html>You Have Withdrawl</html>");
writer.write(username);
writer.newLine();
writer.write(password);
writer.newLine();
writer.write(firstname);
writer.newLine();
writer.write(lastname);
writer.newLine();
writer.write(gmail);
writer.newLine();
writer.write(total);
writer.close();
tx.setFont(new Font("Calibri", Font.BOLD, 18));
val = "";
tf2.setText("");
tf2.setVisible(false);
Enter.setVisible(false);
System.out.println("User has Withdraw");

 }
            else if(Integer.parseInt(val)<0){
                tx.setText("<html>The Amount Is Invalid</html>");
                val = "";
                tf2.setText("");
              }
            else if(Integer.parseInt(val)==0){
              tx.setText("<html>The Amount Is Invalid</html>");
                val = "";
                tf2.setText("");
            }
               
            else if(Integer.parseInt(val)<Integer.parseInt(total)){
              total= ""+ (Integer.parseInt(total) - Integer.parseInt(val));
              tx.setText("<html>You Have Withdrawl</html>");
              writer.write(username);
              writer.newLine();
              writer.write(password);
              writer.newLine();
              writer.write(firstname);
              writer.newLine();
              writer.write(lastname);
              writer.newLine();
              writer.write(gmail);
              writer.newLine();
              writer.write(total);
              writer.close();
            tx.setFont(new Font("Calibri", Font.BOLD, 18));
            val = "";
            tf2.setText("");
            tf2.setVisible(false);
            Enter.setVisible(false);
            System.out.println("User has Withdraw");
            
            }




        }//end of the getCounter ==1

        if(getCounter()==2){ // This getCounter == 2 if statement is for the deposit 

            if(Integer.parseInt(val)<0){
                tx.setText("<html>The Amount Is Invalid</html>");
                val = "";
                tf2.setText("");
            }

              else if(Integer.parseInt(val)==0){
                tx.setText("<html>The Amount Is Invalid</html>");
                val = "";
                tf2.setText("");
              }

              else if((Integer.parseInt(total)+Integer.parseInt(val)) <-1100000000){
                tx.setText("<html>Invalid (Max total is below 3 billion)</html>");
                val = "";
                tf2.setText("");
              }

            else{

              total = ""+ (Integer.parseInt(total) + Integer.parseInt(val));
                tx.setText("<html>You Have Deposited</html>");
                writer.write(username);
                writer.newLine();
                writer.write(password);
                writer.newLine();
                writer.write(firstname);
                writer.newLine();
                writer.write(lastname);
                writer.newLine();
                writer.write(gmail);
                writer.newLine();
                writer.write(total);
                writer.close();

  tx.setFont(new Font("Calibri", Font.BOLD, 18));
                val = "";
                tf2.setText("");
              tf2.setVisible(false);
          Enter.setVisible(false);
    System.out.println("User has Deposited");
            }
        }

        }
        catch (NumberFormatException | IOException ex){
            //If what the user entered was not a number then the textfield will just clear
            //if nothing else will happen
        val = "";
        tf2.setText("");
        tx.setText("<html>The Amount Is Invalid</html>");

        } 
      
      
    }
});
  
    frame.getContentPane().add(BorderLayout.CENTER,Buttons);
    frame.getContentPane().add(BorderLayout.NORTH, Text);
    frame.getContentPane().add(BorderLayout.SOUTH, BackButton);
    
    frame.setVisible(true);
}

//============================================================


public void Counter(){//I had to use a method to increment the counter since I can't do it within the button
 count++;
}
public int getCounter(){
    return count;
}
public void ResetCounter(){
    count = 1;
}
public void setCounter(int num){
    count = num;
}
    public static void main(String[]args) throws IOException{
        SergCoin bank = new SergCoin();


      bank.Menu();

   }

}
