package com.shin.shinxbgalleryweb.controller;

import bean.Item;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import result.ServiceResult;
import service.IItemService;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Morty
 * @since 2020-01-12
 */
@Slf4j
@Api(tags = {""})
@RestController
@RequestMapping("/item")
public class ItemController {

    @Resource
    private IItemService itemService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody Item item){
        return itemService.add(item);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return itemService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Item item){
        return itemService.updateData(item);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public ServiceResult<IPage<Item>> findListByPage(@RequestParam Integer page,
                                                     @RequestParam Integer pageCount){
        IPage<Item> listByPage = itemService.findListByPage(page, pageCount);
        return ServiceResult.success(listByPage);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Item findById(@PathVariable Long id){
        return itemService.findById(id);
    }

}
