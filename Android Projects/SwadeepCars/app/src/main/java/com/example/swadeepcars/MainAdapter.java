package com.example.swadeepcars;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;


public class MainAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listdataheader;
    private HashMap<String,List<String>> listhashmap;

    public MainAdapter(Context context, List<String> listdataheader, HashMap<String, List<String>> listhashmap)
    {
        this.context = context;
        this.listdataheader = listdataheader;
        this.listhashmap = listhashmap;
    }

    @Override
    public int getGroupCount()
    {
        return listdataheader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition)
    {
        return listhashmap.get(listdataheader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition)
    {
        return listdataheader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition)
    {
        return listhashmap.get(listdataheader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition)
    {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition)
    {
        return childPosition;
    }

    @Override
    public boolean hasStableIds()
    {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
    {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.parent_list,null);
        }
        TextView initListHeader = convertView.findViewById(R.id.parent_list);
        initListHeader.setText(headerTitle);
        return convertView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
    {
        String headerTitle = (String) getChild(groupPosition,childPosition);
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_list,null);
        }
        TextView initListHeader = convertView.findViewById(R.id.child_list);
        initListHeader.setText(headerTitle);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
