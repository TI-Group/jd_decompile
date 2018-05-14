package butterknife;

import android.support.annotation.IntegerRes;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
/* compiled from: TbsSdkJava */
public @interface BindInt {
    @IntegerRes
    int value();
}
