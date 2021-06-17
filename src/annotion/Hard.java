package annotion;

import java.lang.annotation.*;

/**
 * @author liu yicheng
 * @date 2021/6/16 - 23:11
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Hard {
}
