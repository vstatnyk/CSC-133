package com.mycompany.a3;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;

import java.util.Observable;

public class MapView extends Container implements Observer {
	private GameWorld gw;
	int height;
	int width;
	
	public MapView(GameWorld gw) {
		
		super((new BoxLayout(BoxLayout.X_AXIS)));
		this.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.rgb(0,255,0)));
		this.gw = gw;
		
	}
	
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		
		IIterator i = this.gw.getCollection().getIterator();
		while (i.hasNext()){
			GameObject tempGO = i.getNext();
			if(tempGO instanceof IDrawable){
				Coordinate x = new Coordinate(this.getX()+this.getHeight(), this.getY()+this.getHeight());
				((IDrawable)tempGO).draw(g);
			}
		}
		

	}
	
	@Override
	public void pointerPressed(int x, int y) {
		if(gw.getPause()){
			System.out.print("\n\n\n\n");
			
			//make pointer location relative to parent’s origin
			x = x - getParent().getAbsoluteX();
			y = y - getParent().getAbsoluteY();
			
			System.out.println(x+""+y);
			Coordinate pPtrRelPrnt = new Coordinate(x, y);
			Coordinate pCmpRelPrnt = new Coordinate(getX(), getY());
				IIterator i = this.gw.getCollection().getIterator();
				while (i.hasNext()){
					GameObject tempGO = i.getNext();
					if(tempGO instanceof Fixed){
						if(((Fixed)tempGO).contains(x, y) && !((Fixed)tempGO).isSelected()){
							((Fixed)tempGO).setSelected(true);
						}
						else if(((Fixed)tempGO).isSelected()){
							((Fixed)tempGO).setSelected(false);
							((Fixed)tempGO).setLocation(x,y);
						}
//						if (shape.contains(pPtrRelPrnt, pCmpRelPrnt)) {
//							shape.setSelected(true);
//						} else {
//							shape.setSelected(false);
//						}
					}
				}
				
			repaint();
		}
	}
	
	
	@Override
	public void update(Observable observable, Object data) {
//		System.out.print("hi"+this.getAbsoluteX());
		gw = (GameWorld) data;
		IIterator i = gw.getCollection().getIterator();
		while (i.hasNext()){
			GameObject tempGO = i.getNext();
			System.out.println(tempGO.info());
		}
		repaint();
		
	}
	
	
//	public int getHeight(){return this.height;}
//	public int getWidth() {return this.width;}
//	public void setHeight(int h){this.height = h;}
//	public void setWidth(int w) {this.width = w;}
	
	
}