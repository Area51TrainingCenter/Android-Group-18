package com.jcodee.sliding;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.jcodee.fragments.DosFragment;
import com.jcodee.fragments.TresFragment;
import com.jcodee.fragments.UnoFragment;
import com.jcodee.niv1mod2class2.MainActivity;
import com.jcodee.niv1mod2class2.R;

/**
 * Created by johannfjs on 05/12/2015.
 */
public class SampleListFragment extends ListFragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list, null);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SampleAdapter adapter = new SampleAdapter(getActivity());
        //for (int i = 0; i < 20; i++) {
        adapter.add(new SampleItem("Formulario 1", android.R.drawable.ic_menu_search));
        adapter.add(new SampleItem("Formulario 2", android.R.drawable.ic_menu_search));
        adapter.add(new SampleItem("Formulario 3", android.R.drawable.ic_menu_search));
        //}
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new UnoFragment();
                break;
            case 1:
                fragment = new DosFragment();
                break;
            case 2:
                fragment = new TresFragment();
                break;
        }
        if (fragment != null) {
            switchFragment(fragment);
        }
    }

    private void switchFragment(Fragment fragment) {
        if (getActivity() == null)
            return;

        if (getActivity() instanceof MainActivity) {
            MainActivity fca = (MainActivity) getActivity();
            fca.switchContent(fragment);
        }
    }

    private class SampleItem {
        public String tag;
        public int iconRes;

        public SampleItem(String tag, int iconRes) {
            this.tag = tag;
            this.iconRes = iconRes;
        }
    }

    public class SampleAdapter extends ArrayAdapter<SampleItem> {

        public SampleAdapter(Context context) {
            super(context, 0);
        }

        class ViewHolder {
            ImageView icon;
            TextView title;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, null);

                viewHolder = new ViewHolder();
                viewHolder.icon = (ImageView) convertView.findViewById(R.id.row_icon);
                viewHolder.title = (TextView) convertView.findViewById(R.id.row_title);
                convertView.setTag(viewHolder);
            }

            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.icon.setImageResource(getItem(position).iconRes);
            viewHolder.title.setText(getItem(position).tag);

            return convertView;
        }

    }
}
