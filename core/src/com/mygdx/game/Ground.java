package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import fgdx.DisplayObject;
import fgdx.Drawable;

public class Ground implements Drawable {
	ArrayList<DisplayObject> walls;
	Vector2 dim;
	int count = 20;
	public Ground(Vector2 pos, Vector2 dim) {
		this.dim = dim;
		walls = new ArrayList<DisplayObject>();
		for(int i = 0;i<count;i++){
			walls.add(new DisplayObject(new Vector2(0,pos.y),new Vector2(dim.x,dim.y), new Texture("object/grass.png")));
		}
		walls.add(new DisplayObject(new Vector2(-1000,pos.y),new Vector2(40,100), new Texture("object/grass.png")));
		//walls.add(new DisplayObject(new Vector2(-1000,pos.y),new Vector2(40,100), new Texture("object/grass.png")));
		move(0);
		//super(pos, dim, new Texture("object/grass.png"));
		// TODO Auto-generated constructor stub
	}
	
	public void move(float x) {
		int center  = (int) Math.floor(x/dim.x);
		int start = center - count/2;
		for(int i = 0;i<count;i++){
			walls.get(i).pos.x = ((start+i)*walls.get(i).dim.x);
		}
		for(int i = count;i<walls.size();i++){
			if(walls.get(i).pos.x < x-500-walls.get(i).dim.x){
				
				walls.get(i).dim.y = (float) (100+Math.random()*200);
				walls.get(i).dim.x = (float) (200+Math.random()*800);
				walls.get(i).pos.x=(float) (x+500+Math.random()*800);
			}
		}
	}
	
	@Override
	public void draw(Batch b) {
		for(DisplayObject d: walls){
			d.draw(b);
		}
		
	}

}
