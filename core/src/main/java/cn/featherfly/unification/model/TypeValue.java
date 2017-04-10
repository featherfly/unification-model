package cn.featherfly.unification.model;

import java.io.Serializable;

/**
 * <p>
 * value as a type
 * </p>
 * 
 * @author zhongj
 * @since 1.0
 * @version 1.0
 */
public interface TypeValue<V extends Serializable> extends Serializable{

    /**
     * 返回value
     * @return value
     */
    V getValue();
    /**
     * 返回value.class
     * @return value.class
     */
    Class<V> getValueType();
}