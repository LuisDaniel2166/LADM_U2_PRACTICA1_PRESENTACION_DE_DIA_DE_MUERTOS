package com.example.ladm_u2_practica1_presentacion_de_dia_de_muertos

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.CountDownTimer
import android.view.View

class Lienzo(p:MainActivity): View(p){
    val principal = p
    val tumba = BitmapFactory.decodeResource(principal.resources,R.drawable.tumba_opt)
    val fant_der = BitmapFactory.decodeResource(principal.resources,R.drawable.fantasma_der)
    val fant_izq = BitmapFactory.decodeResource(principal.resources,R.drawable.fantasma_izq)
    var posX1 = 3000f
    var posY1 = 500f
    var imgFant1 = fant_izq
    var dirFantasmin1 = true
    var levFantasmin1 = true
    var posX2 = -800f
    var posY2 = 300f
    var imgFant2 = fant_der
    var dirFantasmin2 = false
    var levFantasmin2 = true

    val movFantasmin = object : CountDownTimer(300000,20){
        override fun onTick(p0: Long) {
            //Movimiento Fantasma1
            if (dirFantasmin1){
                posX1-=5
            }
            else{
                posX1+=5
            }
            if (levFantasmin1){
                posY1+=3
            }
            else{
                posY1-=3
            }
            if (posY1 < 450){
                levFantasmin1=true
            }
            if(posY1 > 650){
                levFantasmin1=false
            }
            if (posX1 < -200){
                imgFant1=fant_der
                dirFantasmin1=false
            }
            if (posX1 >3000){
                imgFant1=fant_izq
                dirFantasmin1=true
            }

            //Movimiento Fantasma 2
            if (dirFantasmin2){
                posX2-=3
            }
            else{
                posX2+=3
            }
            if (levFantasmin2){
                posY2+=2
            }
            else{
                posY2-=2
            }
            if (posY2 < 225){
                levFantasmin2=true
            }
            if(posY2 > 375){
                levFantasmin2=false
            }
            if (posX2 < -800){
                imgFant2=fant_der
                dirFantasmin2=false
            }
            if (posX2 >2400){
                imgFant2=fant_izq
                dirFantasmin2=true
            }
            invalidate()
        }

        override fun onFinish() {
            start()
        }
    }

    init {
        movFantasmin.start()
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p =Paint()
        c.drawColor(Color.BLACK)
        //Luna
        p.color = Color.WHITE
        c.drawCircle(200f, 150f, 90f, p)
        //Semi luna
        p.color = Color.BLACK
        c.drawCircle(250f, 100f, 75f, p)

        //Suelo
        p.color = Color.parseColor("#095616")
        c.drawOval(-100f,650f,2100f,1000f,p)
        //Contorno
        p.style = Paint.Style.STROKE
        p.strokeWidth = 20f
        p.color = Color.parseColor("#0B3913")
        c.drawOval(-100f,650f,2100f,1000f,p)
        //regresamos estilos
        p.style = Paint.Style.FILL

        //Arbol
        p.color = Color.parseColor("#734C0C")
        c.drawRect(215f, 650f, 285f, 800f, p)
        //Contorno arbol
        p.style = Paint.Style.STROKE
        p.strokeWidth = 8f
        p.color = Color.parseColor("#4C3003")
        c.drawRect(215f, 650f, 285f, 800f, p)
        //regresamos estilos
        p.style = Paint.Style.FILL
        //Hojas
        p.color = Color.parseColor("#C17C0D")
        c.drawOval(150f, 460f, 345f, 660f, p)
        //Contorno
        p.style = Paint.Style.STROKE
        p.strokeWidth = 8f
        p.color = Color.parseColor("#805715")
        c.drawOval(150f, 460f, 345f, 660f, p)
        //regresamos estilos
        p.style = Paint.Style.FILL

        //Arbol2
        p.color = Color.parseColor("#734C0C")
        c.drawRect(1715f, 650f, 1785f, 800f, p)
        //Contorno arbol
        p.style = Paint.Style.STROKE
        p.strokeWidth = 8f
        p.color = Color.parseColor("#4C3003")
        c.drawRect(1715f, 650f, 1785f, 800f, p)
        //regresamos estilos
        p.style = Paint.Style.FILL
        //Hojas
        p.color = Color.parseColor("#C17C0D")
        c.drawOval(1650f, 460f, 1845f, 660f, p)
        //Contorno
        p.style = Paint.Style.STROKE
        p.strokeWidth = 8f
        p.color = Color.parseColor("#805715")
        c.drawOval(1650f, 460f, 1845f, 660f, p)
        //regresamos estilos
        p.style = Paint.Style.FILL

        //Tumbas
        c.drawBitmap(tumba,500f,600f,p)
        c.drawBitmap(tumba,800f,600f,p)
        c.drawBitmap(tumba,1100f,600f,p)
        c.drawBitmap(tumba,1400f,600f,p)

        //Nube1
        p.color = Color.parseColor("#8A8A8A")
        c.drawOval(400f, 60f, 550f, 160f, p)
        c.drawOval(470f, 90f, 620f, 190f, p)
        c.drawOval(470f, 20f, 620f, 120f, p)
        c.drawOval(550f, 60f, 700f, 160f, p)

        //Nube2
        p.color = Color.parseColor("#8A8A8A")
        c.drawOval(1000f, 140f, 1150f, 240f, p)
        c.drawOval(1070f, 170f, 1220f, 270f, p)
        c.drawOval(1070f, 100f, 1220f, 200f, p)
        c.drawOval(1150f, 140f, 1300f, 240f, p)

        //Nube3
        p.color = Color.parseColor("#8A8A8A")
        c.drawOval(1700f, 70f, 1850f, 170f, p)
        c.drawOval(1770f, 90f, 1920f, 190f, p)
        c.drawOval(1770f, 30f, 1920f, 130f, p)
        c.drawOval(1850f, 70f, 2000f, 170f, p)

        //Fantasmin
        c.drawBitmap(imgFant1,posX1,posY1,p)
        c.drawBitmap(imgFant2,posX2,posY2,p)
    }
}