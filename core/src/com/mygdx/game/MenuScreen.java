package com.mygdx.game;

import java.util.concurrent.Callable;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import fgdx.Button;
import fgdx.Device;
import fgdx.Screen;

public class MenuScreen extends Screen{

	Button b;
	Background bg;
	
	public MenuScreen(final Device d) {
		super(d);
		bg = new Background(this, new Texture("bg/intro.png"));
		b = new ChangeScreenButton(this, new Vector2(0,0), new Vector2(200,70), new Texture("btn/start.png"), new Callable<Screen>() {
			   public Screen call() {
			        return (Screen)new LevelScreen(d);
			   }
			});
		b.pos.x = -b.dim.x/2;
		b.pos.y = -100;
		// TODO Auto-generated constructor stub
	}

	public void dispose(){
		b.dispose();
	}
	public void render(){
		//b.pos.x++;
		this.device.startDraw();
		this.device.draw(bg);
		this.device.draw(b);
		this.device.endDraw();
	}
}
