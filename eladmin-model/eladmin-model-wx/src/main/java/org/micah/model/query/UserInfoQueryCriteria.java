package org.micah.model.query;

import lombok.Data;
import org.micah.mp.annotation.Query;
import org.micah.mp.annotation.type.SelectType;

/**
* @author pangjie
* @date 2023-07-11
**/
@Data
public class UserInfoQueryCriteria{

    /**
     * 精确
     */
     @Query
     private Long id;

     /**
      * 模糊
      */
      @Query(type = SelectType.INNER_LIKE)
      private String openid;

     /**
      * 模糊
      */
      @Query(type = SelectType.INNER_LIKE)
      private String nickname;

     /**
      * 模糊
      */
      @Query(type = SelectType.INNER_LIKE)
      private String userPhone;
}