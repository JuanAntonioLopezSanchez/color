package mx.edu.iitepic.damd_u3_ejercicio5_color;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo2 extends View {

    Imagen2 negro, azul, verde, naranja, amarillo, gris, puntero, regrsar;
    String mensaje;
    MediaPlayer player;
    Main2Activity puntero2;


    public Lienzo2 (Context context){
        super(context);

        naranja = new Imagen2(R.drawable.naranja, 20, 500, this);
        verde = new Imagen2(R.drawable.verde, 600, 500, this);
        gris = new Imagen2(R.drawable.gris,1210 , 500, this);

        amarillo = new Imagen2(R.drawable.amarillo, 600, 200, this);
        azul = new Imagen2(R.drawable.azul,1210 , 200, this);

        negro = new Imagen2(R.drawable.negro, 20, 200, this);


        regrsar = new Imagen2(R.drawable.regresar2, 700, 1700, this);

        puntero2 = (Main2Activity) context;
        mensaje = "Toca el color y escucha audio";
        puntero = null;

    }

    protected void onDraw(Canvas c){
        super.onDraw(c);

        Paint p = new Paint();
        negro.pintar(c,p);
        amarillo.pintar(c,p);
        azul.pintar(c,p);
        naranja.pintar(c,p);
        verde.pintar(c,p);
        gris.pintar(c,p);
        regrsar.pintar(c,p);
        p.setTextSize(50);
        p.setColor(Color.BLUE);
        c.drawText(mensaje,100,100,p);




    }

    public  boolean onTouchEvent (MotionEvent e){

        float xp = e.getX();
        float yp = e.getY();

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:

                if (naranja.estaEnArea(xp,yp)){
                    mensaje = "Naranja";
                    puntero = naranja;
                    player = MediaPlayer.create(puntero2, R.raw.orgen_na);
                    player.start();

                }

                if (azul.estaEnArea(xp,yp)){
                    mensaje = "Azul";
                    puntero = azul;
                    player = MediaPlayer.create(puntero2, R.raw.blue_a);
                    player.start();

                }

                if (amarillo.estaEnArea(xp,yp)){
                    mensaje = "Amarillo";
                    puntero = amarillo;
                    player = MediaPlayer.create(puntero2, R.raw.yellow_am);
                    player.start();

                }
                if (negro.estaEnArea(xp,yp)){
                    mensaje = "Negro";
                    puntero = negro;
                    player = MediaPlayer.create(puntero2, R.raw.black_n);
                    player.start();
                }


                if (gris.estaEnArea(xp,yp)){
                    mensaje = "Gris";
                    puntero = gris;
                    player = MediaPlayer.create(puntero2, R.raw.gray_g1);
                    player.start();
                }

                if (verde.estaEnArea(xp,yp)){
                    mensaje = "Verde";
                    puntero = verde;
                    player = MediaPlayer.create(puntero2, R.raw.green_v);
                    player.start();

                }


                if(regrsar.estaEnArea(xp,yp)){
                    puntero = regrsar;
                    regresarHome();
                }
                break;

            case MotionEvent.ACTION_MOVE:
                break;

            case MotionEvent.ACTION_UP:
                puntero = null;
                break;
        }

        invalidate();
        return true;
    }

    private void regresarHome() {

        Intent pantallaUno = new Intent(puntero2, MainActivity.class);
        puntero2.startActivity(pantallaUno);

    }
}
