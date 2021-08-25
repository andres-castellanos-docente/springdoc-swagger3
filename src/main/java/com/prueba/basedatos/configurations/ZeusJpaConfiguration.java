package com.prueba.basedatos.configurations;

import com.prueba.basedatos.annotations.JpaDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.support.GenericConversionService;

import javax.annotation.PostConstruct;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Map;

/**
 * @description
 *
 * @author bazhandao
 * @date 2020/3/26 17:51
 * @since JDK1.8
 */
@Configuration
public class ZeusJpaConfiguration {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * Inicializar e inyectar el Convertidor correspondiente a @JpaDto
     */
    @PostConstruct
    public void init() {
        Map<String, Object> map = applicationContext.getBeansWithAnnotation(JpaDto.class);
        for (Object o : map.values()) {
            Class c = o.getClass();
            GenericConversionService genericConversionService = ((GenericConversionService) DefaultConversionService.getSharedInstance());
            genericConversionService.addConverter(Map.class, c, m -> {
                try {
                    Object obj = c.newInstance();
                    // Aquí se puede ampliar, el convertidor inyectado se da cuenta de que el resultado de la búsqueda sql es un campo subrayado en la base de datos, que se convierte en un nombre de caso camel a través del programa y luego se establece en la entidad
                    // El juicio de conversión de tipo también se puede realizar. El juicio de tipo no se realiza aquí. Copiar directamente a dto. Pueden ocurrir errores cuando el tipo no coincide.
                    return copyMapToObj(m, obj);
                } catch (Exception e) {
                    throw new FatalBeanException("Error de conversión de resultado de Jpa, class =" + c.getName(), e);
                }
            });
        }
    }

    /**
     * Copie el valor en el mapa al campo correspondiente en el bean
     * @author bazhandao
     * @date 2020-03-26
     * @param map
     * @param target
     * @return
     */
    private Object copyMapToObj(Map<String, Object> map, Object target) {
        if(map == null || target == null || map.isEmpty()){
            return target;
        }
        Class<?> actualEditable = target.getClass();
        PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(actualEditable);
        for (PropertyDescriptor targetPd : targetPds) {
            if(targetPd.getWriteMethod() == null) {
                continue;
            }
            try {
                String key = targetPd.getName();
                Object value = map.get(key);
                if (value == null) {
                    continue;
                }
                Method writeMethod = targetPd.getWriteMethod();
                if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                    writeMethod.setAccessible(true);
                }
                if (value.getClass().getName()!="java.math.BigInteger"){
                    writeMethod.invoke(target, value);
                } else {
                    writeMethod.invoke(target,new Long(value.toString()));
                }

            } catch (Exception ex) {
                throw new FatalBeanException("Could not copy properties from source to target", ex);
            }
        }
        return target;
    }
}
