package com.mycompany.a4;
import java.util.Observer;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.Transform;
import com.codename1.ui.geom.Shape;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;

import java.util.Observable;

public class MapView extends Container implements Observer {
	
	Transform worldToND, ndToDisplay, theVTM ;
	private float winLeft, winBottom, winRight, winTop;

	
//	public void paint (Graphics g) {
//		super.paint(g);
//		//...[calculate winWidth and winHeight]
//		// construct the Viewing Transformation Matrix
//		worldToND = buildWorldToNDXform(getWidth(), getHeight(), winLeft, winBottom);
//		ndToDisplay = buildNDToDisplayXform(this.getWidth(), this.getHeight());
//		theVTM = ndToDisplay.copy();
//		theVTM.concatenate(worldToND); // worldToND will be applied first to points!
//	
//		Transform gXform = Transform.makeIdentity();
//		g.getTransform(gXform);
//		gXform.translate(getAbsoluteX(),getAbsoluteY()); //local origin xform (part 2)
//		gXform.concatenate(theVTM); //VTM xform
//		gXform.translate(-getAbsoluteX(),-getAbsoluteY()); //local origin xform (part 1)
//		g.setTransform(gXform);
//		// tell each shape to draw itself using the g (which contains the VTM)
//		Point pCmpRelPrnt = new Point(this.getX(), this.getY());
//		Point pCmpRelScrn = new Point(getAbsoluteX(),getAbsoluteY());
//		
//	//	for (Shape s : shapeCollection)
//	//	s.draw(g, pCmpRelPrnt, pCmpRelScrn);
//		g.resetAffine() ;
//	}
	
	private Transform buildWorldToNDXform(float winWidth, float winHeight, float
	winLeft, float winBottom){
	Transform tmpXfrom = Transform.makeIdentity();
	tmpXfrom.scale( (1/winWidth) , (1/winHeight) );
	tmpXfrom.translate(-winLeft,-winBottom);
	return tmpXfrom;
	}
	
	private Transform buildNDToDisplayXform (float displayWidth, float
	displayHeight){
	Transform tmpXfrom = Transform.makeIdentity();
	tmpXfrom.translate(0, displayHeight);
	tmpXfrom.scale(displayWidth, -displayHeight);
	return tmpXfrom;
	}
	//...[other methods of CustomContainer]
	
	
//	
	private GameWorld gw;
//	int height;
//	int width;
//	
	public MapView(GameWorld gw) {
		//initialize world window
		super((new BoxLayout(BoxLayout.X_AXIS)));
		this.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.rgb(0,255,0)));
		this.gw = gw;
		winLeft = 0;
		winBottom = 0;
		winRight = 931/2; //hardcoded value = this.getWidth()/2 (for the iPad skin)
		winTop = 639/2; //hardcoded value = this.getHeight()/2 (for the iPad skin)
		float winWidth = winRight - winLeft;
		float winHeight = winTop - winBottom;
		
	}
//	
//	
	@Override
	public void paint(Graphics g){
		
		super.paint(g);

		worldToND = buildWorldToNDXform(getWidth(), getHeight(), winLeft, winBottom);
		ndToDisplay = buildNDToDisplayXform(this.getWidth(), this.getHeight());
		theVTM = ndToDisplay.copy();
		theVTM.concatenate(worldToND); // worldToND will be applied first to points!

		Transform gXform = Transform.makeIdentity();
		g.getTransform(gXform);
		gXform.translate(getAbsoluteX(),getAbsoluteY()); //local origin xform (part 2)
		gXform.concatenate(theVTM); //VTM xform
		gXform.translate(-getAbsoluteX(),-getAbsoluteY()); //local origin xform (part 1)

		gXform.scale(1, -1);
		gXform.translate(0, -getHeight()); // Move the origin to the bottom-left corner

		g.setTransform(gXform);

		IIterator i = this.gw.getCollection().getIterator();
		while (i.hasNext()){
		    GameObject tempGO = i.getNext();
		    if(tempGO instanceof IDrawable){
		        Coordinate x = new Coordinate(this.getX()+this.getHeight(), this.getY()+this.getHeight());
//		        if(tempGO instanceof Movable){
//		        	
//		        }
//		        Transform t = Transform.makeIdentity();
		        
		        

		        // Draw the object
		        ((IDrawable)tempGO).draw(g);

		        // Restore the original transform
//		        g.restore();
		        
		    }
		}

		g.resetAffine();


	}
	
	@Override
	public void pointerPressed(int x, int y) {
		if(gw.getPause()){
			System.out.print("\n\n\n\n");
			
			//make pointer location relative to parent’s origin
			x = x - getParent().getAbsoluteX();
			y = y - getParent().getAbsoluteY() ;
			
			System.out.println(x+""+y);
//			Coordinate pPtrRelPrnt = new Coordinate(x, y);
//			Coordinate pCmpRelPrnt = new Coordinate(getX(), getY());
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
//	
//	
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