package fgdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class DisplayObject extends Rectangle implements Drawable {
	public Vector2 spd = new Vector2(0,0);
	public Sprite sprite;
	
	public DisplayObject(Vector2 pos, Vector2 dim, Texture t){
		sprite = new Sprite(t);
		this.dim.set(dim);
		this.pos.set(pos);
	}
	
	
	public void move(){
    	this.pos.add(spd);
    }
    
    public void draw(Batch b){
    	this.sprite.setPosition(pos.x, pos.y);
    	this.sprite.setSize(dim.x, dim.y);
    	this.sprite.draw(b);
    }
}
