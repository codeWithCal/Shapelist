package self.is.ccahill.com.au.shapelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity
{
    Shape selectedShape;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSelectedShape();
        setValues();

    }

    private void getSelectedShape()
    {
        Intent previousIntent = getIntent();
        String parsedStringID = previousIntent.getStringExtra("id");
        selectedShape = getParsedShape(parsedStringID);
    }

    private Shape getParsedShape(String parsedID)
    {
        for (Shape shape : MainActivity.shapeList)
        {
            if(shape.getId().equals(parsedID))
                return shape;
        }
        return null;
    }

    private void setValues()
    {
        TextView tv = (TextView) findViewById(R.id.shapeName);
        ImageView iv = (ImageView) findViewById(R.id.shapeImage);

        tv.setText(selectedShape.getId() + " - " + selectedShape.getName());
        iv.setImageResource(selectedShape.getImage());
    }
}