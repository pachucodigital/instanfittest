package com.testinstanfit.presentation.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.testinstanfit.daniel.R;
import com.testinstanfit.domain.model.trainer.ItemTrainer;
import com.testinstanfit.presentation.adapters.viewholder.AbstractHolderBase;

/**
 * Created by Dell
 */

public class ViewHolderList extends AbstractHolderBase<ItemTrainer> {

    private TextView mTextView;
    private ImageView mImageView;
    private ProgressBar mLoader;

    public ViewHolderList(final View itemView) {
        super(itemView);
        mTextView  = itemView.findViewById(R.id.txt);
        mImageView = itemView.findViewById(R.id.img);
        mLoader    = itemView.findViewById(R.id.loader);
    }

    @Override
    public void onBind(final ItemTrainer item) {
        mTextView.setText(item.getName());
        if(mImageView != null && item.getAvatarPictures().getMedium()!= null){
            Picasso.with(mImageView.getContext())
                    .load(item.getAvatarPictures().getMedium())
                    .fit()
                    .placeholder(R.drawable.logo)
                    .error(R.drawable.logo)
                    .into(mImageView,new com.squareup.picasso.Callback() {
                        @Override
                        public void onSuccess() {
                            hideLoader();
                        }

                        @Override
                        public void onError() {
                            hideLoader();
                        }
                    });
        }
    }

    private void hideLoader() {
        if(mLoader != null){
            mLoader.setVisibility(View.GONE);
        }
    }




}
