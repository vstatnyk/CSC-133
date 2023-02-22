package com.mycompany.a1;
import com.codename1.ui.events.ActionListener; 
import com.codename1.ui.Label; 
import com.codename1.ui.TextField; 
import com.codename1.ui.events.ActionEvent; 
import java.lang.String; 

public class Game extends com.codename1.ui.Form{
	private GameWorld gw;
	
	Game(){
		gw = new GameWorld();
		gw.init();
		play();
		
	}

	private void play() { 
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
}

