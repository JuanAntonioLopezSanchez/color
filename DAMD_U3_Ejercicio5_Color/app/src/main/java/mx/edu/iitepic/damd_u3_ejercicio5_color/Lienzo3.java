package mx.edu.iitepic.damd_u3_ejercicio5_color;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo3 extends View {

    Imagen3 colnara, colverde, colrazul, nomnaranja, nomverde, nomazul,  regresar ,puntero;
    String mensaje;
    Main3Activity punero2;

    public Lienzo3 (Context context){
        super(context);


        colnara = new Imagen3(R.drawable.cua_naranja02, 100, 250, this);
        nomverde = new Imagen3(R.drawable.verde1, 1050, 250, this);

        colrazul = new Imagen3(R.drawable.cua_azul01, 100, 850, this);
        nomnaranja = new Imagen3(R.drawable.naranja1, 1050, 850,this);

        colverde = new Imagen3(R.drawable.cua_verde03, 100, 1450,this);
        nomazul = new Imagen3(R.drawable.azul1, 1050, 1450, this);

        regresar = new Imagen3(R.drawable.regresar2, 700, 1900, this);

        mensaje = "Arrastra el texto al color que corresponde";


    }

    protected void onDraw(Canvas c){
        super.onDraw(c);
        Paint p = new Paint();

        p.setTextSize(100);
        p.setColor(Color.BLUE);
        c.drawText(mensaje, 50, 100,p);

        nomverde.pintar(c,p);
        nomnaranja.pintar(c,p);
        nomazul.pintar(c,p);

        colnara.pintar(c,p);
        colrazul.pintar(c,p);
        colverde.pintar(c,p);

        regresar.pintar(c,p);

    }

    public boolean onTouchEvent(MotionEvent e){
        float xp = e.getX();
        float yp = e.getY();


        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (nomnaranja.estaEnArea(xp, yp)){
                    mensaje = "NARANJA";
                    puntero = nomnaranja;
                }
                if (nomazul.estaEnArea(xp, yp)){
                    mensaje = "AZUL";
                    puntero = nomazul;
                }
                if (nomverde.estaEnArea(xp, yp)){
                    mensaje = "VERDE";
                    puntero = nomverde;
                }
                if(regresar.estaEnArea(xp,yp)){
                    puntero = regresar;
                    regresarHome();
                }
                break;

            case MotionEvent.ACTION_MOVE:
                if (puntero!=null){
                    puntero.mover(xp, yp);
                    if(puntero.colision(colverde) && puntero == nomverde){
                        mensaje ="Correcto, VERDE";
                        colverde.hacerVisible(false);
                        nomverde.hacerVisible(false);
                    }

                    if(puntero.colision(colrazul) && puntero == nomazul){
                        mensaje ="Correcto, AZUL";
                        colrazul.hacerVisible(false);
                        nomazul.hacerVisible(false);
                    }

                    if(puntero.colision(colnara) && puntero == nomnaranja){
                        mensaje ="Correcto, NARANJA";
                        colnara.hacerVisible(false);
                        nomnaranja.hacerVisible(false);
                    }



                }
                break;

            case MotionEvent.ACTION_UP:
                puntero = null;
                break;
        }
        invalidate();
        return true;

    }

    private void regresarHome() {

        Intent pantallaInicio = new Intent(punero2,MainActivity.class);
        punero2.startActivity(pantallaInicio);

    }

}
