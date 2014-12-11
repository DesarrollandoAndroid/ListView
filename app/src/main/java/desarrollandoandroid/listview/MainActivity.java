package desarrollandoandroid.listview;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Creado por Pablo Bascuñana Saiz el 5/12/14.
 */
public class MainActivity extends ActionBarActivity {

    ListView mListView;
    ArrayList<Almacen> mDatos;
    Almacen mAlmacen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.listView);
        mDatos = new ArrayList<Almacen>();

        mAlmacen = new Almacen (getResources().getDrawable(R.drawable.africa),
                                getResources().getString(R.string.tit1),
                                getResources().getString(R.string.subtitulo));
        mDatos.add(mAlmacen);
        mAlmacen = new Almacen (getResources().getDrawable(R.drawable.spain),
                                getResources().getString(R.string.tit2),
                                getResources().getString(R.string.subtitulo));
        mDatos.add(mAlmacen);
        mAlmacen = new Almacen (getResources().getDrawable(R.drawable.mexico),
                                getResources().getString(R.string.tit3),
                                getResources().getString(R.string.subtitulo));
        mDatos.add(mAlmacen);
        mAlmacen = new Almacen (getResources().getDrawable(R.drawable.belgium),
                                getResources().getString(R.string.tit4),
                                getResources().getString(R.string.subtitulo));
        mDatos.add(mAlmacen);
        mAlmacen = new Almacen (getResources().getDrawable(R.drawable.thailand),
                                getResources().getString(R.string.tit5),
                                getResources().getString(R.string.subtitulo));
        mDatos.add(mAlmacen);
        mAlmacen = new Almacen (getResources().getDrawable(R.drawable.germany),
                                getResources().getString(R.string.tit6),
                                getResources().getString(R.string.subtitulo));
        mDatos.add(mAlmacen);
        mAlmacen = new Almacen (getResources().getDrawable(R.drawable.usa),
                                getResources().getString(R.string.tit7),
                                getResources().getString(R.string.subtitulo));
        mDatos.add(mAlmacen);
        mAlmacen = new Almacen (getResources().getDrawable(R.drawable.china),
                                getResources().getString(R.string.tit8),
                                getResources().getString(R.string.subtitulo));
        mDatos.add(mAlmacen);
        mAlmacen = new Almacen (getResources().getDrawable(R.drawable.italy),
                                getResources().getString(R.string.tit9),
                                getResources().getString(R.string.subtitulo));
        mDatos.add(mAlmacen);
        mAlmacen = new Almacen (getResources().getDrawable(R.drawable.canada),
                                getResources().getString(R.string.tit10),
                                getResources().getString(R.string.subtitulo));
        mDatos.add(mAlmacen);


        final AlmacenAdapter mAdapter = new AlmacenAdapter(this, mDatos);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String texto = getResources().getString(R.string.textoToast) + (
                        (Almacen)parent.getAdapter().getItem(position)).getTitulo();
                Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class AlmacenAdapter extends ArrayAdapter<Almacen>{

        Activity mContext;
        ArrayList<Almacen> mItems;

        AlmacenAdapter(Activity context, ArrayList<Almacen> items) {
            super(context, R.layout.elementoslista_layout, mDatos);
            this.mContext = context;
            this.mItems = items;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View mItem = convertView;
            ViewHolder mHolder;

            if (mItem == null) {
                LayoutInflater mInflater = LayoutInflater.from(getContext());
                mItem = mInflater.inflate(R.layout.elementoslista_layout, null);

                mHolder = new ViewHolder();
                mHolder.mImage = (ImageView) mItem.findViewById(R.id.imagen);
                mHolder.mTitulo = (TextView) mItem.findViewById(R.id.titulo);
                mHolder.mSubtitulo = (TextView) mItem.findViewById(R.id.subtitulo);

                mItem.setTag(mHolder);
            }
            else {
                mHolder = (ViewHolder) mItem.getTag();
            }

            mHolder.mImage.setImageDrawable(mItems.get(position).getImagen());
            mHolder.mTitulo.setText(mItems.get(position).getTitulo());
            mHolder.mSubtitulo.setText(mItems.get(position).getSubtitulo());

/* ListView I */
           // LayoutInflater mInflater = LayoutInflater.from(getContext());
           // View mItem = mInflater.inflate(R.layout.elementoslista_layout, null);

           //ImageView mImagen = (ImageView) mItem.findViewById(R.id.imagen);
           //mImagen.setImageDrawable(mItems.get(position).getImagen());

           // TextView mTituloText = (TextView) mItem.findViewById(R.id.titulo);
           // mTituloText.setText(mItems.get(position).getTitulo());

           // TextView mSubtituloText = (TextView) mItem.findViewById(R.id.subtitulo);
           // mSubtituloText.setText(mItems.get(position).getSubtitulo());

            return mItem;
        }

        public class ViewHolder {
            ImageView mImage;
            TextView mTitulo;
            TextView mSubtitulo;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
