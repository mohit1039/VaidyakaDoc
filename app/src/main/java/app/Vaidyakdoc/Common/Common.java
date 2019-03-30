package app.Vaidyakdoc.Common;

import android.content.Context;
import android.widget.Toast;

import app.Vaidyakdoc.Model.Register;


public class Common {

   public static Register register ;

   public void createtoast(String s, Context context) {
      Toast.makeText(context,""+s,Toast.LENGTH_LONG).show();
   }
}
