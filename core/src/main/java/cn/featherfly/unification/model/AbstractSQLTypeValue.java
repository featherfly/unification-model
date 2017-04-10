
package cn.featherfly.unification.model;

import java.io.Serializable;
import java.sql.SQLType;

/**
 * <p>
 * AbstractSQLTypeValue
 * </p>
 * 
 * @author zhongj
 *
 * @since 1.0
 * @version 1.0
 */
public abstract class AbstractSQLTypeValue<V extends Serializable> extends AbstractTypeValue<V> implements SQLType {

    private SQLType sqlType;

    /**
     * @param value
     */
    public AbstractSQLTypeValue(V value, SQLType sqlType) {
        super(value);
        this.sqlType = sqlType;
    }

    @Override
    public String getName() {
        return sqlType.getName();
    }

    @Override
    public String getVendor() {
        return sqlType.getVendor();
    }

    @Override
    public Integer getVendorTypeNumber() {
        return sqlType.getVendorTypeNumber();
    }
}
