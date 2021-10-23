package com.touchnget.touchnget.Callback;

import com.touchnget.touchnget.Model.BestDealModel;
import com.touchnget.touchnget.Model.CategoryModel;

import java.util.List;

public interface ICategoryCallbackListener {
    void onCategoryLoadSuccess(List<CategoryModel> categoryModelList);
    void onCategoryLoadFailed(String message);
}
