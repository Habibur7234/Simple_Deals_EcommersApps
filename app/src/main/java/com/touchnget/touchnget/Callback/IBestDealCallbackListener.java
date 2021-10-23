package com.touchnget.touchnget.Callback;

import com.touchnget.touchnget.Model.BestDealModel;
import com.touchnget.touchnget.Model.PopularCategoryModel;

import java.util.List;

public interface IBestDealCallbackListener {
    void onBestDealLoadSuccess(List<BestDealModel> bestDealModels);
    void onBestDealLoadFailed(String message);
}
