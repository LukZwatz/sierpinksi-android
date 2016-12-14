package at.fh.swengb.sierpinski_android

import android.content.Context
import android.graphics.{Canvas, Color, Paint, Path}
import android.util.AttributeSet
import android.view.View

/**
  * Created by Lukas on 13.12.2016.
  */
class Triangle (val context: Context, val attrs: AttributeSet) extends View(context,attrs){

  override protected def onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    val paint=new Paint();

    paint.setColor(Color.BLACK);
    paint.setStrokeWidth(5);
    val x = canvas.getWidth;
    val height = (Math.sqrt(3)/2*x).toFloat

    zeichneSierpinski(0,0,x,height)

    def zeichneSierpinski(x:Float,y:Float,w:Float,h:Float): Unit ={
      zeichneDreieck(x,y,w,h)

      if (w < 1){
        return
      }
      else {
        var h2 = h / 2;
        var w2 = w / 2;
        zeichneSierpinski(x, y, w2, h2);
        zeichneSierpinski(x + w2/2, y + h2, w2, h2);
        zeichneSierpinski(x + w2, y, w2, h2);

      }
    }

    def zeichneDreieck(x:Float,y:Float,w:Float,h:Float): Unit ={
      canvas.drawLine(x,y,x+w,y,paint);
      canvas.drawLine(x,y,x+(w/2),y+h,paint);
      canvas.drawLine(x+w,y,+x+(w/2),y+h,paint);
    }



    /*
    canvas.drawLine(0,0,x,0,paint);
    canvas.drawLine(0,0,x/2,height,paint);
    canvas.drawLine(x/2,height,x,0,paint);

    canvas.drawLine(x/4,height/2,3*x/4,height/2,paint);
    canvas.drawLine(x/4,height/2,x/2,0,paint);
    canvas.drawLine(x/2,0,3*x/4,height/2,paint);
*/


    }




}
