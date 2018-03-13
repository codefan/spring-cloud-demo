package com.centit.demo.servicehi.dao;

import com.centit.demo.servicehi.po.UserAccessToken;
import com.centit.framework.core.dao.CodeBook;
import com.centit.framework.jdbc.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserAccessTokenDao extends BaseDaoImpl<UserAccessToken,String> {

    public Map<String, String> getFilterField() {
        if (filterField == null) {
            filterField = new HashMap<String, String>();
            filterField.put("tokenId", CodeBook.EQUAL_HQL_ID);
            filterField.put("userCode", CodeBook.EQUAL_HQL_ID);
        }
        return filterField;
    }
 
}
