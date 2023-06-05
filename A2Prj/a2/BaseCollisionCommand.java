package com.mycompany.a2;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class BaseCollisionCommand implements ActionListener {
	private GameWorld gw;
	public BaseCollisionCommand(GameWorld gw){
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt)
    {
		System.out.println("Base Collision");
		Command enter = new Command("Enter");
		TextField t = new TextField();
		Dialog.show("Base #", t, enter);
		int i = Integer.parseInt(t.getText());
		gw.baseCollision(i);                

    }
	
}