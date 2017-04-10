package cn.featherfly.unification.model.jackson;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.NumberUtils;
import cn.featherfly.common.structure.typevalue.TypeValue;
import cn.featherfly.conversion.core.Conversion;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class TypeValueDeserializer<ID extends TypeValue<?>> extends JsonDeserializer<ID> {
    
    private Class<ID> type;
    
    private Class<?> valueType;

    private Conversion conversion;
    
    /**
     * @param type type
     */
    public TypeValueDeserializer(Class<ID> type) {
        this.type = type;
        valueType = ClassUtils.getSuperClassGenricType(type);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public ID deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        // TODO 使用转换器在这里进行转换
        String text = p.getText();
        if (ClassUtils.isParent(Number.class, valueType)) {
            return (ID) ClassUtils.newInstance(type, NumberUtils.parse(text, (Class<Number>) valueType));
        } else {
            return (ID) ClassUtils.newInstance(type, p.getText());
        }
        
    }

    public Conversion getConversion() {
        return conversion;
    }

    public void setConversion(Conversion conversion) {
        this.conversion = conversion;
    }
}

