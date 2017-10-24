package com.wanwan.common.util.encrypt;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * Created by zhangyayun on 2016/12/28.
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    private String[] encryptPropNames = {"mysql.username", "mysql.password", "mongodb.username", "mongodb.password"};

    @Override
    protected String convertProperty(String propertyName, String propertyValue)
    {

        //如果在加密属性名单中发现该属性
        if (isEncryptProp(propertyName))
        {
            String decryptValue = "";
            try {
                decryptValue = ThreeDESUtil.Decrypt3DES(propertyValue);
//                System.out.println(decryptValue);
            }catch (Exception ex){

            }
            return decryptValue;
        }else {
            return propertyValue;
        }

    }

    private boolean isEncryptProp(String propertyName)
    {
        for (String encryptName : encryptPropNames)
        {
            if (encryptName.equals(propertyName))
            {
                return true;
            }
        }
        return false;
    }
}
