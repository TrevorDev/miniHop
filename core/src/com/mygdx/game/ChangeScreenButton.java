package com.mygdx.game;

import java.util.concurrent.Callable;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import fgdx.Button;
import fgdx.Screen;

public class ChangeScreenButton extends Button{
	Callable<Screen> createScreen;
	public ChangeScreenButton(Screen s, Vector2 pos, Vector2 dim, Texture t, Callable<Screen> createScreen) {
		super(s, pos, dim, t);
		this.createScreen = createScreen;
		// TODO Auto-generated constructor stub
	}

	public void btnHit(){
		System.out.println("hit");
		try {
			this.scr.device.setScreen(createScreen.call());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
