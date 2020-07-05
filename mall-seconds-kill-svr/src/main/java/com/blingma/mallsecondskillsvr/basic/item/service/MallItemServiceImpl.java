package com.blingma.mallsecondskillsvr.basic.item.service;

import com.blingma.mallsecondskillsvr.basic.item.mapper.MallItemMapper;
import com.blingma.mallsecondskillsvr.basic.item.mapper.entity.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shihao.ma
 * @since 2020/6/3
 */
@Service
@RequiredArgsConstructor
public class MallItemServiceImpl implements MallItemService {

    private final MallItemMapper mallItemMapper;

    @Override
    public List<Item> getItems() {
        return mallItemMapper.findAll();
    }
}
