package com.puboe.snackbar;

import android.content.res.ColorStateList;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;

/**
 * Snackbar wrapper that allows for extra customization.
 *
 * @author Pablo Diaz.
 * @since 25/2/16.
 */
public class CustomSnackbar {

    private final Snackbar snackbar;

    private CustomSnackbar(Snackbar snackbar) {
        this.snackbar = snackbar;
    }

    /**
     * Make a Snackbar to display a message.
     * <p/>
     * Having a {@link android.support.design.widget.CoordinatorLayout} in your view hierarchy allows
     * Snackbar to enable certain features, such as swipe-to-dismiss and automatically moving of
     * widgets like {@link android.support.design.widget.FloatingActionButton}.
     *
     * @param view     The view o find a parent from.
     * @param text     The text to show. Can be formatted text.
     * @param duration How long to display the message. One of Snackbar.LENGTH_SHORT,
     *                 Snackbar.LENGTH_LONG, Snackbar.LENGTH_INDEFINITE or a custom duration in milliseconds.
     * @return The CustomSnackbar created.
     */
    @NonNull
    public static CustomSnackbar make(@NonNull View view, @NonNull CharSequence text, int duration) {
        return new CustomSnackbar(Snackbar.make(view, text, duration));
    }

    /**
     * Make a Snackbar to display a message.
     * <p/>
     * Having a {@link android.support.design.widget.CoordinatorLayout} in your view hierarchy allows
     * Snackbar to enable certain features, such as swipe-to-dismiss and automatically moving of
     * widgets like {@link android.support.design.widget.FloatingActionButton}.
     *
     * @param view     The view o find a parent from.
     * @param resId    The resource id of the string resource to use. Can be formatted text.
     * @param duration How long to display the message. One of Snackbar.LENGTH_SHORT,
     *                 Snackbar.LENGTH_LONG, Snackbar.LENGTH_INDEFINITE or a custom duration in milliseconds.
     * @return The CustomSnackbar created.
     */
    @NonNull
    public static CustomSnackbar make(@NonNull View view, @StringRes int resId, int duration) {
        return make(view, view.getResources().getText(resId), duration);
    }

    /**
     * Set the background color in this Snackbar.
     *
     * @param colorRes The background color resource.
     * @return The snackbar.
     */
    @NonNull
    public CustomSnackbar setBackgroundColor(@ColorRes int colorRes) {
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(snackbar.getView().getContext(), colorRes));
        return this;
    }

    /**
     * Set the action to be displayed in this Snackbar.
     *
     * @param text     Text to display.
     * @param listener Callback to be invoked when the action is clicked.
     * @return The snackbar.
     */
    @NonNull
    public CustomSnackbar setAction(CharSequence text, View.OnClickListener listener) {
        snackbar.setAction(text, listener);
        return this;
    }

    /**
     * Set the action to be displayed in this Snackbar.
     *
     * @param resId    String resource to display.
     * @param listener Callback to be invoked when the action is clicked.
     * @return The snackbar.
     */
    @NonNull
    public CustomSnackbar setAction(@StringRes int resId, View.OnClickListener listener) {
        snackbar.setAction(resId, listener);
        return this;
    }

    /**
     * Sets the text color of the action specified in setAction method.
     *
     * @param colors ColorStateList.
     * @return The snackbar.
     */
    @NonNull
    public CustomSnackbar setActionTextColor(ColorStateList colors) {
        snackbar.setActionTextColor(colors);
        return this;
    }

    /**
     * Sets the text color of the action specified in setAction method.
     *
     * @param colorRes Color resource.
     * @return The snackbar.
     */
    @NonNull
    public CustomSnackbar setActionTextColor(@ColorRes int colorRes) {
        snackbar.setActionTextColor(ContextCompat.getColor(snackbar.getView().getContext(), colorRes));
        return this;
    }

    /**
     * Update the text in this Snackbar.
     *
     * @param text The new text.
     * @return The snackbar.
     */
    @NonNull
    public CustomSnackbar setText(CharSequence text) {
        snackbar.setText(text);
        return this;
    }

    /**
     * Update the text in this Snackbar.
     *
     * @param resId The new text.
     * @return The snackbar.
     */
    @NonNull
    public CustomSnackbar setText(@StringRes int resId) {
        snackbar.setText(resId);
        return this;
    }

    /**
     * Show the snackbar.
     */
    public void show() {
        snackbar.show();
    }

    /**
     * Dismiss the snackbar.
     */
    public void dismiss() {
        snackbar.dismiss();
    }
}

