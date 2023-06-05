package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class ExitCommand extends Command {
	public ExitCommand(){
		super("quit");
	}
	
	@Override
	public void actionPerformed(ActionEvent evt)
    {
		System.out.println("exit");
		Command exit = new Command("exit");
		Command stay = new Command("stay");
		Command []cmd = new Command[] {exit, stay};
		Command bOk = Dialog.show("Confirm quit?", "Are yousure you want to quit?",cmd);
		if (bOk == exit){ //check if ok or cancel
			Display.getInstance().exitApplication();
			}//exit                
    }
}