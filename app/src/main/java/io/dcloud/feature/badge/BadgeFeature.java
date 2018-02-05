package io.dcloud.feature.badge;

import android.util.Log;
import android.widget.Toast;

import com.bozo.badger.ShortcutBadger;

import org.json.JSONArray;
import org.json.JSONException;

import io.dcloud.common.DHInterface.IWebview;
import io.dcloud.common.DHInterface.StandardFeature;

/**
 * 李留新
 * 2018-01-31
 * 说明:桌面角标扩展插件类
 */
public class BadgeFeature extends StandardFeature {
    /**
     * 李留新
     * 2018-01-31
     * 说明:设置角标显示数量
     *
     * @param iWebview  使用的页面(固定参数,必须要写)
     * @param jsonArray 显示的角标数量参数 (固定参数,必须要写)
     */
    public void setBadge(IWebview iWebview, JSONArray jsonArray) {

        int count;
        try {
            count = jsonArray.getInt(1);
            //Log.e("badge", "jsonArray=" + jsonArray);
            //Log.e("badge", "count=" + count);
            Toast.makeText(iWebview.getContext(), "count=" + count, Toast.LENGTH_SHORT).show();
            ShortcutBadger.applyCount(iWebview.getContext(), count);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 李留新
     * 2018-01-31
     * 说明:删除桌面角标
     *
     * @param iWebview  使用的页面(固定参数,必须要写)
     * @param jsonArray 显示的角标数量参数(固定参数,必须要写)
     */
    public void removeBadge(IWebview iWebview, JSONArray jsonArray) {
        ShortcutBadger.applyCount(iWebview.getContext(), 0);
    }
}
