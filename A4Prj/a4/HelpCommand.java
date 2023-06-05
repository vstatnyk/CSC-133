package com.mycompany.a4;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class HelpCommand extends Command {
	private String helpString = "";
	
	public HelpCommand(){
		super("Help");
		helpString = helpString + "Accelerate Player Robot press: a\n";
		helpString = helpString + "Brake Player Robot press: b\n";
		helpString = helpString + "Turn Player Robot Left press: l\n";
		helpString = helpString + "Turn Player Robot Right press: r\n";
		helpString = helpString + "Collide with NPR press: c\n";
		helpString = helpString + "Collide with Energy Stattion press: e\n";
		helpString = helpString + "Collide with Drone press: g\n";
		helpString = helpString + "Tick Time press: t\n";
	}
	
	@Override
	public void actionPerformed(ActionEvent evt){
		System.out.println("Help");
		Dialog.show("Help", helpString, new Command("Ok"));     
    }
}