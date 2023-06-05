package com.mycompany.a2;
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
import com.codename1.ui.Label; 
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent; 
import java.lang.String;
import java.util.Vector; 


public class Game extends com.codename1.ui.Form {
	
	private GameWorld gw;
	private MapView mv; // new in A2
	private ScoreView sv; // new in A2
	private Display d = Display.getInstance();
	int width = d.getDisplayWidth();
	int height = d.getDisplayHeight();
	
	public Game(){
		
		this.setLayout(new BorderLayout());
		
//		TODO
		gw = new GameWorld(); // create “Observable” GameWorld
		gw.init();
		mv = new MapView(width, height); // create an “Observer” for the map
		sv = new ScoreView(this, gw); // create an “Observer” for the game/player-robot
		// state data
		
//		TODO
		gw.addObserver(mv); // register the map observer
		gw.addObserver(sv); // register the score observer
		
		// code here to create Command objects for each command,
		// add commands to side menu and title bar area, bind commands to keys, create
		// control containers for the buttons, add buttons to the control containers,
		// add commands to the buttons, and add control containers, MapView, and
		// ScoreView to the form
		
		
//		TODO
		
		// code here to query MapView’s width and height and set them as world’s
		// width and height
		
		
		
		
		
//		TODO
//		gw.init(); // initialize world
//		topContainer();
		bottomContainer();
		leftContainer();
		rightContainer(); 
		centerContainer();
		
		//toolbar
		Toolbar myToolbar = new Toolbar();
		setToolbar(myToolbar);
		myToolbar.setTitle("Robo-Track Game");
		myToolbar.addCommandToSideMenu(new ExitCommand());
		myToolbar.addCommandToSideMenu(new HelpCommand());
		myToolbar.addCommandToSideMenu(new SoundCommand(gw));
		myToolbar.addCommandToSideMenu(new AboutCommand());
		
//		Command overflowMenuItem1 = new Command("Overflow Menu Item 1");
//		myToolbar.addCommandToOverflowMenu(overflowMenuItem1);
		Command titleBarAreaItem1 = new HelpCommand();
		myToolbar.addCommandToRightBar(titleBarAreaItem1);
		
		
//		TODO add change strat here
//		this.addKeyListener('c', titleBarAreaItem1);
		
		
		this.show();
	}
	
	private void centerContainer() {
		Container centerContainer = new Container((new BoxLayout(BoxLayout.X_AXIS)));
//		centerContainer.getAllStyles().setPadding(100, 100, 100, 100);
//		System.out.println(centerContainer.getOuterHeight());
//		System.out.println(centerContainer.getWidth());
		System.out.println(centerContainer.getWidth());
		
		centerContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.rgb(255,0,0)));
		this.add(BorderLayout.CENTER,centerContainer);
	}
	private void bottomContainer(){
		
		Container BottomContainer = new Container((new BoxLayout(BoxLayout.X_AXIS)));
		bottomStyle( BottomContainer);
		
		//Robot Collision
		RobotCollisionCommand c = new RobotCollisionCommand(gw);
		Button NPRCollision = new Button("Collide with  NPR");
		NPRCollision.addActionListener(c);
		addKeyListener('c', c);
		BottomContainer.addComponent(NPRCollision);
		
		btnStyle(NPRCollision);
		
		//TODO
		//Base Collision
		BaseCollisionCommand b = new BaseCollisionCommand(gw);
		Button BaseCollision = new Button("Collide with Base");
		BaseCollision.addActionListener(b);
		BottomContainer.addComponent(BaseCollision);
		btnStyle(BaseCollision);
		
		//Energy Station Collision
		EnergyStationCollision e = new EnergyStationCollision(gw);
		Button EnergyStationCollision = new Button("Collide with Energy Station");
		EnergyStationCollision.addActionListener(e);
		addKeyListener('e', e);
		BottomContainer.addComponent(EnergyStationCollision);
		btnStyle(EnergyStationCollision);
		
		
		//Drone Collision
		DroneCollisionCommand g = new DroneCollisionCommand(gw);
		Button DroneCollision = new Button("Collide with Drone");
		addKeyListener('g', g);
		DroneCollision.addActionListener(g);
		BottomContainer.addComponent(DroneCollision);
		btnStyle(DroneCollision);
		
		//Tick
		TickCommand t = new TickCommand(gw);
		Button Tick = new Button("Tick");
		Tick.addActionListener(t);
		addKeyListener('t', t);
		BottomContainer.addComponent(Tick);
		btnStyle(Tick);
		
		Tick.getAllStyles().setPadding(LEFT,5);
		Tick.getAllStyles().setPadding(RIGHT,5);
		
		
		TextField a  = new TextField("hi");
		
		BottomContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLUE));
		this.add(BorderLayout.SOUTH,BottomContainer);
	}
	private void leftContainer(){
		
		Container leftContainer = new Container((new BoxLayout(BoxLayout.Y_AXIS)));
		sideStyle(leftContainer);
		
		//Accelerate 
		AccelerateCommand a = new AccelerateCommand(gw) ;
		Button Accelerate = new Button("Accelerate");
		Accelerate.addActionListener(a);
		addKeyListener('a', a);
		leftContainer.addComponent(Accelerate);
		btnStyle(Accelerate);
		
		//Left
		GoLeftCommand l = new GoLeftCommand(gw);
		Button Left = new Button("Left");
		Left.addActionListener(l);
		addKeyListener('l', l);
		leftContainer.addComponent(Left);
		btnStyle(Left);
		
		//TODO
		//Change strategies
		ChangeStrategyCommand c = new ChangeStrategyCommand(gw);
		Button ChangeStrategies = new Button("Change strategies");
		ChangeStrategies.addActionListener(c);
		leftContainer.addComponent(ChangeStrategies);
		btnStyle(ChangeStrategies);
		
		leftContainer.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.BLUE));
		this.add(BorderLayout.WEST,leftContainer);
	}
	private void rightContainer(){
		Container rightContainer = new Container((new BoxLayout(BoxLayout.Y_AXIS)));
		sideStyle(rightContainer);
		
		//Break
		BreakCommand b = new BreakCommand(gw) ;
		Button Break = new Button("Brake");
		Break.addActionListener(b);
		addKeyListener('b', b);
		rightContainer.addComponent(Break);
		btnStyle(Break);
		
		Break.getAllStyles().setPadding(LEFT,5);
		Break.getAllStyles().setPadding(RIGHT,5);
		
		//Right
		GoRightCommand r = new GoRightCommand(gw);
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
}
