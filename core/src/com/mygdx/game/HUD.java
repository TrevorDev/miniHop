package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

import fgdx.DisplayObject;
import fgdx.Drawable;
import fgdx.Screen;
import fgdx.Text;

public class HUD implements Drawable{

	DisplayObject expBar;
	Screen scr;
	Text t;
	public HUD(Screen scr){
		this.scr = scr;
		t=new Text("Level: ", "1", "font/federal_0.png", "font/federal.fnt");
		t.pos.x=-scr.device.getScreenDim().x/2;
		t.pos.y=scr.device.getScreenDim().y/2-10;
		
		expBar = new DisplayObject(new Vector2(-scr.device.getScreenDim().x/2, scr.device.getScreenDim().y/2-5), new Vector2(0, 5), new Texture("color/blue.png"));
	}
	
	@Override
	public void draw(Batch b) {
		t.pos.add(scr.device.stage.getCamera().position.x,scr.device.stage.getCamera().position.y);
		expBar.pos.add(scr.device.stage.getCamera().position.x,scr.device.stage.getCamera().position.y);
		expBar.dim.x = GameData.getExpPercent()*scr.device.getScreenDim().x;
		
		expBar.draw(b);
		t.update(GameData.getLevel()+"");
		t.draw(b);
		
		t.pos.sub(scr.device.stage.getCamera().position.x,scr.device.stage.getCamera().position.y);
		expBar.pos.sub(scr.device.stage.getCamera().position.x,scr.device.stage.getCamera().position.y);
	}

}
