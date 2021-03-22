package com.snail.wechatmoments.viewmodel;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.databinding.ObservableField;

import com.snail.base.BaseViewModel;
import com.snail.common.Constants;
import com.snail.common.utils.ToastUtil;
import com.snail.wechatmoments.R;
import com.snail.wechatmoments.model.ProfileBean;
import com.snail.wechatmoments.model.ProfileModel;

/**
 * 朋友圈头部ViewModel
 */
public class MomentHeaderViewModel extends BaseViewModel implements View.OnClickListener {
    public ObservableField<String> bgImgUrl = new ObservableField<>("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTlJRALAf-76JPOLohBKzBg8Ab4Q5pWeQhF5igSfBflE_UYbqu7");
    public ObservableField<String> headImgUrl = new ObservableField<>("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=178721898,4183522783&fm=26&gp=0.jpg");
    public ObservableField<String> name = new ObservableField<>("ThoughtWorks");
    private Dialog mCameraDialog;

    public MomentHeaderViewModel(Context context) {
        super(context);
        setViewType(Constants.RecyclerItemType.MOMENT_HEADER_ITEM_TYPE);

        requestProfile();
    }

    public void viewProfile() {
        ToastUtil.showMsg("查看个人信息");
    }

    public void changeCover() {
        if (mCameraDialog == null) {
            mCameraDialog = new Dialog(context, R.style.BottomDialog);
        }
        LinearLayout root = (LinearLayout) LayoutInflater.from(context).inflate(
                R.layout.bottom_dialog, null);
        //初始化视图
        root.findViewById(R.id.btn_open_camera).setVisibility(View.GONE);
        TextView changeCover = root.findViewById(R.id.btn_choose_img);
        changeCover.setText("更换相册封面");
        changeCover.setOnClickListener(this);
        root.findViewById(R.id.btn_cancel).setOnClickListener(this);
        mCameraDialog.setContentView(root);
        Window dialogWindow = mCameraDialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = 0; // 新位置Y坐标
        lp.width = (int) context.getResources().getDisplayMetrics().widthPixels; // 宽度
        root.measure(0, 0);
        lp.height = root.getMeasuredHeight();

        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        mCameraDialog.show();
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

    @Override
    public void onClick(View v) {
        if (mCameraDialog != null) {
            mCameraDialog.dismiss();
        }
    }
}
