package com.mycompany.a4;

import com.codename1.location.Location;
import com.codename1.ui.Graphics;

public interface ISelectable {
	
//	void pointerPressed(double x, double y);
	
//		private boolean isSelected;
	public void setSelected(boolean b);//{ isSelected = b; }
	public boolean isSelected();//{ return isSelected; }
	public void draw(Graphics g, Coordinate pCmpRelPrnt);
	public boolean contains(int x, int y);

	
}
