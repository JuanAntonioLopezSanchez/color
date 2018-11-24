package mx.edu.iitepic.damd_u3_ejercicio5_color;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Imagen3 {

    Bitmap icono;
    float x,y;
    boolean visible;

    public Imagen3(int recurso, float _x, float _y, Lienzo3 l){

        icono = BitmapFactory.decodeResource(l.getResources(),recurso);
        x=_x;
        y=_y;

        visible = true;
    }

    public  void pintar (Canvas c, Paint p){
        if (visible){
            c.drawBitmap(icono,x,y,p);
        }
    }

    public void hacerVisible(boolean v){
        visible = v;
    }

    public boolean estaEnArea(float xp, float yp){
        float x2, y2;

        if (!visible){
            return false;
        }

        x2 = x + icono.getWidth();
        y2 = y + icono.getHeight();

        if(xp>=x && xp<=x2){
            if(yp>=y && yp<=y2){
                return true;
            }
        }
        return false;
    }

    public void mover (float xp, float yp){
        x = xp - (icono.getWidth()/2);
        y = yp - (icono.getHeight()/2);
    }

    public boolean colision(Imagen3 objetoB){

        float x2 = x + icono.getWidth();
        float y2 = y + icono.getHeight();

        if(objetoB.estaEnArea(x2,y)){
            return true;
        }

        if(objetoB.estaEnArea(x,y)){
            //Revisando caso 2
            return true;
        }

        if(objetoB.estaEnArea(x2,y2)){
            //Revisando caso 3
            return true;
        }

        if(objetoB.estaEnArea(x,y2)){
            //Revisando caso 4
            return true;
        }

        return false;
    }
}
