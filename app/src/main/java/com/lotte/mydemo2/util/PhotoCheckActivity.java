package com.lotte.mydemo2.util;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.beanu.arad.base.ToolBarActivity;
import com.bumptech.glide.Glide;
import com.lotte.mydemo2.R;
import com.lotte.mydemo2.view.ScaleViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * 查看图片界面；
 */
public class PhotoCheckActivity extends ToolBarActivity {

    @BindView(R.id.viewpager)
    ScaleViewPager viewpager;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.page)
    TextView page;

    private int currentItem;
    private ArrayList<String> imgPaths;
    private SamplePagerAdapter madapter;

//    private String tempPicPath = Environment.getExternalStorageDirectory() + "/shouban_image/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏,无状态栏
        setContentView(R.layout.activity_photo_check);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        if (intent != null) {
            currentItem = intent.getIntExtra("position", 0);
            imgPaths = intent.getStringArrayListExtra("list");
        }

        madapter = new SamplePagerAdapter();
        madapter.setImgPahts(imgPaths);
        viewpager.setAdapter(madapter);
        viewpager.setCurrentItem(currentItem);

        page.setText((currentItem + 1) + "/" + imgPaths.size());
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                page.setText((position + 1) + "/" + imgPaths.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class SamplePagerAdapter extends PagerAdapter {
        // int[] resourseIds = new int[]{R.drawable.fengjing, R.drawable.moo, R.drawable.bigpicture_01_5, R.drawable.bigpicture_01_6};
        List<String> imgPahts;

        public void setImgPahts(List<String> imgPahts) {
            this.imgPahts = imgPahts;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return imgPahts == null ? 0 : imgPahts.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }


        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            PhotoView photoView = new PhotoView(PhotoCheckActivity.this);
            Glide.with(PhotoCheckActivity.this).load(imgPahts.get(position)).placeholder(R.drawable.img_loading_lotte).into(photoView);
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            photoView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
                @Override
                public void onPhotoTap(View view, float x, float y) {
                    finish();
                }

                @Override
                public void onOutsidePhotoTap() {

                }
            });

            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // super.destroyItem(container, position, object);
            container.removeView((PhotoView) object);
        }
    }
}
