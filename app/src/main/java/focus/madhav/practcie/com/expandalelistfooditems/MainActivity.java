package focus.madhav.practcie.com.expandalelistfooditems;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> foodHeader;
    HashMap<String,List<String>> footItems;
    ExpandableListView expandableListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(Color.parseColor("#2b126e"));
        }
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM|ActionBar.DISPLAY_SHOW_HOME);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(getMyToolBar());
        GradientDrawable gradientDrawable=new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM,new int[]{0xFF5C3C9D,0xFF5C3C9D});
        gradientDrawable.setCornerRadius(0);
        actionBar.setBackgroundDrawable(gradientDrawable);
        actionBar.setElevation(24f);
        actionBar.show();

        setContentView(getExpandableListItems());

    }

    public View getExpandableListItems()
    {
        LinearLayout mainLinearLayout=new LinearLayout(this);
        mainLinearLayout.setOrientation(LinearLayout.VERTICAL);
        mainLinearLayout.setBackgroundColor(Color.parseColor("#5C3C9D"));
        LinearLayout.LayoutParams mainParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mainLinearLayout.setLayoutParams(mainParams);
        prepareData();
       expandableListView=new ExpandableListView(this);
        expandableListView.setPadding(40,40,40,40);
        expandableListView.setMinimumHeight(40);
        expandableListView.setBackgroundColor(Color.parseColor("#5C3C9D"));
        ExpandableListView.LayoutParams layoutParams=new ExpandableListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        expandableListView.setLayoutParams(layoutParams);
        MyExpandableAdapter myExpandableAdapter=new MyExpandableAdapter(this,foodHeader,footItems);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if(groupPosition != previousGroup)
                    expandableListView.collapseGroup(previousGroup);
                previousGroup = groupPosition;
            }
        });
        expandableListView.setAdapter(myExpandableAdapter);
        mainLinearLayout.addView(expandableListView);
        return mainLinearLayout;
    }

    private void prepareData()
    {
        foodHeader=new ArrayList<String>();
        footItems=new HashMap<String, List<String>>();

        foodHeader.add("Fresh fruits");
        foodHeader.add("Fruit juices");
        foodHeader.add("Egg Items");
        foodHeader.add("Pizzas");
        foodHeader.add("deserts");
        foodHeader.add("chicken Items");
        foodHeader.add("Beverages");

        List<String> fruitItems=new ArrayList<String>();
        fruitItems.add("Apple");
        fruitItems.add("Stawbeery");
        fruitItems.add("peach");
        fruitItems.add("Oraange");
        fruitItems.add("Grape");
        fruitItems.add("Pear");
        fruitItems.add("Cherry");
        fruitItems.add("Banana");
        fruitItems.add("Pineapple");
        fruitItems.add("GrapeFruit");
        fruitItems.add("Mango");
        fruitItems.add("kiwi");
        fruitItems.add("lemon");
        fruitItems.add("Waterlemon");
        fruitItems.add("avacado");
        fruitItems.add("Papaya");





        List<String> juiceItems=new ArrayList<String>();
        juiceItems.add("Grape juice");
        juiceItems.add("Tomato juice");
        juiceItems.add("mango juice");
        juiceItems.add("Grape juice");
        juiceItems.add("carooot juice");
        juiceItems.add("Orange juice");
        juiceItems.add("coconut water");
        juiceItems.add("Apple juice");



        List<String> eggItems=new ArrayList<String>();
        eggItems.add("Boiled egg");
        eggItems.add("Omlet");
        eggItems.add("poached egg");
        eggItems.add("Scramblled egg");
        eggItems.add("Basted egg");
        eggItems.add("Shridded egg");
        eggItems.add("Balut");
        eggItems.add("Brike");
        eggItems.add("Century egg");
        eggItems.add("Chinese egg");

        List<String> pizzaItems=new ArrayList<String>();
        pizzaItems.add("Panner pizza");
        pizzaItems.add("Egg pizza");
        pizzaItems.add("mutton pizza");
        pizzaItems.add("veg pizza");
        pizzaItems.add("fruit pizza");
        pizzaItems.add("Mix pizza");
        pizzaItems.add("Damured pizza");
        pizzaItems.add("Chinese pizza");


        List<String> desertItems=new ArrayList<String>();
        desertItems.add("Desert cake");
        desertItems.add("Ginger bread");
        desertItems.add("Ice cream");
        desertItems.add("Sponge cake");
        desertItems.add("Doughnuts");
        desertItems.add("Sweets");


        List<String> chickenItems=new ArrayList<String>();
        chickenItems.add("Chicken curry");
        chickenItems.add("Dum ka chicken");
        chickenItems.add("Masala curry");
        chickenItems.add("Raita chicken");
        chickenItems.add("Kodi curry");
        chickenItems.add("Nattu chicken");


        List<String> bewerageItems=new ArrayList<String>();
        bewerageItems.add("Alchol");
        bewerageItems.add("Whine");
        bewerageItems.add("Choclate wine");
        bewerageItems.add("Soft drinks");
        bewerageItems.add("Cafinated drinks");
        bewerageItems.add("Beer");
        bewerageItems.add("Whisky");
        bewerageItems.add("German whisky");


        footItems.put(foodHeader.get(0),fruitItems);
        footItems.put(foodHeader.get(1),juiceItems);
        footItems.put(foodHeader.get(2),eggItems);
        footItems.put(foodHeader.get(3),pizzaItems);
        footItems.put(foodHeader.get(4),desertItems);
        footItems.put(foodHeader.get(5),chickenItems);
        footItems.put(foodHeader.get(6),bewerageItems);



    }


    public View getMyToolBar()
    {
        Toolbar toolBar=new Toolbar(this);
        toolBar.setLayoutParams(new Toolbar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        RelativeLayout toolBarLAyout=new RelativeLayout(this);
        toolBarLAyout.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        ImageButton backButton=new ImageButton(this);
        RelativeLayout.LayoutParams backButtonParams=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        backButtonParams.addRule(RelativeLayout.ALIGN_START);
        backButton.setImageResource(R.drawable.ic_action_back_button);
        backButton.setBackgroundResource(0);
        toolBarLAyout.addView(backButton);

        TextView title=new TextView(this);
        title.setText("My Cafeteria");
        title.setTextColor(Color.WHITE);
        title.setTextSize(TypedValue.COMPLEX_UNIT_SP,20f);
        RelativeLayout.LayoutParams titleParams=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        titleParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        titleParams.addRule(RelativeLayout.CENTER_VERTICAL);
        title.setLayoutParams(titleParams);
        toolBarLAyout.addView(title);
        toolBar.addView(toolBarLAyout);
        return toolBar;
//        return  toolBarLAyout;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        expandableListView.setIndicatorBounds(expandableListView.getRight()-300,expandableListView.getWidth());
    }

}
