/*
 * Copyright (C) 2016 AriaLyy(https://github.com/AriaLyy/Aria)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.arialyy.aria.core.scheduler;

import android.os.Handler;
import com.arialyy.aria.core.inf.ITask;

/**
 * Created by lyy on 2016/11/2.
 * 调度器功能接口
 */
public interface ISchedulers<Task extends ITask> extends Handler.Callback {
  /**
   * 断点支持
   */
  public static final int SUPPORT_BREAK_POINT = 9;
  /**
   * 任务预加载
   */
  public static final int PRE = 0;
  /**
   * 任务预加载完成
   */
  public static final int POST_PRE = 1;

  /**
   * 任务开始
   */
  public static final int START = 2;
  /**
   * 任务停止
   */
  public static final int STOP = 3;
  /**
   * 任务失败
   */
  public static final int FAIL = 4;
  /**
   * 任务取消
   */
  public static final int CANCEL = 5;
  /**
   * 任务完成
   */
  public static final int COMPLETE = 6;
  /**
   * 任务处理中
   */
  public static final int RUNNING = 7;
  /**
   * 恢复任务
   */
  public static final int RESUME = 8;

  /**
   * 注册下载器监听，一个观察者只能注册一次监听
   *
   * @param targetName 观察者，创建该监听器的对象类名
   * @param schedulerListener {@link ISchedulerListener}
   */
  public void addSchedulerListener(String targetName, ISchedulerListener<Task> schedulerListener);

  /**
   * @param targetName 观察者，创建该监听器的对象类名
   * 取消注册监听器
   */
  public void removeSchedulerListener(String targetName,
      ISchedulerListener<Task> schedulerListener);

  /**
   * 将当前类注册到Aria
   *
   * @param obj 观察者类
   */
  public void register(Object obj);

  /**
   * 移除注册
   *
   * @param obj 观察者类
   */
  public void unRegister(Object obj);
}