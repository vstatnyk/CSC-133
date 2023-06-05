package com.mycompany.a4;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class AccelerateCommand implements ActionListener {
	private GameWorld gw;
	public AccelerateCommand(GameWorld gw){
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
    {
		System.out.println("Player Robot accelerating");
        gw.accelerate();
    }
	
}
