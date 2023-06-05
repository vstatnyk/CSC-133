package com.mycompany.a4;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class ChangeStrategyCommand implements ActionListener {
	private GameWorld gw;
	public ChangeStrategyCommand(GameWorld gw){
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
    {
		System.out.println("Change Strategy Command");
		gw.changeStrategy(); 
    }
	
}