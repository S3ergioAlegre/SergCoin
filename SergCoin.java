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

public class Test4{

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
    

//These variables are going to be used when creating an account or 
String username = "";
String password = "";
String firstname = "";
String lastname = "";
String gmail = "";
String total = "";



public void Menu() throws IOException{
  File[] files = new File("/Users/sergi/OneDrive/Documents/Accounts").listFiles();
    frame = new JFrame("SergCoin");   
    ImageIcon img = new ImageIcon("C:/Users/sergi/OneDrive/Pictures/Smile.jpeg");
    frame.setIconImage(img.getImage());

    Login = new JPanel();
    Account = new JPanel();
    Text = new JPanel();
    usernamelb = new JLabel("Enter username:");
    passwordlb = new JLabel("Enter Password: ");
    AccountLabel = new JLabel("Create Account: ");
    tx = new JLabel("Login or Create New Account");
    usernamelb.setFont(new Font("Arial", Font.BOLD, 14));
    passwordlb.setFont(new Font("Arial", Font.BOLD, 14));

    tx.setFont(new Font("Calibri", Font.BOLD, 18));
//Verdana Font.PLAIN
    tf2 = new JTextField(10);
    //makes the text look password protected even though its not
    tf3 = new JPasswordField(10);
    LoginButton = new JButton("Enter");
    CreateButton = new JButton("Create");



    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(580,210);// width: 300 height: 300
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

        LoginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
        String name = tf2.getText();
        String pass = new String(tf3.getPassword());
        try{
        if(files.length<1){//ls.size()<1 && ls.size()<1
            System.out.println(files.length);
            usernamelb.setText("Invalid name");
            passwordlb.setText("Invalid password");
        }
      }
      catch(Exception e1){
        //e1.printStackTrace();
        //System.out.print("File doesn't exist");
      }
      //System.out.println("Its now "+files.length);
        for(int i = 0;i<files.length;i++){
          
          try {
            
            String username = Files.readAllLines(Paths.get("/Users/sergi/OneDrive/Documents/Accounts/"+files[i].getName())).get(0);
            String password = Files.readAllLines(Paths.get("/Users/sergi/OneDrive/Documents/Accounts/"+files[i].getName())).get(1);
            if(!username.equals(name)){//it checks the first element first, which is the reason why it says invalid name even though its not
                usernamelb.setText("Invalid name");
                //break;
            }
            else if(!password.equals(pass)){
                passwordlb.setText("Invalid password");
                //break;
            }
            else if(username.equals(name) && password.equals(pass)){
              
                frame.setVisible(false);
                System.out.print("true");
                //logger = ls.get(i);/////////////////////////////////////////////
               //make a global var for the file
               txtfile = "/Users/sergi/OneDrive/Documents/Accounts/"+files[i].getName();//+".txt"
                Account();
                
            }
          } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            

          }
          
            //    
        }
        
    
    }//this is bracket that is at the end of the button bracket
});

CreateButton.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
frame.setVisible(false);
//add the create account method here
try {
  CreateAccount();
} catch (IOException e1) {
  // TODO Auto-generated catch block
  e1.printStackTrace();
}

    }
});
   frame.getContentPane().add(BorderLayout.WEST,Login);//.setBackground(Color.RED);//it was in WEST
    frame.getContentPane().add(BorderLayout.SOUTH,Account);//.setBackground(Color.RED);//SOUTH
    frame.getContentPane().add(BorderLayout.NORTH, Text);//.setBackground(Color.RED);
    frame.setVisible(true);
    //For the BorderLayout there are options like CENTER, NORTH, SOUTH, LINE_START, LINE_END, 
}
//======================================================================
  //Work on this method
public  void CreateAccount() throws IOException{
  File[] files = new File("/Users/sergi/OneDrive/Documents/Accounts").listFiles();
    frame = new JFrame("Creating Account...");
    ImageIcon img = new ImageIcon("C:/Users/sergi/OneDrive/Pictures/Smile.jpeg");
    frame.setIconImage(img.getImage());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(590,210);
        frame.setResizable(false);
        
        //Account = new JPanel();
        JPanel Username = new JPanel();
        JPanel Password = new JPanel();
        JPanel Button = new JPanel();//This button panel contains the back and the create button
        BackButton = new JButton("MENU");
        JButton create = new JButton("Next");
        usernamelb = new JLabel("<html>Create Username:<br/></html>");//I dont need to leave the html stuff there
        passwordlb = new JLabel("Create password:");

        usernamelb.setFont(new Font("Arial", Font.BOLD, 14));
        passwordlb.setFont(new Font("Arial", Font.BOLD, 14));

        tf2 = new JTextField(10);
        tf4 = new JTextField(10);

  //This is something that I just have learned
  // "<html> ... <br/> ...</html>" the text right after the <br/> will be in the next line
        
        Button.add(BackButton);
        Button.add(create);
        
        Username.add(usernamelb);
        Username.add(tf2);
        Password.add(passwordlb);
        Password.add(tf4);//it used to say tf3

        

create.addActionListener(new ActionListener(){
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
//--------------
if(getCounter()==1){
    
int count = 1;
for(int i =0;i<files.length;i++){
  

    String line = Files.readAllLines(Paths.get("/Users/sergi/OneDrive/Documents/Accounts/"+files[i].getName())).get(0);
    if(line.equals(name) || name.length()<1){//In here use the method of getting the name from the specific line
      usernamelb.setText("Invalid Name");
      count = 0;
      break;
    }
   
  
}
    
if(count == 1){  
    if(pass.length()>0){
        Counter();//count is now 2


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
}//--------------


//Start of counter 2
if(getCounter()==2){
System.out.println("This is getCounter 2 now...");

usernamelb.setText("Enter Firstname: ");
passwordlb.setText("Enter Lastname: ");
tf2.setText("");
tf4.setText("");


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
catch(NumberFormatException e1){
  passwordlb.setText("Invalid Total: ");
  count = 0;
}





if(count==1){
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
//ls.add(info);///////////////////////////////////////This right here is what I have
//To replace, This is where I have to reset the variables and add to the file(thats when it creates)
file = new File("/Users/sergi/OneDrive/Documents/Accounts/"+username+".txt");

  fw = new FileWriter(file);
//You need to add the true part to add to the file instead of replacing
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
          // TODO Auto-generated catch block
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
ImageIcon img = new ImageIcon("C:/Users/sergi/OneDrive/Pictures/Smile.jpeg");
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
    username = Files.readAllLines(Paths.get(txtfile)).get(0);
        password = Files.readAllLines(Paths.get(txtfile)).get(1);
        firstname = Files.readAllLines(Paths.get(txtfile)).get(2);
        lastname = Files.readAllLines(Paths.get(txtfile)).get(3);
        gmail = Files.readAllLines(Paths.get(txtfile)).get(4);
        total = Files.readAllLines(Paths.get(txtfile)).get(5);

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
    /*
    tx.setMinimumSize(new Dimension(100,100));
    tx.setPreferredSize(new Dimension(100, 200));
    tx.setMaximumSize(new Dimension(100, 200));
    tx.setText("<html>Your balance is:<br/>$"+logger.getTotal());
    */
    //This might be important when placing the text in the screen in a specific spot
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
  //e1.printStackTrace();
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
  
menu.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
    //frame.setVisible(false);
    frame.dispose();
  try {
    Menu();
  } catch (IOException e1) {
    // TODO Auto-generated catch block
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
          //e2.printStackTrace();
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
        Test4 bank = new Test4();


      bank.Menu();

   }

}
