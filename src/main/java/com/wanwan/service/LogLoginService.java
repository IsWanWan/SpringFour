package com.wanwan.service;

import com.wanwan.domain.LogLogin;

/**
 * Created by wanwan on 16/10/17.
 */

public interface LogLoginService {

    LogLogin selectByPrimaryKey(Long id);
}
