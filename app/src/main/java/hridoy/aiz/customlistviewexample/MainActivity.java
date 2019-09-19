package hridoy.aiz.customlistviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvProduct;
    ArrayList<Product> plist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvProduct = (ListView) findViewById(R.id.lvProduct);
        plist = new ArrayList<Product>();

        Product p1 = new Product("Some","This is good","Laptop",33.54,false);
        Product p2 = new Product("Erop","This is Nice","Laptop",6465.844,true);
        Product p3 = new Product("Bjenka","Fne is good","Hard Drive",55,false);
        Product p4 = new Product("NIho","This arem good","",44.55,true);
        Product p5 = new Product("Amasho","This is ok","Memory",998.1,true);

        plist.add(p1);
        plist.add(p2);
        plist.add(p3);
        plist.add(p4);
        plist.add(p5);

        ProductAdapter adp = new ProductAdapter(this,plist);
        lvProduct.setAdapter(adp);

    }
}
