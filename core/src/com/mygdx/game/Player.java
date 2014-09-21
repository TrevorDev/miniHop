package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import fgdx.DisplayObject;
import fgdx.TouchListener;

public class Player extends DisplayObject implements TouchListener{
	boolean touchDown = false;
	LevelScreen scr;
	float jumpHeight = 20;
	float xSpdPower = 20;
	float maxSpd = 5;
	float runAcc = 1f;
	float gravity = 0.40f;
	int maxJumps = 1;
	int jumps = maxJumps;
	Vector2 origDim;
	boolean grounded = false;
	public Player(LevelScreen scr, Vector2 pos, Vector2 dim) {
		super(pos, dim, new Texture("char/player.png"));
		this.scr = scr;
		origDim = dim.cpy();
		scr.device.input.addListener(this);
	}

	
	@Override
	public void move(){
		if(grounded){
			this.spd.x *= 0.95;
			if(touchDown){
				if(this.dim.y > origDim.y*0.1){
					this.dim.y*=0.95;
				}
				
			}else{
				if(this.dim.y!=origDim.y){
					float newX = xSpdPower*this.dim.y/origDim.y;
					if(newX>this.spd.x){
						this.spd.x=newX;
					}
					this.spd.y = jumpHeight*(1-this.dim.y/origDim.y);
					this.dim.y=origDim.y;
				}
			}
		}
		
		
		this.spd.y -= 0.3;
		
		Vector2 origNextPos = this.pos.cpy().add(this.spd);
		Vector2 nextPlayerPos = origNextPos.cpy();
		for(DisplayObject w:this.scr.ground.walls){
			nextPlayerPos = this.adjustMoveCollision(w, nextPlayerPos);
		}
		Vector2 adjustment = nextPlayerPos.cpy().sub(origNextPos);
		grounded=false;
		if((adjustment.y < 0 && this.spd.y > 0)||(adjustment.y > 0 && this.spd.y < 0)){
			if(adjustment.y > 0){
				grounded = true;
			}
			
			this.spd.y=0;
		}
		this.pos.set(nextPlayerPos);
		this.pos.x = Math.round(this.pos.x);
		//this.pos.y = Math.round(this.pos.y);
    }


	@Override
	public void touchDown(Vector2 pos, int pointer, int button) {
		touchDown=true;
	}


	@Override
	public void touchUp(Vector2 pos, int pointer, int button) {
		touchDown=false;
		// TODO Auto-generated method stub
		
	}


	@Override
	public void touchDrag(Vector2 pos, int pointer) {
		// TODO Auto-generated method stub
		
	}
	
	public void dispose(){
		scr.device.input.removeListener(this);
	}
}
