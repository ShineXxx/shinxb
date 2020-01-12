package service;

import bean.Item;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Morty
 * @since 2020-01-12
 */
public interface IItemService extends IService<Item> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Item>
     */
    IPage<Item> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param item 
     * @return int
     */
    int add(Item item);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param item 
     * @return int
     */
    int updateData(Item item);

    /**
     * id查询数据
     *
     * @param id id
     * @return Item
     */
    Item findById(Long id);
}
