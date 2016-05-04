package johannpolania.com.colombiaturistica3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by koanco on 24/04/2016.
 */
public class DrawerListAdapter extends ArrayAdapter {


    public DrawerListAdapter(Context context, List objects) {
        super(context,0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater)parent.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_lista, null);



        }

        ImageView icon=(ImageView)convertView.findViewById(R.id.icono);
        TextView descripcion=(TextView)convertView.findViewById(R.id.tOpcion);
        DrawerItem item =(DrawerItem) getItem(position);
        icon.setImageResource(item.getIcono());
        descripcion.setText(item.getOpcion());
        return convertView;
    }
}
