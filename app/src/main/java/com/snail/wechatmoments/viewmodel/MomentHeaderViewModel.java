package com.snail.wechatmoments.viewmodel;

import android.content.Context;

import androidx.databinding.ObservableField;

import com.snail.base.BaseViewModel;
import com.snail.common.Constants;
import com.snail.wechatmoments.model.ProfileBean;
import com.snail.wechatmoments.model.ProfileModel;

/**
 * 朋友圈头部ViewModel
 */
public class MomentHeaderViewModel extends BaseViewModel {
    public ObservableField<String> bgImgUrl = new ObservableField<>("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTlJRALAf-76JPOLohBKzBg8Ab4Q5pWeQhF5igSfBflE_UYbqu7");
    public ObservableField<String> headImgUrl = new ObservableField<>("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=178721898,4183522783&fm=26&gp=0.jpg");
    public ObservableField<String> name = new ObservableField<>("ThoughtWorks");

    public MomentHeaderViewModel(Context context) {
        super(context);
        setViewType(Constants.RecyclerItemType.MOMENT_HEADER_ITEM_TYPE);

        requestProfile();
    }

    private void requestProfile() {
        ProfileModel.getInstance().getProfile(object -> {
            if (object instanceof ProfileBean) {
                ProfileBean profileBean = (ProfileBean) object;
                bgImgUrl.set(profileBean.getProfileimage());
                headImgUrl.set(profileBean.getAvatar());
                name.set(profileBean.getNick());
            }
        });
    }
}
