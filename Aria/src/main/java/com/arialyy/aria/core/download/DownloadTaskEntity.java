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
package com.arialyy.aria.core.download;

import com.arialyy.aria.core.inf.AbsTaskEntity;
import com.arialyy.aria.orm.Ignore;
import com.arialyy.aria.orm.OneToOne;

/**
 * Created by lyy on 2017/1/23.
 * 下载任务实体
 */
public class DownloadTaskEntity extends AbsTaskEntity<DownloadEntity> {

  /**
   * 账号和密码
   */
  @Ignore public String userName, userPw, account;

  /**
   * FTP服务器文件或文件夹路径
   */
  public String remotePath;

  /**
   * 下载类型
   * {@link AbsTaskEntity#HTTP}、{@link AbsTaskEntity#FTP}
   */
  public int downloadType = HTTP;

  @OneToOne(table = DownloadEntity.class, key = "downloadPath") public DownloadEntity entity;

  /**
   * 所属的任务组组名，如果不属于任务组，则为null
   */
  public String groupName = "";

  /**
   * 该任务是否属于任务组
   */
  public boolean isGroupTask = false;

  public DownloadTaskEntity() {
  }

  @Override public DownloadEntity getEntity() {
    return entity;
  }
}
