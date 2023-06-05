package com.mycompany.a4;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class AboutCommand extends Command {
	public AboutCommand(){
		super("About");
	}
	
	@Override
	public void actionPerformed(ActionEvent evt){
		System.out.println("Help");
		String aboutString = "";
		aboutString = aboutString + "Vlad Statnyk\n";
		aboutString = aboutString + "CSC 133\n";
		aboutString = aboutString + "A2Prj\n";
		aboutString = aboutString + "Making this last minute lol\n";
		
		Dialog.show("About", aboutString , new Command("Ok"));     
    }
}
