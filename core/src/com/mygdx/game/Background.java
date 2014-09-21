package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import fgdx.DisplayObject;
import fgdx.Drawable;
import fgdx.Screen;

public class Background implements Drawable{
	ArrayList<DisplayObject> imges;
	Vector2 dim;
	public Background(Screen s, Texture t) {
		dim = s.device.getScreenDim();//.scl(0.5f);
		imges = new ArrayList<DisplayObject>();
		for(int i = 0;i<9;i++){
			imges.add(new DisplayObject(new Vector2(0,0), dim, t));
		}
		move(new Vector2(0,0));
		//super(s.device.getScreenDim().scl(-0.5f), s.device.getScreenDim(), t);
		// TODO Auto-generated constructor stub
	}
	
	public void move(Vector2 pos){
		float dist = 0.5f;
		float parralax = (pos.x*dist)%dim.x;
		
		Vector2 offset = dim.cpy().scl(0.5f);
		Vector2 start = new Vector2((float)Math.floor(pos.x/dim.x)-1, (float)Math.floor(pos.y/dim.y)-1);
		for(int i = 0;i<3;i++){
			for(int j = 0;j<3;j++){
			imges.get((i*3)+j).pos.set((start.x+i)*dim.x-offset.x+parralax, (start.y+j)*dim.y-offset.y);
			}
		}
	}

	@Override
	public void draw(Batch b) {
		for(DisplayObject d: imges){
			d.draw(b);
		}
	}

}
