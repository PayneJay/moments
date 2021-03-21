package com.snail.common.utils;

import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.annotation.StringRes;

import com.snail.common.Constants;

public class ResourceUtil {

    /**
     * get color id
     */
    public static int getColor(int id) {
        try {
            return Constants.sApplication.getResources().getColor(id);
        } catch (Exception e) {
            Log.e(Constants.TAG, e.getMessage());
            return 0;
        }
    }

    public static String getString(int id) {
        try {
            return Constants.sApplication.getResources().getString(id);
        } catch (Exception e) {
            Log.e(Constants.TAG, e.getMessage());
            return "";
        }
    }

    /**
     * get drawable id
     */
    public static Drawable getDrawable(int id) {
        try {
            return Constants.sApplication.getResources().getDrawable(id);
        } catch (Exception e) {
            Log.e(Constants.TAG, e.getMessage());
            return null;
        }
    }

    /**
     * get resource name
     */
    public static String getResourceEntryName(@StringRes int id) {
        try {
            return Constants.sApplication.getResources().getResourceEntryName(id);
        } catch (Exception e) {
            Log.e(Constants.TAG, e.getMessage());
            return "";
        }
    }

    /**
     * getDimensionPixelSize
     */
    public static int getDimenPix(int id) {
        try {
            return Constants.sApplication.getResources().getDimensionPixelSize(id);
        } catch (Exception e) {
            Log.e(Constants.TAG, e.getMessage());
            return 0;
        }
    }

    public static float getDimen(int id) {
        try {
            return Constants.sApplication.getResources().getDimension(id);
        } catch (Exception e) {
            Log.e(Constants.TAG, e.getMessage());
            return 0;
        }
    }

}
