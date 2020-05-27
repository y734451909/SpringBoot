package com.hx.swagger2.toos;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuditLog {
    String title() default "";

    String desc() default "";

    BusinessType businessType() default BusinessType.OTHER;

    PlatformType platformType() default PlatformType.MANAGE;

    boolean isSaveRequestData() default true;
}

