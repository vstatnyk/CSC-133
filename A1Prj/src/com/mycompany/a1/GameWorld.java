package com.mycompany.a1;
import com.codename1.ui.events.ActionListener; 
import com.codename1.ui.Label; 
import com.codename1.ui.TextField; 
import com.codename1.ui.events.ActionEvent; 
import java.lang.String; 
import java.util.Vector;

public class GameWorld {
	 
	private Vector<Base> bases = new Vector<Base>();
	private Robot r;
	



	public void init(){
		//code here to create the
		//initial game objects/setup
		System.out.println("GameWorld init() invoked");
		for(int i = 1; i < 4; i++ ){
			bases.add(new Base(i));
		}
		for(int i = 0; i < bases.size(); i++ ){
			System.out.println("Base: " + bases.get(i).getSequence() + "(" +bases.get(i).getLocation().getX() + ", "+ bases.get(i).getLocation().getY() + ")");
			System.out.println("	size: " + bases.get(i).getSize() );
			
		}
		
		this.r = new Robot(10, bases.get(0).getLocation().getX(), bases.get(0).getLocation().getY());
		System.out.print(r.info());
		
		

	}

	public void exit(){System.out.println("GameWorld exit() invoked");}
	   // additional methods here to
	   // manipulate world objects and
	   // related game state data
	   
	}