package focus.madhav.practcie.com.expandalelistfooditems;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by madhav on 7/27/2017.
 */

public class MyExpandableAdapter extends BaseExpandableListAdapter
{
    int[] drawableIds={R.drawable.peach,R.drawable.juice,R.drawable.fried_egg,R.drawable.pizza_slice,R.drawable.desert,R.drawable.chicken_leg,R.drawable.cocktail};
   int subDrawables[]={R.drawable.sub_fruits,R.drawable.sub_juice,R.drawable.sub_breakfast,R.drawable.sub_pizza,R.drawable.sub_pint,R.drawable.sub_chicken_leg,R.drawable.sub_pint};
    private final HashMap<String, List<String>> foodItems;
    private final Context context;
    private final ArrayList<String> foodHeader;

    public MyExpandableAdapter(Context context, ArrayList<String> foodHeader, HashMap<String, List<String>> footItems)
    {
        this.context=context;
        this.foodHeader=foodHeader;
        this.foodItems=footItems;
    }

    @Override
    public int getGroupCount() {
        return foodHeader.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return foodItems.get(foodHeader.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return foodHeader.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return foodItems.get(foodHeader.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup)
    {

        String headerTitle = (String) getGroup(i);
        LinearLayout linearLayout=new LinearLayout(context);
        linearLayout.setBackgroundColor(Color.WHITE);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,200));
        ImageView imageView=new ImageView(context);
        imageView.setImageResource(drawableIds[i]);
        imageView.setId(R.id.food_image);
        imageView.setPadding(10,10,10,10);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.addView(imageView);
        TextView textView=new TextView(context);
        RelativeLayout.LayoutParams params=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_VERTICAL);
        textView.setPadding(20,60,0,0);
        params.addRule(RelativeLayout.RIGHT_OF,R.id.food_image);
        textView.setTextSize(18f);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setTextColor(Color.BLACK);
        textView.setLayoutParams(params);
        linearLayout.addView(textView);
        textView.setText(headerTitle);
        return linearLayout;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup)
    {
        final String childText = (String) getChild(i, i1);
        RelativeLayout relativeLayout=new RelativeLayout(context);
        relativeLayout.setBackgroundColor(Color.parseColor("#F5F5F5"));
        relativeLayout.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,300));

        ImageView imageView=new ImageView(context);
        imageView.setImageResource(subDrawables[i]);
        imageView.setId(R.id.food_item_price_image);
        imageView.setPadding(50,10,20,10);
        RelativeLayout.LayoutParams imageparams=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        imageView.setLayoutParams(imageparams);
        imageparams.addRule(RelativeLayout.CENTER_VERTICAL);
        relativeLayout.addView(imageView);
        TextView textView=new TextView(context);
        textView.setId(R.id.food_name);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(16f);
        RelativeLayout.LayoutParams textParams=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textParams.addRule(RelativeLayout.RIGHT_OF,R.id.food_item_price_image);
        textParams.addRule(RelativeLayout.CENTER_VERTICAL);
        textView.setLayoutParams(textParams);
        relativeLayout.addView(textView);
        textView.setText(childText);

        TextView price=new TextView(context);
        price.setText("₹75");
        price.setTextColor(Color.GRAY);
        RelativeLayout.LayoutParams priceParams=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        priceParams.addRule(RelativeLayout.BELOW,R.id.food_name);
        priceParams.addRule(RelativeLayout.RIGHT_OF,R.id.food_item_price_image);
        price.setLayoutParams(priceParams);
        relativeLayout.addView(price);
        Button add=new Button(context);
        add.setText("ADD");
        RelativeLayout.LayoutParams addParams=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//        addParams.addRule(RelativeLayout.ALIGN_END);
        addParams.addRule(RelativeLayout.CENTER_VERTICAL);
        addParams.setMargins(0,0,20,0);
//        addParams.addRule(RelativeLayout.ALIGN_PARENT_END);
        add.setBackgroundColor(Color.parseColor("#77A88F"));
        add.setLayoutParams(addParams);
        relativeLayout.addView(add);
        return relativeLayout;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }


}
