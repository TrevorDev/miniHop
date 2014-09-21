package com.mygdx.game;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import fgdx.Device;
import fgdx.Screen;

public class LevelScreen extends Screen{
	Background bg;
	public Ground ground;
	Player p;
	HUD h;
	
	public int lastPos = 0;
	public LevelScreen(final Device d) {
		super(d);
		
		h = new HUD(this);
		bg = new Background(this, new Texture("bg/blue_land.png"));
		ground = new Ground(new Vector2(0,-280), new Vector2(100,40));
		p = new Player(this, new Vector2(0,0), new Vector2(40,40));
	}

	public void render(){
		//b.pos.x++;
		
		p.move();
		Camera c = this.device.stage.getCamera();
		
		c.position.x = Math.round(p.pos.x+400);
		c.update();
		//exp
		if(lastPos!=0){
			int change = (int) c.position.x-lastPos;
			GameData.addExp(change);
		}
		lastPos = (int) c.position.x;
		
		
		
		ground.move(c.position.x);
		bg.move(new Vector2(c.position.x, c.position.y));
		this.device.startDraw();
		this.device.draw(bg);
		this.device.draw(p);
		this.device.draw(ground);
		this.device.draw(h);
		this.device.endDraw();
	}

	@Override
	public void dispose() {
		p.dispose();
		// TODO Auto-generated method stub
		
	}
	
}
