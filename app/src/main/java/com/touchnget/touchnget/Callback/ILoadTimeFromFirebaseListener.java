package com.touchnget.touchnget.Callback;

import com.touchnget.touchnget.Model.Order;

public interface ILoadTimeFromFirebaseListener {
    void onLoadTimeSuccess(Order order,long estimateTimeInMs);
    void onLoadTimeFailed(String message);
}
