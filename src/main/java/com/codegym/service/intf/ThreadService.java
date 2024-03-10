package com.codegym.service.intf;

import com.codegym.model.Thread;

import java.util.List;

public interface ThreadService extends IService<Thread> {
    List<Thread> findAllByCreateAt();
    List<Thread> findAllByUserID(Long userId);
}
