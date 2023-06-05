package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;
public class SoundCommand extends Command {
	GameWorld gw;
	public SoundCommand(GameWorld gw){
		super("Sound");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt)
    {
		System.out.println("Sound"+ gw.getSound());
		Command on = new Command("on");
		Command off = new Command("off");
		Command []cmd = new Command[] {on, off};
		Command bOk = Dialog.show("Sound", "Would you like sound ON or OFF?",cmd);
		if (bOk == on){
			gw.setSound(true);
		}
		else{
			gw.setSound(false);
		}
    }    
}