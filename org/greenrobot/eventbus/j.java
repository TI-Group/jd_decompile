package org.greenrobot.eventbus;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: TbsSdkJava */
public @interface j {
    ThreadMode a() default ThreadMode.POSTING;

    boolean b() default false;

    int c() default 0;
}
