package com.twomonth.study.viewmodel;

import androidx.lifecycle.ViewModel;


/**
 *
 * @ProjectName:
 * @Package:        com.twomonth.study.a
 * @ClassName:      AviewModel
 * @Author:         wjc
 * @CreateDate:     2020/5/1 12:04 PM
 * @UpdateUser:     更新者
 * @UpdateDate:     2020/5/1 12:04 PM
 * @UpdateRemark:   更新内容
 * @Version:        1.0
 * @Description:    单纯的使用viewmodel存储数据，保障横竖屏翻转的时候页面数据不会丢失。
 *
 */
public class AviewModel extends ViewModel {
    private int num = 0;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
