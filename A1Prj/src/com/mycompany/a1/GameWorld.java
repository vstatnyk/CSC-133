package com.mycompany.a1;

public class GameWorld {
	   public void init(){
	      //code here to create the
	      //initial game objects/setup
		   
	}
	   // additional methods here to
	   // manipulate world objects and
	   // related game state data
	}



private void play() 
{ 
Label myLabel=new Label("Enter a Command:"); 
this.addComponent(myLabel); 
final TextField myTextField=new TextField(); 
this.addComponent(myTextField); 
this.show(); 

myTextField.addActionListener(new ActionListener(){ 

 public void actionPerformed(ActionEvent evt) { 
    
 String sCommand=myTextField.getText().toString(); 
 myTextField.clear(); 
 switch (sCommand.charAt(0)) { 
  case 'x': 
   gw.exit();  
   break; 
  //add code to handle rest of the commands  
 } //switch 
} //actionPerformed 
   } //new ActionListener() 
); //addActionListener 
} //play