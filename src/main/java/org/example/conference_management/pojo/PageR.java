package org.example.conference_management.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分装分页查询结果
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageR {

    private long total;  //总记录数
    private List record; //当前页数据集合
}
