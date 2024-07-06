package com.example.kiddosafecard;

import android.content.Context;
import android.content.Intent;
import com.example.kiddosafecard.LoginActivity;

public class NavigationHandler {
    public static void navigateToLogin(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
}
