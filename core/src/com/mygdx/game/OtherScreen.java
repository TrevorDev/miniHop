package com.mygdx.game;

import fgdx.Device;
import fgdx.Screen;

public class OtherScreen extends Screen {

	public OtherScreen(Device d) {
		super(d);
	}
	
	public void render(){
		this.device.startDraw();
		this.device.endDraw();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
