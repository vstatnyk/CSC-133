package com.mycompany.a2;
import java.util.Vector;

public class GameObjectCollection implements ICollection {
	
	private Vector<GameObject> gameObjectCollection;
	
	public GameObjectCollection(){
		gameObjectCollection = new Vector<GameObject>();
		
	}
	
	public void add(GameObject go){
		gameObjectCollection.add(go);
	}
	
	public IIterator getIterator(){
		return new Iterator();
	}	
	
	
	private class Iterator implements IIterator{
		
		private int index = -1;
		
		public void Iterator(){
			return;
		};
		public boolean hasNext(){
			if(gameObjectCollection.size() <= 0)
				return false;
			if(index == gameObjectCollection.size() - 1)
			{
				return false;
			}
			return true;
			
		};
		public GameObject getNext(){
			index ++;
			return gameObjectCollection.get(index); 
		};
	}
}
