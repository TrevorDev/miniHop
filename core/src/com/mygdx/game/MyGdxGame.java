package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;

import fgdx.Device;

public class MyGdxGame extends ApplicationAdapter {
	Device d;
	@Override
	public void create () {
		GameData.init();
		d = new Device();
		d.setScreen(new MenuScreen(d));
	}

	@Override
	public void render () {
		d.render();
	}
	
	@Override
	public void dispose () {
		GameData.save();
	}
	
	@Override
	public void pause () {
		GameData.save();
	}
}
