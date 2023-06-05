package com.mycompany.a2;
import java.util.Observer;
import java.util.Observable;

public class MapView implements Observer{
	private GameWorld gw;
	int height;
	int width;
	
	public MapView(int h, int w) {
	}
	
	@Override
	public void update(Observable observable, Object data) {
		
		gw = (GameWorld) data;
		IIterator i = gw.getCollection().getIterator();
		while (i.hasNext()){
			GameObject tempGO = i.getNext();
			System.out.println(tempGO.info());
		}
		
	}
	
	
	public int getHeight(){return this.height;}
	public int getWidth() {return this.width;}
	public void setHeight(int h){this.height = h;}
	public void setWidth(int w) {this.width = w;}
	
	
}