package com.puboe.snackbar;

import android.content.res.ColorStateList;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Snackbar wrapper that allows for extra customization.
 *
 * @author Pablo Diaz.
 * @since 25/2/16.
 */
public class CustomSnackbar {

    /**
     * The actual Snackbar.
     */
    private final Snackbar snackbar;

    /**
     * Whether or not there is a custom view set.
     */
    private boolean customView;

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
     * @param parentView The view to find a parent from.
     * @param text       The text to show. Can be formatted text.
     * @param duration   How long to display the message. One of Snackbar.LENGTH_SHORT,
     *                   Snackbar.LENGTH_LONG, Snackbar.LENGTH_INDEFINITE or a custom duration in milliseconds.
     * @return The CustomSnackbar created.
     */
    @NonNull
    public static CustomSnackbar make(@NonNull View parentView, @NonNull CharSequence text, int duration) {
        return new CustomSnackbar(Snackbar.make(parentView, text, duration));
    }

    /**
     * Make a Snackbar to display a message.
     * <p/>
     * Having a {@link android.support.design.widget.CoordinatorLayout} in your view hierarchy allows
     * Snackbar to enable certain features, such as swipe-to-dismiss and automatically moving of
     * widgets like {@link android.support.design.widget.FloatingActionButton}.
     *
     * @param parentView The view to find a parent from.
     * @param resId      The resource id of the string resource to use. Can be formatted text.
     * @param duration   How long to display the message. One of Snackbar.LENGTH_SHORT,
     *                   Snackbar.LENGTH_LONG, Snackbar.LENGTH_INDEFINITE or a custom duration in milliseconds.
     * @return The CustomSnackbar created.
     */
    @NonNull
    public static CustomSnackbar make(@NonNull View parentView, @StringRes int resId, int duration) {
        return make(parentView, parentView.getResources().getText(resId), duration);
    }

    /**
     * Make a Snackbar to display a message.
     * <p/>
     * Having a {@link android.support.design.widget.CoordinatorLayout} in your view hierarchy allows
     * Snackbar to enable certain features, such as swipe-to-dismiss and automatically moving of
     * widgets like {@link android.support.design.widget.FloatingActionButton}.
     *
     * @param parentView The view to find a parent from.
     * @param customView The custom view to display in this Snackbar.
     * @param duration   How long to display the message. One of Snackbar.LENGTH_SHORT,
     *                   Snackbar.LENGTH_LONG, Snackbar.LENGTH_INDEFINITE or a custom duration in milliseconds.
     * @return The CustomSnackbar created.
     */
    @NonNull
    public static CustomSnackbar make(@NonNull View parentView, @NonNull View customView, int duration) {
        return new CustomSnackbar(Snackbar.make(parentView, "", duration)).setView(customView);
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
     * Set the action to be displayed in this Snackbar.
     *
     * @param text     Text to display.
     * @param listener Callback to be invoked when the action is clicked.
     * @return The snackbar.
     */
    @NonNull
    public CustomSnackbar setAction(CharSequence text, View.OnClickListener listener) {
        if (!customView) {
            snackbar.setAction(text, listener);
        }
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
        if (!customView) {
            snackbar.setAction(resId, listener);
        }
        return this;
    }

    /**
     * Sets the text color.
     *
     * @param color New color.
     * @return The snackbar.
     */
    @NonNull
    public CustomSnackbar setTextColor(@ColorInt int color) {
        getTextView().setTextColor(color);
        return this;
    }

    /**
     * Set the text size to the given value, interpreted as "scaled
     * pixel" units.  This size is adjusted based on the current density and
     * user font size preference.
     *
     * @param textSize The scaled pixel size.
     * @return The snackbar.
     */
    @NonNull
    public CustomSnackbar setTextSize(float textSize) {
        getTextView().setTextSize(textSize);
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
     * @param color New color.
     * @return The snackbar.
     */
    @NonNull
    public CustomSnackbar setActionTextColor(@ColorInt int color) {
        snackbar.setActionTextColor(color);
        return this;
    }

    /**
     * Sets the text size of the action specified in setAction method to the given value,
     * interpreted as "scaled pixel" units. This size is adjusted based on the current density and
     * user font size preference.
     *
     * @param textSize The scaled pixel size.
     * @return The snackbar.
     */
    @NonNull
    public CustomSnackbar setActionTextSize(float textSize) {
        getActionButton().setTextSize(textSize);
        return this;
    }

    /**
     * Set the background color in this Snackbar.
     *
     * @param color The new background color.
     * @return The snackbar.
     */
    @NonNull
    public CustomSnackbar setBackgroundColor(@ColorInt int color) {
        snackbar.getView().setBackgroundColor(color);
        return this;
    }

    /**
     * Set a custom view to this Snackbar.
     * Once a custom view is set, this Snackbar's text and button are permanently hidden.
     *
     * @param view The custom view.
     * @return The Snackbar.
     */
    public CustomSnackbar setView(View view) {

        // Get the Snackbar's layout view
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();

        // Hide text and button.
        getTextView().setVisibility(View.INVISIBLE);
        getActionButton().setVisibility(View.GONE);

        // Remove snackbar's inner padding.
        layout.setPadding(0, 0, 0, 0);

        // Add the view to the Snackbar's layout.
        layout.addView(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        customView = true;

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

    /**
     * Get snackbar's text TextView.
     *
     * @return Snackbar's TextView.
     */
    private TextView getTextView() {
        return (TextView) snackbar.getView().findViewById(R.id.snackbar_text);
    }

    /**
     * Get snackbar's action button.
     *
     * @return Snackbar's action button.
     */
    private Button getActionButton() {
        return (Button) snackbar.getView().findViewById(R.id.snackbar_action);
    }
}

