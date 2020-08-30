package self.is.ccahill.com.au.shapelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    public static ArrayList<Shape> shapeList = new ArrayList<Shape>();

    private ListView listView;

    private String selectedFilter = "all";
    private String currentSearchText = "";
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSearchWidgets();
        setupData();
        setUpList();
        setUpOnclickListener();
    }

    private void initSearchWidgets()
    {
        searchView = (SearchView) findViewById(R.id.shapeListSearchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s)
            {
                currentSearchText = s;
                ArrayList<Shape> filteredShapes = new ArrayList<Shape>();

                for(Shape shape: shapeList)
                {
                    if(shape.getName().toLowerCase().contains(s.toLowerCase()))
                    {
                        if(selectedFilter.equals("all"))
                        {
                            filteredShapes.add(shape);
                        }
                        else
                            {
                                if(shape.getName().toLowerCase().contains(selectedFilter))
                                {
                                    filteredShapes.add(shape);
                                }
                            }
                    }
                }
                ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, filteredShapes);
                listView.setAdapter(adapter);

                return false;
            }
        });
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



    private void filterList(String status)
    {
        selectedFilter = status;

        ArrayList<Shape> filteredShapes = new ArrayList<Shape>();

        for(Shape shape: shapeList)
        {
            if(shape.getName().toLowerCase().contains(status))
            {
                if(currentSearchText == "")
                {
                    filteredShapes.add(shape);
                }
                else
                    {
                        if(shape.getName().toLowerCase().contains(currentSearchText.toLowerCase()))
                        {
                            filteredShapes.add(shape);
                        }
                    }
            }
        }

        ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, filteredShapes);
        listView.setAdapter(adapter);
    }




    public void allFilterTapped(View view)
    {
        selectedFilter = "all";

        ShapeAdapter adapter = new ShapeAdapter(getApplicationContext(), 0, shapeList);
        listView.setAdapter(adapter);
    }

    public void triangleFilterTapped(View view)
    {
        filterList("triangle");
    }

    public void squareFilterTapped(View view)
    {
        filterList("square");
    }

    public void octagonFilterTapped(View view)
    {
        filterList("octagon");
    }

    public void rectangleFilterTapped(View view)
    {
        filterList("rectangle");
    }

    public void circleFilterTapped(View view)
    {
        filterList("circle");
    }
}