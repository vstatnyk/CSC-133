package com.mycompany.a3;
import com.codename1.location.Location;
import com.codename1.ui.Graphics;
//import java.util.Random;
//import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point;
import com.codename1.util.MathUtil;
import com.codename1.ui.geom.Point;

// ColorUtil.rgb(r, g, b) for any int color
public class Fixed extends GameObject implements ISelectable {
	public Fixed(int color, int size){
		super(color, size);
	}
	
	public Fixed(int color ){
		super(color);
	}
	
	private boolean isSelected;
	
	public void setSelected(boolean b){ this.isSelected = b;}
	public boolean isSelected(){ return isSelected; }
	
	public boolean contains(int x, int y){
	
		double thisX = this.getLocation().getX();
		double thisY = this.getLocation().getY();
		
		double deltaX = thisX - x;
		double deltaY = thisY - y;
		
		double distance = ((int) (MathUtil.pow((int)deltaX, 2)) + (int) (MathUtil.pow((int)deltaY, 2)));
		
		int radius1= this.getSize() / 2;
		int radius2= 1;
		
		int result= (int) (MathUtil.pow((int)radius1, 2)+ 2 * radius1 * radius2 + (int) (MathUtil.pow((int)radius2, 2)));
		if (distance <= result){return true;}
		
		return false;
		
	}
	
	public void draw(Graphics g, Coordinate pCmpRelPrnt) {}
	
	
}
