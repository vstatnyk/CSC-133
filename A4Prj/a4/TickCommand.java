package com.mycompany.a4;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class TickCommand implements ActionListener {
	private GameWorld gw;
	
	public TickCommand(GameWorld gw){
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
    {
		System.out.println("Tick");
		gw.tick();
		
    }

}
