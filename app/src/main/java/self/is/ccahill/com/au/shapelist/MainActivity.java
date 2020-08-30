package self.is.ccahill.com.au.shapelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    public static ArrayList<Shape> shapeList = new ArrayList<Shape>();

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupData();
        setUpList();
        setUpOnclickListener();
    }

    private void setupData()
    {
        Shape circle = new Shape("0", "Circle", R.drawable.circle);
        shapeList.add(circle);

        Shape triangle = new Shape("1","Triangle", R.drawable.triangle);
        shapeList.add(triangle);

        Shape square = new Shape("2","Square", R.drawable.square);
        shapeList.add(square);

        Shape rectangle = new Shape("3","Rectangle", R.drawable.rectangle);
        shapeList.add(rectangle);

        Shape octagon = new Shape("4","Octagon", R.drawable.octagon);
        shapeList.add(octagon);

        Shape circle2 = new Shape("5", "Circle 2", R.drawable.circle);
        shapeList.add(circle2);

        Shape triangle2 = new Shape("6","Triangle 2", R.drawable.triangle);
        shapeList.add(triangle2);

        Shape square2 = new Shape("7","Square 2", R.drawable.square);
        shapeList.add(square2);

        Shape rectangle2 = new Shape("8","Rectangle 2", R.drawable.rectangle);
        shapeList.add(rectangle2);

        Shape octagon2 = new Shape("9","Octagon 2", R.drawable.octagon);
        shapeList.add(octagon2);
    }

    private void setUpList()
    {
        listView = (ListView) findViewById(R.id.shapesListView);

        ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, shapeList);
        listView.setAdapter(adapter);
    }

    private void setUpOnclickListener()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Shape selectShape = (Shape) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), DetailActivity.class);
                showDetail.putExtra("id",selectShape.getId());
                startActivity(showDetail);
            }
        });

    }

}