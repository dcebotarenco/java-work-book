package Sierpinsky; 
import java.awt.*;
 import java.applet.*;
 
 public class Sierpinski extends Applet {
     private SimpleGraphics sg=null;
     private int dist0 = 128, dist;
 
     public void init() 
     {
         sg = new SimpleGraphics(getGraphics());
         dist0 = 128;
         resize ( 4*dist0, 4*dist0 );
     }
 
     public void paint(Graphics g) 
     {
         int level =6;
         dist = dist0;
         for (int i=level; i > 0; i--) dist /= 2;
         sg.goToXY(2*dist, dist);
         sierpA(level);        // start recursion
         sg.lineRel(+dist, +dist);
         sierpB(level);        // start recursion
         sg.lineRel(-dist, +dist);
         sierpC(level);        // start recursion
         sg.lineRel(-dist, -dist);
         sierpD(level);        // start recursion
         sg.lineRel(+dist, -dist);
     }
 
     private void sierpA (int level) 
     {
         if (level > 0) {
             sierpA(level-1);    sg.lineRel(+dist, +dist);
             sierpB(level-1);    sg.lineRel(+2*dist, 0);
             sierpD(level-1);    sg.lineRel(+dist, -dist);
             sierpA(level-1);
         }
     }
 
     private void sierpB (int level) 
     {
         if (level > 0) {
             sierpB(level-1);    sg.lineRel(-dist, +dist);
             sierpC(level-1);    sg.lineRel(0, +2*dist);
             sierpA(level-1);    sg.lineRel(+dist, +dist);
             sierpB(level-1);
         }
     }
 
     private void sierpC (int level) 
     {
         if (level > 0) {
             sierpC(level-1);    sg.lineRel(-dist, -dist);
             sierpD(level-1);    sg.lineRel(-2*dist, 0);
             sierpB(level-1);    sg.lineRel(-dist, +dist);
             sierpC(level-1);
         }
     }
 
     private void sierpD (int level) 
     {
         if (level > 0) {
             sierpD(level-1);    sg.lineRel(+dist, -dist);
             sierpA(level-1);    sg.lineRel(0, -2*dist);
             sierpC(level-1);    sg.lineRel(-dist, -dist);
             sierpD(level-1);
         }
     }
 }
 
 class SimpleGraphics 
 {
     private Graphics g = null;
     private int x = 0, y = 0;    
 
     public SimpleGraphics(Graphics g) { this.g = g; }
     public void goToXY(int x, int y) { this.x = x;   this.y = y; }
 
     public void lineRel(int deltaX, int deltaY) {
         g.drawLine ( x, y, x+deltaX, y+deltaY );
         x += deltaX;    y += deltaY;
     }
 }