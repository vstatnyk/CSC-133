package com.mycompany.a3;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class PauseCommand implements ActionListener {
	private Game g;
	private boolean pause;
	
	public PauseCommand(Game g){
		this.g = g;
		this.pause = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
    {
		
		if(this.pause){
			System.out.println("paly");
			g.play();
			this.pause=false;
		}
		else{
			System.out.println("pause");
			g.pause();
			this.pause=true;
		}
//		gw.pasue();
		
    }

}
