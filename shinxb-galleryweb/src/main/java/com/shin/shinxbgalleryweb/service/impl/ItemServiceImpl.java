package com.shin.shinxbgalleryweb.service.impl;
import bean.Item;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shin.shinxbgalleryweb.dao.ItemMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import service.IItemService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Morty
 * @since 2020-01-12
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {
    //@Autowired
    //private ItemMapper itemMapper;

    @Override
    public  IPage<Item> findListByPage(Integer page, Integer pageCount){
        Page<Item> wherePage = new Page<>(page, pageCount);
        QueryWrapper<Item> querywrapper=new QueryWrapper<>();
        return   baseMapper.selectPage(wherePage,querywrapper);
    }

    @Override
    public int add(Item item){
        return baseMapper.insert(item);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Item item){
        return baseMapper.updateById(item);
    }

    @Override
    public Item findById(Long id){
        return  baseMapper.selectById(id);
    }
}
