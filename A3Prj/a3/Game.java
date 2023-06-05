package com.mycompany.a3;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.codename1.ui.Label; 
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent; 
import java.lang.String;
import java.util.Vector; 


public class Game extends com.codename1.ui.Form implements Runnable{
	
	private GameWorld gw;
	private MapView mv; // new in A2
	private ScoreView sv; // new in A2
	private Display d = Display.getInstance();
	UITimer timer = new UITimer(this);
	boolean pause = false;
	Container bottomContainer = new Container((new BoxLayout(BoxLayout.X_AXIS)));
	Container leftContainer = new Container((new BoxLayout(BoxLayout.Y_AXIS)));
	Container rightContainer = new Container((new BoxLayout(BoxLayout.Y_AXIS)));
	PauseCommand p ;
	AccelerateCommand a;
	GoLeftCommand l;
	ChangeStrategyCommand c;
	BreakCommand b;
	GoRightCommand r;
	
	public Game(){
		
		this.setLayout(new BorderLayout());
	
		
//		TODO
		gw = new GameWorld();
		gw.init();// create “Observable” GameWorld
		mv = new MapView(gw); // create an “Observer” for the map
		sv = new ScoreView(); // create an “Observer” for the game/player-robot
		gw.addObserver(mv); // register the map observer
		gw.addObserver(sv); // register the score observer
		
		
//		TODO
		
		p = new PauseCommand(this);
		a = new AccelerateCommand(gw) ;
		l = new GoLeftCommand(gw);
		c = new ChangeStrategyCommand(gw);
		b = new BreakCommand(gw) ;
		r = new GoRightCommand(gw);
		
		bottomContainer();
		leftContainer();
		rightContainer();
		this.add(BorderLayout.CENTER, mv);
		this.add(BorderLayout.NORTH,sv);
		
		//toolbar
		Toolbar myToolbar = new Toolbar();
		setToolbar(myToolbar);
		myToolbar.setTitle("Robo-Track Game");
		myToolbar.addCommandToSideMenu(new ExitCommand());
		myToolbar.addCommandToSideMenu(new HelpCommand());
		myToolbar.addCommandToSideMenu(new SoundCommand(gw));
		myToolbar.addCommandToSideMenu(new AboutCommand());
		
		Command titleBarAreaItem1 = new HelpCommand();
		myToolbar.addCommandToRightBar(titleBarAreaItem1);
		
		
		
		
		
		this.show();
		
		
		int topX = mv.getAbsoluteX()+ mv.getWidth();
		int botX = mv.getAbsoluteX();
		int topY = mv.getAbsoluteY()+ mv.getHeight();
		int botY = mv.getAbsoluteY();
		
		System.out.println(topX);
		System.out.println(botX);
		System.out.println(topY);
		System.out.println(botY);
		
//		gw.init();
		
		timer.schedule(1000, true, this);
		
		
	}
	
//	private void centerContainer() {
//		Container centerContainer = new Container();	
//		centerContainer.
//		this.add(centerContainer);
//	}
	private void bottomContainer(){
		
		bottomStyle( bottomContainer);
		
		
//		ChangeStrategyCommand c = new ChangeStrategyCommand(gw);
//		Button ChangeStrategies = new Button("Change strategies");
//		ChangeStrategies.addActionListener(c);
//		leftContainer.addComponent(ChangeStrategies);
//		btnStyle(ChangeStrategies);
		
		//Pause
//		PauseCommand p = new PauseCommand(this);
		Button Pause = new Button("Pause");
		Pause.addActionListener(p);
		Pause.setEnabled(true);
		bottomContainer.addComponent(Pause);
		btnStyle(Pause);
		
		Pause.getAllStyles().setPadding(LEFT,5);
		Pause.getAllStyles().setPadding(RIGHT,5);
		
		
		TextField a  = new TextField("hi");
		
		bottomContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLUE));
		this.add(BorderLayout.SOUTH,bottomContainer);
	}
	private void leftContainer(){
		
		sideStyle(leftContainer);
		
		//Accelerate 
//		AccelerateCommand a = new AccelerateCommand(gw) ;
		Button Accelerate = new Button("Accelerate");
		Accelerate.addActionListener(a);
		addKeyListener('a', a);
		leftContainer.addComponent(Accelerate);
		btnStyle(Accelerate);
		
		//Left
//		GoLeftCommand l = new GoLeftCommand(gw);
		Button Left = new Button("Left");
		Left.addActionListener(l);
		addKeyListener('l', l);
		leftContainer.addComponent(Left);
		btnStyle(Left);
		
		//TODO
		//Change strategies
//		ChangeStrategyCommand c = new ChangeStrategyCommand(gw);
		Button ChangeStrategies = new Button("Change strategies");
		ChangeStrategies.addActionListener(c);
		leftContainer.addComponent(ChangeStrategies);
		btnStyle(ChangeStrategies);
		
		leftContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLUE));
		this.add(BorderLayout.WEST,leftContainer);
	}
	private void rightContainer(){
		sideStyle(rightContainer);
		
		//Break
//		BreakCommand b = new BreakCommand(gw) ;
		Button Break = new Button("Brake");
		Break.addActionListener(b);
		addKeyListener('b', b);
		rightContainer.addComponent(Break);
		btnStyle(Break);
		
		Break.getAllStyles().setPadding(LEFT,5);
		Break.getAllStyles().setPadding(RIGHT,5);
		
		//Right
//		GoRightCommand r = new GoRightCommand(gw);
		Button Right = new Button("Right");
		Right.addActionListener(r);
		addKeyListener('r', r);
		rightContainer.addComponent(Right);
		btnStyle(Right);
		Right.getAllStyles().setPadding(LEFT,5);
		Right.getAllStyles().setPadding(RIGHT,5);
		
		rightContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLUE));
		this.add(BorderLayout.EAST,rightContainer);
	}
	
//	Styles
	private void bottomStyle(Container bottom){
		bottom.getAllStyles().setPadding(0, 0, 300,0);
		bottom.getAllStyles().setBgTransparency(30);
		bottom.getUnselectedStyle().setBgColor(ColorUtil.BLACK);
	}
	private void sideStyle(Container side){
		side.getAllStyles().setPadding(Component.TOP, 50);
		side.getAllStyles().setBgTransparency(30);
		side.getUnselectedStyle().setBgColor(ColorUtil.BLACK);
	}
	private void btnStyle(Button btn){
		btn.getAllStyles().setBgTransparency(255);
		btn.getUnselectedStyle().setBgColor(ColorUtil.BLACK);
		btn.getAllStyles().setFgColor(ColorUtil.WHITE);
		btn.getAllStyles().setPadding(TOP,7);
		btn.getAllStyles().setPadding(BOTTOM,7);
//		btn.getAllStyles().setPadding(LEFT,4);
//		btn.getAllStyles().setPadding(RIGHT,4);
		btn.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLUE));
	}
	private void disableBtnStyle(Button btn){
		btn.getDisabledStyle().setBgTransparency(255);
		btn.getDisabledStyle().setBgColor(ColorUtil.GRAY);
		btn.getDisabledStyle().setFgColor(ColorUtil.WHITE);
		btn.getDisabledStyle().setPadding(TOP,7);
		btn.getDisabledStyle().setPadding(BOTTOM,7);
//		btn.getAllStyles().setPadding(LEFT,4);
//		btn.getAllStyles().setPadding(RIGHT,4);
		btn.getDisabledStyle().setBorder(Border.createLineBorder(4, ColorUtil.BLUE));
	}
	
	
	public void pause(){
		timer.cancel();

		for(int i = 0; i< this.leftContainer.getComponentCount();i++){
			this.leftContainer.getComponentAt(i).setEnabled(false);
			disableBtnStyle((Button)this.leftContainer.getComponentAt(i));
		}
		for(int i = 0; i< this.rightContainer.getComponentCount();i++){
			this.rightContainer.getComponentAt(i).setEnabled(false);
			disableBtnStyle((Button)this.rightContainer.getComponentAt(i));
		}
		removeKeyListener('a', a);
		removeKeyListener('l', a);
		removeKeyListener('r', a);
		removeKeyListener('b', a);
		
//		removeA
		
		this.pause = true;
		
		this.gw.setPause(this.pause);
	}
	
	public void play(){
		
		for(int i = 0; i< this.leftContainer.getComponentCount();i++){
			this.leftContainer.getComponentAt(i).setEnabled(true);
			btnStyle((Button)this.leftContainer.getComponentAt(i));
		}
		for(int i = 0; i< this.rightContainer.getComponentCount();i++){
			this.rightContainer.getComponentAt(i).setEnabled(true);
			btnStyle((Button)this.rightContainer.getComponentAt(i));
		}
		
		addKeyListener('a', a);
		addKeyListener('l', a);
		addKeyListener('r', a);
		addKeyListener('b', a);
		
		timer.schedule(20,true, this);
		this.pause = false;
		
		this.gw.setPause(this.pause);
	}
	
	
	@Override
	public void run(){
//		
		gw.tick();
	}
	
	
}
