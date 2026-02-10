import java.awt.*;
import javax.swing.*;

class BackGround{
  int x,y;
  Image image;
  
  BackGround(){
    this.image = 	
      new ImageIcon("background.jpg").getImage();
  }
  void draw(){
    Game.canvas.drawImage(this.image,
                          0,
                          0,
                          Game.width, //img width
                          Game.height,//img height
                          null);   
  }
}