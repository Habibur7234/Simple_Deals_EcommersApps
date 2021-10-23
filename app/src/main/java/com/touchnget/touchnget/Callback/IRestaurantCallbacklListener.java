package com.touchnget.touchnget.Callback;

import com.touchnget.touchnget.Model.CategoryModel;
import com.touchnget.touchnget.Model.RestaurantModel;

import java.util.List;

public interface IRestaurantCallbacklListener {
    void onRestaurantLoadSuccess(List<RestaurantModel>restaurantModelList);
    void onRestaurantLoadFailed(String message);
}
