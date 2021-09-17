package com.demo.util;

import com.demo.pojo.*;
import com.demo.pojo.activity.Activity;
import com.demo.pojo.activity.BActivity;
import com.demo.pojo.activity.DetailActivity;
import com.demo.pojo.activity.MyActivity;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageUtils {
    //page页信息提取
    public static <T> PageResult<T> packPage(PageInfo<T> pageInfo){
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setSize(pageInfo.getSize());
        pageResult.setData(pageInfo.getList());
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setPages(pageInfo.getPages());
        return pageResult;
    }

    //page页信息提取
    public static <T> PageResult<T> packPageChange(PageInfo pageInfo, List<T> data) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setSize(pageInfo.getSize());
        pageResult.setData(data);
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setPages(pageInfo.getPages());
        return pageResult;
    }


    //简略活动封装
    public static BActivity BActivityPage(Activity activity) {
        BActivity bActivity = new BActivity();
        bActivity.setActivityTitle(activity.getActivityTitle());
        bActivity.setCreateTime(activity.getCreateTime());
        bActivity.setRealName(activity.getRealName());
        bActivity.setActivityImage(ImageUtils.StringToList(activity.getActivityImage()).get(0));
        bActivity.setActivityId(activity.getActivityId());
        bActivity.setActivityStatus(getStatus(activity));
        return bActivity;
    }

    //活动状态判断
    public String judgeStatus( String activityStartTime, String activityEndTime,
                                      String recruitStartTime, Integer joinNum, Integer totalNum) {
        String nowDate = DateUtils.getDate();
        if(!DateUtils.CompareTime(activityEndTime, nowDate)) {
            return "活动结束";
        }else if(!DateUtils.CompareTime(activityStartTime, nowDate)) {
            return "活动进行中";
        }else if(DateUtils.CompareTime(recruitStartTime, nowDate)) {
            return "活动未开始";
        }else {
            if(joinNum >= totalNum) {
                return "招募人数已满";
            }else {
                return "招募中";
            }
        }
    }

    //获取活动状态
    public static String getStatus(Activity activity) {
        String status = new PageUtils().judgeStatus(activity.getActivityStartTime(), activity.getActivityEndTime(),
                activity.getRecruitStartTime(), activity.getJoinNum(), activity.getTotalNum());
        return status;
    }

    //获取详细活动状态
    public static String getStatusDetail(DetailActivity activity) {
        String status = new PageUtils().judgeStatus(activity.getActivityStartTime(), activity.getActivityEndTime(),
                activity.getRecruitStartTime(), activity.getJoinNum(), activity.getTotalNum());
        return status;
    }

    //我参加的活动封装
    public static MyActivity MyActivityPage(Activity activity) {
        MyActivity myActivity = new MyActivity();
        String nowDate = DateUtils.getDate();
        myActivity.setJoinNum(activity.getJoinNum());
        myActivity.setActivityPlace(activity.getActivityPlace());
        myActivity.setActivityTitle(activity.getActivityTitle());
        myActivity.setCreateTime(activity.getCreateTime());
        myActivity.setActivityId(activity.getActivityId());
        if(!DateUtils.CompareTime(activity.getActivityEndTime(), nowDate)) {
            myActivity.setActivityStatus("活动结束");
        }else if(!DateUtils.CompareTime(activity.getActivityStartTime(), nowDate)) {
            myActivity.setActivityStatus("活动进行中");
        }else if(DateUtils.CompareTime(activity.getRecruitEndTime(), nowDate)) {
            myActivity.setActivityStatus("活动招募中");
        }
        return myActivity;
    }

    public static int pageUtils(int pageNum, int pageSize){
        int offSet = pageSize * (pageNum - 1);
        return offSet;
    }
}
