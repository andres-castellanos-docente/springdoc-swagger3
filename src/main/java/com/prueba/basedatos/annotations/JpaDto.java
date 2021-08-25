package com.prueba.basedatos.annotations;

/**
 * @description significa anotación personalizada, agregado a la clase significa que es una clase JpaDto
 *
 * @author bazhandao
 * @date 2020/3/26 16:39
 * @since JDK1.8
 */

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Documented
@Component
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JpaDto {

}
