package com.touchnget.touchnget.Callback;

import com.touchnget.touchnget.Database.CartItem;
import com.touchnget.touchnget.Model.CategoryModel;
import com.touchnget.touchnget.Model.FoodModel;

public interface ISearchCategoryCallbackListener {
    void onSearchCategoryFound(CategoryModel categoryModel, CartItem cartItem);
    void onSearchCategoryNotFound(String message);
}
