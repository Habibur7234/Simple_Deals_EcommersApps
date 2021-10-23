package com.touchnget.touchnget.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.asksira.loopingviewpager.LoopingViewPager;
import com.google.android.material.navigation.NavigationView;
import com.touchnget.touchnget.Adapter.MyBestDealsAdapter;
import com.touchnget.touchnget.Adapter.MyPopularCategoriesAdapter;
import com.touchnget.touchnget.EventBus.MenuItemBack;
import com.touchnget.touchnget.Model.PopularCategoryModel;
import com.touchnget.touchnget.R;
import com.touchnget.touchnget.ui.menu.MenuFragment;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private HomeViewModel homeViewModel;

    Unbinder unbinder;

    @BindView(R.id.recycler_popular)
    RecyclerView recycler_popular;
    @BindView(R.id.viewpager)
    LoopingViewPager viewpager;
    //@BindView(R.id.btn_load_categories)
    //Button btn_load_categories;


    LayoutAnimationController layoutAnimationController;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

       // btn_load_categories = (Button) root.findViewById(R.id.btn_load_categories);
       // btn_load_categories.setOnClickListener(this);

        unbinder = ButterKnife.bind(this,root);

        String key = getArguments().getString("restaurant");

        init();

        homeViewModel.getPopularList(key).observe(getViewLifecycleOwner(), popularCategoryModels -> {
            // create adapter
            MyPopularCategoriesAdapter adapter = new MyPopularCategoriesAdapter(getContext(), popularCategoryModels);
            recycler_popular.setAdapter(adapter);
            recycler_popular.setLayoutAnimation(layoutAnimationController);
        });

        homeViewModel.getBestDealList(key).observe(getViewLifecycleOwner(),bestDealModels -> {
            MyBestDealsAdapter adapter = new MyBestDealsAdapter(getContext(),bestDealModels,true);
            viewpager.setAdapter(adapter);
             });
        return root;



    }

    private void init() {
        layoutAnimationController = AnimationUtils.loadLayoutAnimation(getContext(),R.anim.layout_item_from_left);
        recycler_popular.setHasFixedSize(true);
        recycler_popular.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
    }

    @Override
    public void onResume() {
        super.onResume();
        viewpager.resumeAutoScroll();
    }

    @Override
    public void onPause() {
        viewpager.pauseAutoScroll();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().postSticky(new MenuItemBack());
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

//        getActivity().getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.show_fragment, new MenuFragment())
//                .addToBackStack(null)
//                .commit();

    }


}
