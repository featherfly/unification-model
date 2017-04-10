
package cn.featherfly.unification.model;

import cn.featherfly.common.lang.ClassUtils;

import java.io.Serializable;

/**
 * <p>
 * AbstractTypeValue
 * </p>
 * 
 * @author zhongj
 *
 * @since 1.0
 * @version 1.0
 */
public abstract class AbstractTypeValue<V extends Serializable> implements TypeValue<V> {

    private static final long serialVersionUID = 5165367420053111628L;

    private V value;
    
    private Class<V> type;
    
    /**
     * @param value value
     */
    public AbstractTypeValue(V value) {
        super();
        this.value = value;
        this.type = ClassUtils.getSuperClassGenricType(this.getClass());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V getValue() {
        return value;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Class<V> getValueType() {
        return type;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        if (value != null) { 
            return value.toString();
        } else {
            return "";
        }
    }
}
