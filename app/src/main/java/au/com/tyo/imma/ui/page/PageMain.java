package au.com.tyo.imma.ui.page;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.stfalcon.frescoimageviewer.ImageViewer;
import com.stfalcon.frescoimageviewer.ImageViewerAdapter;

import java.util.ArrayList;
import java.util.List;

import au.com.tyo.android.images.utils.BitmapUtils;
import au.com.tyo.imma.Controller;
import au.com.tyo.imma.R;

import static com.stfalcon.frescoimageviewer.ImageViewerAdapter.IMAGE_VIEW_TYPE_PLAIN;

/**
 * Created by Eric Tang (eric.tang@tyo.com.au) on 27/11/17.
 */

public class PageMain extends PageCommon {

    private Bitmap bitmap;
    private List<Bitmap> list;

    private static final int[] ids = new int[]{
            R.id.firstImage, R.id.secondImage,
            R.id.thirdImage, R.id.fourthImage,
            R.id.fifthImage, R.id.sixthImage,
            R.id.seventhImage, R.id.eighthImage,
            R.id.ninethImage
    };

    private ImageViewer.Builder imageViewerBuilder;

    public static class ImageAdapter extends ImageViewerAdapter {

         public ImageAdapter(Context context, ImageViewer.DataSet<?> dataSet, ImageRequestBuilder imageRequestBuilder, GenericDraweeHierarchyBuilder hierarchyBuilder, boolean isZoomingAllowed) {
            super(context, dataSet, imageRequestBuilder, hierarchyBuilder, isZoomingAllowed);
        }
    }

    /**
     * @param controller
     * @param activity
     */
    public PageMain(Controller controller, Activity activity) {
        super(controller, activity);

        setContentViewResId(R.layout.image_grid);

        bitmap = BitmapUtils.drawableToBitmap(activity.getResources().getDrawable(R.drawable.monalisa_small));
        list = new ArrayList();
        list.add(bitmap);
        for (int i = 1; i < ids.length; ++i)
            list.add(null/*Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight())*/);

    }

    @Override
    public void onActivityStart() {
        super.onActivityStart();

        if (!controller.hasUserLoggedIn()) {
            controller.getUi().gotoLoginPage();

            finish();
        }

        startBackgroundTask();
    }

    @Override
    public void setupComponents() {
        super.setupComponents();

        imageViewerBuilder = new ImageViewer.Builder<>(getActivity(), list)
                .setImageViewType(IMAGE_VIEW_TYPE_PLAIN);
    }

    protected void showPicker(int startPosition) {
            imageViewerBuilder.setStartPosition(startPosition)
            .show();
    }

    protected void init() {
        for (int i = 0; i < ids.length; i++) {
            ImageView drawee = (ImageView) findViewById(ids[i]);
            initDrawee(drawee, i);
        }
    }

    private void initDrawee(ImageView drawee, final int startPosition) {
        drawee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPicker(startPosition);
            }
        });
        drawee.setAdjustViewBounds(true);
        drawee.setImageBitmap(list.get(startPosition));
        drawee.setScaleType(ImageView.ScaleType.CENTER_CROP);
        drawee.invalidate();
    }

    @Override
    public void run() {
        // Grayscale Image
        list.set(1, BitmapUtils.toGrayscale(bitmap));
        list.set(2, BitmapUtils.toSepia(bitmap));
        list.set(3, BitmapUtils.toInvert(bitmap));
        list.set(4, BitmapUtils.toBinary(bitmap));
        list.set(5, BitmapUtils.toAlphaBlue(bitmap));
        list.set(6, BitmapUtils.toAlphaPink(bitmap));
        list.set(7, BitmapUtils.redIt(bitmap));
        list.set(8, BitmapUtils.greenIt(bitmap));
    }

    @Override
    protected void onPageBackgroundTaskFinished() {
        super.onPageBackgroundTaskFinished();

        init();
    }
}
