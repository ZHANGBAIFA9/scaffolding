package com.afiab.scaffolding.dao.entity;



import com.afiab.scaffolding.dao.core.entity.DeleteableDao;
import lombok.*;

import javax.persistence.Table;

/**
 * @Version 1.0
 * @Author ZHANGBAIFA
 * @Date 2023/8/14 13:16
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "stu")
@EqualsAndHashCode(callSuper = true)
public class StuPO extends DeleteableDao {
    /**
     * 名字
     * */
    private String name;

}
