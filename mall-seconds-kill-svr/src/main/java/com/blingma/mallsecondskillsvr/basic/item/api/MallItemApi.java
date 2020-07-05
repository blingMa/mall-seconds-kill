package com.blingma.mallsecondskillsvr.basic.item.api;

import com.blingma.mallsecondskillsvr.basic.item.mapper.entity.Item;
import com.blingma.mallsecondskillsvr.basic.item.service.MallItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shihao.ma
 * @since 2020/6/3
 */
@RestController
@RequiredArgsConstructor
@Api(tags = "商品接口API")
public class MallItemApi {

    private final MallItemService mallItemService;

    @GetMapping("/item")
    @ApiOperation("查询商品信息")
    public List<Item> getItems() {
        return mallItemService.getItems();
    }

}
